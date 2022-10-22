package com.demo.service;

import com.demo.repository.DroneRepository;
import com.demo.web.data.DroneDto;
import com.demo.web.data.DroneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl implements DroneService {
    final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public DroneDto createDrone(DroneDto droneDto) {
        var drone = droneRepository.save(DroneMapper.mapToDrone(droneDto));
        droneDto.setId(drone.getId());
        return droneDto;
    }
}
