package com.jacekstachecki.carRentals.Controller;

import com.jacekstachecki.carRentals.Domain.Car;
import com.jacekstachecki.carRentals.Domain.Rentals;
import com.jacekstachecki.carRentals.Repository.CarRepository;
import com.jacekstachecki.carRentals.Repository.RentalsRepository;
import com.jacekstachecki.carRentals.Service.CarService;
import com.jacekstachecki.carRentals.Service.RentalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalsController {

    private final RentalsService rentalsService;

    @Autowired
    public RentalsController(RentalsService rentalsService) {
        this.rentalsService = rentalsService;
    }

    @GetMapping(path = "/Rentals")
    public List<Rentals> getRentals(){
        return rentalsService.getRentals();
    }

    @PostMapping(path = "/Rentals/add")
    public void addRentals(@RequestBody Rentals rentals){
        rentalsService.addNewRentals(rentals);
    }

    @PostMapping(path = "/Rentals/edit" )
    public void editRentals(@RequestBody Rentals rentals){
        rentalsService.editRentals(rentals);

    }
}
