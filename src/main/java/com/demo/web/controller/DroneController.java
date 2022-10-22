package com.demo.web.controller;

import com.demo.service.DroneService;
import com.demo.web.data.DroneDto;
import com.demo.web.data.MedicationDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/api/drones", produces = "application/json", consumes = "application/json")
public class DroneController {
    final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DroneDto createDrone(@Valid @RequestBody DroneDto droneDto) {
        return droneService.createDrone(droneDto);
    }

    @PostMapping("/{droneId}/medications")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MedicationDto> loadDroneMedication(@RequestBody @Valid List<MedicationDto> medicationDtos,
                                                   @PathVariable UUID droneId) {
        return medicationDtos;
    }
}
