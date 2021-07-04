package com.jacekstachecki.carRentals.Repository;

import com.jacekstachecki.carRentals.Domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository
        extends JpaRepository<People,Long> {

    Optional<People> findPeopleByEmail(String Email);
}
