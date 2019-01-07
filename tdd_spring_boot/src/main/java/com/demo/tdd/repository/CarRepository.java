package com.demo.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tdd.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);

}