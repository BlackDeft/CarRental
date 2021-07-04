package com.jacekstachecki.carRentals.Controller;
import com.jacekstachecki.carRentals.Domain.People;
import com.jacekstachecki.carRentals.Service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @GetMapping(path = "People")
    public List<People> getPeople(){
            return peopleService.getPeople();
    }

    @PostMapping(path = "/People/add")
    public void addNewPerson(@RequestBody People people){
        peopleService.addNewPerson(people);
    }

    @PostMapping(path = "/People/edit")
    public void editPerson(@RequestBody People people){
        peopleService.editPeople(people);
    }
}
