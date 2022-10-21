package com.demo.controller;

import com.demo.service.DroneService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/drones", produces = "application/json", consumes = "application/json")
public class DroneController {
    final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }
}
