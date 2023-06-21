package com.example.bus_management_2.service;

import com.example.bus_management_2.entity.Route;
import com.example.bus_management_2.model.request.RouteCreateRequest;
import com.example.bus_management_2.model.request.RouteUpdateRequest;
import com.example.bus_management_2.model.responce.RouteResponce;
import com.example.bus_management_2.validation.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RouteService {
    ObjectMapper objectMapper;
    List<Route> routes;
    private static int AUTO_ID = 1;


    public List<Route> getAllRoute() {
        return routes;
    }

    public void saveRoute(RouteCreateRequest routeCreateRequest) {
        Route route = objectMapper.convertValue(routeCreateRequest, Route.class);
        route.setId(AUTO_ID);
        routes.add(route);
        AUTO_ID++;

    }

    public void delete(int id) {
        routes.removeIf(a -> a.getId() == id);
    }

    public RouteUpdateRequest findById(Integer id) {
        Optional<Route> routeOptional = routes
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (routeOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy tuyến mang mã " + id);
        }
        Route route = routeOptional.get();
        return objectMapper.convertValue(route, RouteUpdateRequest.class);

    }

    public void updateRoute(@Valid RouteUpdateRequest routeUpdateRequest) {
        routes.forEach(s -> {
            if (s.getId() != routeUpdateRequest.getId()) {
                return;
            }
            s.setId(routeUpdateRequest.getId());
            s.setName(routeUpdateRequest.getName());
            s.setDistance(routeUpdateRequest.getDistance());
            s.setStopover(routeUpdateRequest.getStopover());
        });
    }

    public RouteResponce findByIdVer2(Integer id) {
        Optional<Route> routeOptional = routes.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (routeOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy tuyến xe mang mã " + id);
        }
        Route route = routeOptional.get();
        return objectMapper.convertValue(route, RouteResponce.class);
    }
}
