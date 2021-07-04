package com.jacekstachecki.carRentals.Service;

import com.jacekstachecki.carRentals.Domain.Rentals;
import com.jacekstachecki.carRentals.Repository.CarRepository;
import com.jacekstachecki.carRentals.Repository.PeopleRepository;
import com.jacekstachecki.carRentals.Repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalsService {

    private final RentalsRepository rentalsRepository;

    public RentalsService(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PeopleRepository peopleRepository;



    public List<Rentals> getRentals() {
        return rentalsRepository.findAll();
    }

    public void addNewRentals(Rentals rentals) {
        if(rentals.getIdPeople() == null)
            throw new IllegalStateException("Who wants to rent ?");
        if(rentals.getIdCar() == null)
            throw new IllegalStateException("What car you want to rent ?");
       Optional<Rentals> rentalsByIdCar = rentalsRepository.
                        findRentalsByIdCar(rentals.getIdCar());
       if(!carRepository.existsById(rentals.getIdCar()))
           throw new IllegalStateException("there is no car like that");
       if(!peopleRepository.existsById(rentals.getIdPeople()))
           throw new IllegalStateException("there is no user like that");
       if(rentalsByIdCar.toString().contains("borrowed")){
           throw new IllegalStateException("this car has been already borrowed");
        }
        rentalsRepository.save(rentals);
    }

    public void editRentals(Rentals rentals) {
        if(rentals.getIdCar() == null)
            rentals.setIdCar(rentalsRepository.getById(rentals.getId()).getIdCar());
        if(rentals.getIdPeople()==null)
            rentals.setIdPeople(rentalsRepository.getById(rentals.getId()).getIdPeople());
        rentalsRepository.save(rentals);
    }
}