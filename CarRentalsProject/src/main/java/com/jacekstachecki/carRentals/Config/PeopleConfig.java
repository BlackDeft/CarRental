package com.jacekstachecki.carRentals.Config;


import com.jacekstachecki.carRentals.Domain.People;
import com.jacekstachecki.carRentals.Repository.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.List.*;

@Configuration
public class PeopleConfig {

    @Bean(name = "peopleBean")
    CommandLineRunner commandLineRunner(PeopleRepository repository){
        return args -> {
            People Alex = new People(
                "Alex",
                "kowalski",
                "Alex@gmail.com"
            );
            People Adam = new People(
                    "Adam",
                    "kowalski",
                    "Adam@gmail.com"
            );
            repository.save(Alex);
            repository.save(Alex);
        };
    }

}
