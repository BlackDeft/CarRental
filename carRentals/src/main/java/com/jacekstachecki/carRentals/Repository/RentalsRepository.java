package com.jacekstachecki.carRentals.Repository;

import com.jacekstachecki.carRentals.Domain.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalsRepository
        extends JpaRepository<Rentals,Long> {

    Optional<Rentals> findRentalsByIdCar(Long idCar);
}
