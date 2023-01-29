package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> auditoriums;

    @ManyToOne
    private City city;
}
