package com.eventNaija.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNumberId;
    private double orderSubTotal;
    private double serviceFee;
    private double Tax;
    private double orderBillTotal;
}
