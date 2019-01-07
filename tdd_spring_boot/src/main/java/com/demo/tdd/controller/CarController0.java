package com.demo.tdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.tdd.domain.Car;
import com.demo.tdd.service.CarService;

// @RestController
public class CarController0 {

	private CarService carService;

	public CarController0(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}

}
