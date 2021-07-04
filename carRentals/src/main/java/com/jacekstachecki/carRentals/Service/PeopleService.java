package com.jacekstachecki.carRentals.Service;

import com.jacekstachecki.carRentals.Domain.People;
import com.jacekstachecki.carRentals.Repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> getPeople() {
        return peopleRepository.findAll();
    }

    public void addNewPerson(People people) {
        if(!(people.getSurname().trim().length() > 0))
            throw new IllegalStateException("Whats your surname?");
        if(!(people.getName().trim().length() > 0))
            throw new IllegalStateException("Whats your name ?");
        if(!(people.getEmail().trim().length() > 0))
            throw new IllegalStateException("Whats your email ?");
        Optional<People> peopleByEmail = peopleRepository.
                findPeopleByEmail(people.getEmail());
        if(peopleByEmail.isPresent()){
            throw new IllegalStateException("This email is taken.");
        }
        peopleRepository.save(people);
    }

    public void editPeople(People people) {
        if(people.getName() == "")
            people.setName(peopleRepository.getById(people.getId()).getName());
        if(people.getEmail() == "")
            people.setEmail(peopleRepository.getById(people.getId()).getEmail());
        if(people.getSurname() == "")
            people.setSurname(peopleRepository.getById(people.getId()).getSurname());
        peopleRepository.save(people);
    }
}
