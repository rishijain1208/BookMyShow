package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{

    private String Name;
}
