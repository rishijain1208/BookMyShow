package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}
