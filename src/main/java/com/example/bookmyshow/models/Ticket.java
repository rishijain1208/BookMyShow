package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    @ManyToOne
    private User BookBy;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private double totalAmount;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private Date dateOfBooking;

    private Date timeOfBooking;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payment;
}
