package com.example.bus_management_2.service;

import com.example.bus_management_2.entity.Driver;
import com.example.bus_management_2.model.request.DriverCreateRequest;
import com.example.bus_management_2.model.request.DriverUpdateRequest;
import com.example.bus_management_2.model.responce.DriverResponce;
import com.example.bus_management_2.statics.Level;
import com.example.bus_management_2.validation.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverService {

    ObjectMapper objectMapper;
    List<Driver> drivers ;
    private static int AUTO_ID = 1;


    public List<Driver> getAllDriver() {
        return drivers;
    }
    public void saveDriver(DriverCreateRequest driverCreateRequest) {
        Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        driver.setId(AUTO_ID);
        drivers.add(driver);
        AUTO_ID++;

    }

    public void delete(int id) {
        drivers.removeIf(a->a.getId() == id);
    }

    public DriverUpdateRequest findById(Integer id) {
        Optional<Driver> driverOptional = drivers
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy sinh viên mang mã " + id);
        }
        Driver driver = driverOptional.get();
        return objectMapper.convertValue(driver, DriverUpdateRequest.class);

    }

    public void updateDriver(DriverUpdateRequest driverUpdateRequest) {
        drivers.forEach(s->{
            if(s.getId() != driverUpdateRequest.getId()){
                return;
            }
            s.setId(driverUpdateRequest.getId());
            s.setName(driverUpdateRequest.getName());
            s.setAddress(driverUpdateRequest.getAddress());
            s.setPhone(driverUpdateRequest.getPhone());
            s.setLevel(Level.valueOf(driverUpdateRequest.getLevel()));

        });
    }

    public DriverResponce findByIdVer2(Integer id) {
        Optional<Driver> driverOptional = drivers
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy lái xe mang mã " + id);
        }
        Driver driver = driverOptional.get();
        return objectMapper.convertValue(driver, DriverResponce.class);
    }
}
