package com.jacekstachecki.carRentals.Domain;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @SequenceGenerator( name = "car",
            sequenceName = "car_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "car_sequence")
    private Long id;
    private String brand="";
    private String plate="";

    public Car() {
    }

    public Car(Long id, String brand, String plate) {
        this.id = id;
        this.brand = brand;
        this.plate = plate;
    }

    public Car(String brand, String plate) {
        this.brand = brand;
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }
}
