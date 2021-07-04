package com.jacekstachecki.carRentals.Domain;

import javax.persistence.*;

@Entity
@Table
public class People {

    @Id
    @SequenceGenerator( name = "people",
                        sequenceName = "people_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "people_sequence")
    private Long id;
    private String name = "";
    private String surname = "";
    private String email = "";

    public People() {
    }

    public People(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public People(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
