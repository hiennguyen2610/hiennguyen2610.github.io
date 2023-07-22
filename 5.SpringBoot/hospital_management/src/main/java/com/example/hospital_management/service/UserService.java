package com.example.hospital_management.service;

import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Otp;
import com.example.hospital_management.entity.Role;
import com.example.hospital_management.entity.User;
import com.example.hospital_management.exception.ActivatedAccountException;
import com.example.hospital_management.exception.ExistedUserException;
import com.example.hospital_management.exception.OtpExpiredException;
import com.example.hospital_management.exception.RefreshTokenNotFoundException;
import com.example.hospital_management.model.request.CreateUserRequest;
import com.example.hospital_management.model.request.RefreshTokenRequest;
import com.example.hospital_management.model.request.RegistrationRequest;
import com.example.hospital_management.model.request.ResetPasswordRequest;
import com.example.hospital_management.model.response.JwtResponse;
import com.example.hospital_management.model.response.UserResponse;
import com.example.hospital_management.repository.*;
import com.example.hospital_management.security.CustomUserDetails;
import com.example.hospital_management.security.JwtUtils;
import com.example.hospital_management.security.SecurityUtils;
import com.example.hospital_management.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    final PasswordEncoder passwordEncoder;
    @Autowired
    final UserRepository userRepository;
    @Autowired
    final RoleRepository roleRepository;
    @Autowired
    final ObjectMapper objectMapper;
    @Autowired
    final RefreshTokenRepository refreshTokenRepository;

    @Autowired
    final EmailService emailService;

    @Autowired
    final DoctorRepository doctorRepository;

    @Autowired
    OtpRepository otpRepository;


    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    final JwtUtils jwtUtils;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       RoleRepository roleRepository, ObjectMapper objectMapper,
                       RefreshTokenRepository refreshTokenRepository, EmailService emailService, DoctorRepository doctorRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.refreshTokenRepository = refreshTokenRepository;
        this.emailService = emailService;
        this.doctorRepository = doctorRepository;
        this.jwtUtils = jwtUtils;
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .name(registrationRequest.getName().equals("") ? registrationRequest.getEmail() : registrationRequest.getName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        emailService.sendActivationEmail(user.getEmail());

    }

    public void registerDoctor(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.DOCTOR);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        Doctor doctor = Doctor.builder()
                .user(User.builder()
                        .email(registrationRequest.getEmail())
                        .password(passwordEncoder.encode(registrationRequest.getPassword()))
                        .roles(roles)
                        .name(registrationRequest.getName())
                        .build())
                .phone(registrationRequest.getPhone())
                .dob((registrationRequest.getDob()))
                .doctorLevel(registrationRequest.getDoctorLevel())
                .address(registrationRequest.getAddress())
                .introduce(registrationRequest.getIntroduce())
                .build();
        doctorRepository.save(doctor);
    }


    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream().map(u -> objectMapper.convertValue(u, UserResponse.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserResponse getDetail(Long id) throws ClassNotFoundException {
        return userRepository.findById(id).map(u -> objectMapper.convertValue(u, UserResponse.class)).orElseThrow(ClassNotFoundException::new);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));


        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        refreshTokenRepository.logOut(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    public void createUser(CreateUserRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (!userOptional.isEmpty()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.USER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode("123"))
                .roles(roles)
                .build();
        userRepository.save(user);
    }

    // Active account
    public void activeAccount(String email) throws ActivatedAccountException {
        Optional<User> userOptional=userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            User user=userOptional.get();
            if (!user.isActivated()){
                user.setActivated(true);
                userRepository.save(user);
            }
            else {
                throw new ActivatedAccountException("Tài Khoản Đã Được Kích Hoạt RỒi");
            }
        }
    }

    public Optional<Object> findByEmailAndActivated(String email) {
        return userRepository.findByEmailAndActivated(email, true);
    }

    public void sendOtp(String email) {
        emailService.sendOtp(email);
    }

    public void checkOtp(String otpCode) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(otpCode).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
    }

    public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws OtpExpiredException {
        Otp otp = otpRepository.findByOtpCode(resetPasswordRequest.getOtpCode()).get();
        if (LocalDateTime.now().isAfter(otp.getExpiredAt())) {
            throw new OtpExpiredException();
        }
        User user = otp.getUser();
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);
    }
}