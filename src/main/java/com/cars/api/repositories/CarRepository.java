package com.cars.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.api.models.Car;

public interface CarRepository extends JpaRepository<Car, UUID> {

}
