package com.jacekstachecki.carRentals.Config;


import com.jacekstachecki.carRentals.Domain.Car;
import com.jacekstachecki.carRentals.Repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.List.*;

@Configuration
public class CarConfig {

    @Bean(name = "carBean")
    CommandLineRunner commandLineRunner(CarRepository repository){
        return args -> {
            Car Bmw = new Car(
                "BMW",
                "G0 2FAST"
            );
            Car Audi = new Car(
                    "Audi",
                    "G0 ACR"
            );
            Car Toyota = new Car(
                    "Toyota",
                    "G0 AB1"
            );
            repository.save(Bmw);
            repository.save(Audi);
            repository.save(Toyota);
        };
    }

}
