package com.demo.web.data;

import com.demo.domain.Drone;
import org.modelmapper.ModelMapper;

public class DroneMapper {

    private DroneMapper() {
    }

    public static DroneDto mapToDroneDto(Drone gateway) {
        var modelMapper = new ModelMapper();
        var dtoMapper = modelMapper.createTypeMap(Drone.class, DroneDto.class);
        return dtoMapper.map(gateway);
    }

    public static Drone mapToDrone(DroneDto gatewayDto) {
        var modelMapper = new ModelMapper();
        var dtoMapper = modelMapper.createTypeMap(DroneDto.class, Drone.class);
        return dtoMapper.map(gatewayDto);
    }
}
