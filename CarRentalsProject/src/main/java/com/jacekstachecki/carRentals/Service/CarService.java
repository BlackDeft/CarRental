package com.jacekstachecki.carRentals.Service;

import com.jacekstachecki.carRentals.Domain.Car;
import com.jacekstachecki.carRentals.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    public final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCar() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
      if(!(car.getBrand().trim().length() > 0))
            throw new IllegalStateException("Whats the brand of the car ?");
        if(!(car.getPlate().trim().length() > 0))
            throw new IllegalStateException("Whats the plate fo the car ?");
        Optional<Car> carByPlate = carRepository
                    .findCarByPlate(car.getPlate());
        if(carByPlate.isPresent()){
            throw new IllegalStateException("A car with this plate already exists");
        }
        carRepository.save(car);
    }

    public void editCar(Car car) {
        if(car.getBrand() == "")
            car.setBrand(carRepository.getById(car.getId()).getBrand());
        if(car.getPlate() == "")
            car.setPlate(carRepository.getById(car.getId()).getPlate());

        carRepository.save(car);
    }

    public void deleteCar(Car car) {
        if(!(car.getId()==null))
        carRepository.delete(carRepository.getById(car.getId()));
    }
}
