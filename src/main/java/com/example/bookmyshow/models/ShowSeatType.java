package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private double price;
}
