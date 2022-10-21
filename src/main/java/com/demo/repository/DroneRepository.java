package com.demo.repository;

import com.demo.domain.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DroneRepository extends JpaRepository<Drone, UUID> {
}
