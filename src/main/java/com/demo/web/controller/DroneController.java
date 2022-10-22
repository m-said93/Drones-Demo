package com.demo.web.controller;

import com.demo.service.DroneService;
import com.demo.web.data.DroneDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/drones", produces = "application/json", consumes = "application/json")
public class DroneController {
    final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DroneDto createGateway(@Valid @RequestBody DroneDto droneDto) {
        return droneDto;
    }
}
