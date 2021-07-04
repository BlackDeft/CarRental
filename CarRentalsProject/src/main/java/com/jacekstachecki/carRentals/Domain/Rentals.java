package com.jacekstachecki.carRentals.Domain;

import javax.persistence.*;

@Entity
@Table
public class Rentals {

    @Id
    @SequenceGenerator( name = "rentals",
            sequenceName = "rentals_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "rentals_sequence")
    private Long id;
    private Long idCar ;
    private Long idPeople;
    private String status = "borrowed";

    public Rentals() {
    }

    public Rentals(Long idCar, Long idPeople, String status) {
        this.idCar = idCar;
        this.idPeople = idPeople;
        this.status = status;
    }

    public Rentals(Long id, Long idCar, Long idPeople, String status) {
        this.id = id;
        this.idCar = idCar;
        this.idPeople = idPeople;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public Long getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Long idPeople) {
        this.idPeople = idPeople;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rentals{" +
                "id=" + id +
                ", idCar=" + idCar +
                ", idPeople=" + idPeople +
                ", status='" + status + '\'' +
                '}';
    }
}
