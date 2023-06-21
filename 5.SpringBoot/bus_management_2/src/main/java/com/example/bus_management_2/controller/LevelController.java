package com.example.bus_management_2.controller;

import com.example.bus_management_2.model.responce.LevelResponce;
import com.example.bus_management_2.service.LevelService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LevelController {
    LevelService levelService;

    @GetMapping
    public List<LevelResponce> getAll(){
        return levelService.getAll();
    }

}
