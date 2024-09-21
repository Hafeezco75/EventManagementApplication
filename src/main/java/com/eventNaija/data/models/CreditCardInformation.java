package com.eventNaija.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCardInformation {
    @Id
    private int cardCVV;
    private String cardHolderName;
    private String creditCardNumber;
    private CreditCardType creditCardType;
    private LocalDate cardExpirationDate;

}
