package com.example.bus_management.service;

import com.example.bus_management.entity.Driver;
import com.example.bus_management.model.DriverModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {

    ObjectMapper objectMapper;
    private static final List<Driver> driverList = new ArrayList<>();
    private static int AUTO_ID = 10000;

    public List<DriverModel> getAllDriver() {
        List<DriverModel> driverModelList = new ArrayList<>();
        driverList.forEach(driver -> {
            DriverModel driverModel = objectMapper.convertValue(driver, DriverModel.class);
            driverModelList.add(driverModel);
        });
        return driverModelList;
    }

    public void createNewDriver(DriverModel driverModel) {
        Driver driver = objectMapper.convertValue(driverModel, Driver.class);
        driver.setId(AUTO_ID);
        AUTO_ID++;
        driverList.add(driver);
    }

    public DriverModel findDriverModelById(int id) {
        for (Driver driver : driverList) {
            if (driver.getId() == id) return objectMapper.convertValue(driver, DriverModel.class);
        }
        return null;
    }

    public void updateDriver(DriverModel driverModel) {
        Driver driver = findDriverById(driverModel.getId());
        driver.setName(driverModel.getName());
        driver.setAddress(driverModel.getAddress());
        driver.setPhone(driverModel.getPhone());
        driver.setLevel(driverModel.getLevel());
    }

    private Driver findDriverById(int id) {
        for (Driver driver : driverList) {
            if (driver.getId() == id) return driver;
        }
        return null;
    }

    public void deleteDriver(int id) {
        driverList.removeIf(driver -> driver.getId() == id
        );
    }
}
