package com.cars.api.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.cars.api.dtos.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cars")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private Date dataFabricacao;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int anoModelo;

    public Car(CarDTO car) {
        this.modelo = car.modelo();
        this.fabricante = car.fabricante();
        this.dataFabricacao = car.dataFabricacao();
        this.valor = car.valor();
        this.anoModelo = car.anoModelo();
    }

    public Car(UUID id, CarDTO car) {
        this.id = id;
        this.modelo = car.modelo();
        this.fabricante = car.fabricante();
        this.dataFabricacao = car.dataFabricacao();
        this.valor = car.valor();
        this.anoModelo = car.anoModelo();
    }
}
