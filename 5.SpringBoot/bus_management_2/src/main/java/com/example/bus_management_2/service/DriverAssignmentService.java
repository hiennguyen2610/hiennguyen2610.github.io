package com.example.bus_management_2.service;

import com.example.bus_management_2.entity.Route;
import com.example.bus_management_2.entity.Driver;
import com.example.bus_management_2.entity.DriverAssignment;
import com.example.bus_management_2.model.request.*;
import com.example.bus_management_2.model.responce.DriverAssignmentResponce;
import com.example.bus_management_2.validation.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverAssignmentService {
    ObjectMapper objectMapper;
    DriverService driverService;
    RouteService routeService;
     static List<DriverAssignment> driverAssignments = new ArrayList<>();
     static int AUTO_ID = 1;

    public List<DriverAssignmentCreateRequest> getAllDriverAssignment() {
        List<DriverAssignmentCreateRequest> rs =  new ArrayList<>();
        driverAssignments.forEach(s->{
            DriverAssignmentCreateRequest driverAssignmentCreateRequest = DriverAssignmentCreateRequest.builder()
                    .id(s.getId())
                    .driverId(s.getDriver().getId())
                    .driverName(s.getDriver().getName())
                    .routeId(s.getRoute().getId())
                    .routeName(s.getRoute().getName())
                    .quantity(s.getQuantity())
                    .date(s.getDate())
                    .build();
            rs.add(driverAssignmentCreateRequest);
        });
        return rs;
    }

    public void createNewDriverAssignment(DriverAssignmentCreateRequest driverAssignmentCreateRequest) {
        if (driverAssignmentCreateRequest == null) {
            return;
        }
        Integer idDriver = driverAssignmentCreateRequest.getDriverId();
        DriverUpdateRequest driverCreateRequest = driverService.findById(idDriver);
        Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        if (driver == null) {
            return;
        }
        Integer idRoute = driverAssignmentCreateRequest.getRouteId();
        RouteUpdateRequest buslineCreateRequest = routeService.findById(idRoute);
        Route route = objectMapper.convertValue(buslineCreateRequest, Route.class);
        if (route == null) {
            return;
        }
        DriverAssignment driverAssignment = DriverAssignment.builder()
                .driver(driver)
                .route(route)
                .quantity(driverAssignmentCreateRequest.getQuantity())
                .build();
        driverAssignment.setId(AUTO_ID);
        AUTO_ID++;
        driverAssignments.add(driverAssignment);
    }

    public DriverAssignmentCreateRequest findDriverAssignmentById(int id) {

        for (DriverAssignment d : driverAssignments) {
            if (d.getId() == id) {
                return DriverAssignmentCreateRequest.builder()
                        .id(d.getId())
                        .driverId(d.getDriver().getId())
                        .driverName(d.getDriver().getName())
                        .routeId(d.getRoute().getId())
                        .routeName(d.getRoute().getName())
                        .quantity(d.getQuantity())
                        .date(d.getDate())
                        .build();
            }
        }
        return null;

    }

    public void update(@Valid DriverAssignmentUpdateRequest driverAssignmentUpdateRequest) {
        driverAssignments.forEach(s -> {
            if (s.getId() != driverAssignmentUpdateRequest.getId()) {
                return;
            }
            DriverUpdateRequest driverUpdateRequest = driverService.findById(driverAssignmentUpdateRequest.getDriverId());
            Driver driver = objectMapper.convertValue(driverUpdateRequest, Driver.class);

            RouteUpdateRequest buslineUpdateRequest = routeService.findById(driverAssignmentUpdateRequest.getRouteId());
            Route route = objectMapper.convertValue(buslineUpdateRequest, Route.class);
            s.setDriver(driver);
            s.setRoute(route);
            s.setQuantity(driverAssignmentUpdateRequest.getQuantity());
            s.setDate(driverAssignmentUpdateRequest.getDate());
        });
    }

    public DriverAssignmentResponce findByIdVer2(Integer id) {
        Optional<DriverAssignment> driverAssignmentOptional = driverAssignments.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverAssignmentOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy lượt phân công mang mã " + id);
        }
        DriverAssignment driverAssignment = driverAssignmentOptional.get();
        return objectMapper.convertValue(driverAssignment, DriverAssignmentResponce.class);
    }
}
