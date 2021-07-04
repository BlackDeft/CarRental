package com.jacekstachecki.carRentals.Controller;

import com.jacekstachecki.carRentals.Domain.Car;
import com.jacekstachecki.carRentals.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping(path = "/Car")
    public List<Car> getCar(){
        return carService.getCar();
    }

    @PostMapping(path = "/Car/add")
    public void addCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @PostMapping(path = "/Car/edit")
    public void editCar(@RequestBody Car car){
        carService.editCar(car);
    }

    @PostMapping(path = "/Car/delete")
    public void deleteCar(@RequestBody Car car){
        carService.deleteCar(car);
    }


}
