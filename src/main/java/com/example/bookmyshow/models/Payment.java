package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;

    private Date timeOfPayment;

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private Ticket ticket;
}
