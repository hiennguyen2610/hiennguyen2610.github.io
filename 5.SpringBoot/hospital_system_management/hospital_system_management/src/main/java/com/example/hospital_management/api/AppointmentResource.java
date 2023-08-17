package com.example.hospital_management.api;

import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.model.request.AppointmentRequest;
import com.example.hospital_management.repository.AppointmentRepository;
import com.example.hospital_management.service.AppointmentService;
import com.example.hospital_management.statics.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentResource {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/public/create")
    public ResponseEntity<?> create(@RequestBody AppointmentRequest appointmentRequest){
        Appointment result = appointmentService.create(appointmentRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/public/appointmentByDoctor")
    public ResponseEntity<?> appointmentByDoctor(@RequestParam Long doctorId, @RequestParam Date date){
        List<Appointment> result = appointmentService.findByDoctor(doctorId, date);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/public/myAppointment")
    public ResponseEntity<?> myAppointment(@RequestParam String param){
        List<Appointment> result = appointmentRepository.myAppointment(param);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<?> allApointment(@RequestParam(value = "start", required = false) Date start,
                                           @RequestParam(value = "end", required = false) Date end,
                                           @RequestParam(value = "param", required = false) String param,
                                           Pageable pageable){
        if(start == null || end == null){
            start = Date.valueOf("2000-01-01");
            end = Date.valueOf("2200-01-01");
        }
        if (param == null){
            param = "";
        }
        Page<Appointment> result = appointmentRepository.findByAdmin(start,end,"%"+param+"%",pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/admin/all-status")
    public ResponseEntity<?> getAllApt(){
        AppointmentStatus[] result = AppointmentStatus.values();
        List<AppointmentStatus> list = new LinkedList<>(Arrays.asList(result));
        list.removeIf(p -> p.equals(AppointmentStatus.CANCELLED));
        list.removeIf(p -> p.equals(AppointmentStatus.DELETED));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping("/admin/accept")
    public void accept(@RequestParam(value = "id") Long id, @RequestParam("status") String status){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        System.out.println("============ status: "+status);
        if (appointment.isPresent()) {
            for (AppointmentStatus s : AppointmentStatus.values()) {
                if (s.name().equals(status)){
                    System.out.println(s+"-0");
                    appointment.get().setAppointmentStatus(s);
                    appointmentRepository.save(appointment.get());
                    return;
                }
            }
        }
    }




}
