package com.cars.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dtos.CarDTO;
import com.cars.api.services.CarService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID createCar(@RequestBody @Valid CarDTO car) {
        return carService.createCar(car);
    }

    @GetMapping()
    public List<CarDTO> listCars() {
        return carService.listCars();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable UUID id, @RequestBody CarDTO car) {
        carService.updateCar(id, car);
    }
}
