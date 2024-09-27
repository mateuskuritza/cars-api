package com.cars.api.dtos;

import java.util.Date;

import com.cars.api.models.Car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record CarDTO(
                @NotBlank @NotNull String modelo,
                @NotBlank @NotNull String fabricante,
                @NotBlank @NotNull @PastOrPresent Date dataFabricacao,
                @NotBlank @NotNull @Positive double valor,
                @NotBlank @NotNull @Positive int anoModelo) {

        public static CarDTO fromCar(Car car) {
                return new CarDTO(
                                car.getModelo(),
                                car.getFabricante(),
                                car.getDataFabricacao(),
                                car.getValor(),
                                car.getAnoModelo());
        }
}
