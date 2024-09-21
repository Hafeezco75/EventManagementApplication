package com.eventNaija.dtos.requests;


import com.eventNaija.data.models.CreditCardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddCreditCardInformationRequest {
    private Long attendeeId;
    private int cardCVV;
    private String cardHolderName;
    private String creditCardNumber;
    private CreditCardType creditCardType;
    private LocalDate cardExpirationDate;



}
