package com.cars.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cars.api.dtos.CarDTO;
import com.cars.api.models.Car;
import com.cars.api.repositories.CarRepository;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public UUID createCar(CarDTO car) {
        return carRepository.save(new Car(car)).getId();
    }

    public List<CarDTO> listCars() {
        return carRepository.findAll().stream().map(CarDTO::fromCar).toList();
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

    public void updateCar(UUID id, CarDTO car) {
        carRepository.findById(id).ifPresent(carToUpdate -> carRepository.save(new Car(id, car)));
    }
}
