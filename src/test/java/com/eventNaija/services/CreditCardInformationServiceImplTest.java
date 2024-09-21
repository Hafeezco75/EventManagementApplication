package com.eventNaija.services;


import com.eventNaija.data.models.Attendees;
import com.eventNaija.data.models.CreditCardInformation;
import com.eventNaija.data.models.CreditCardType;
import com.eventNaija.dtos.requests.AddCreditCardInformationRequest;
import com.eventNaija.dtos.requests.RegisterAttendeeRequest;
import com.eventNaija.dtos.response.AddCreditCardInformationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CreditCardInformationServiceImplTest {

    @Autowired
    CreditCardInformationServiceImpl creditCardInformationService;

    @Autowired
    AttendeesServiceImpl attendeesService;

    @Test
    public void testThatCreditCardInformationCanBeAddedByAttendee() {
        AddCreditCardInformationRequest cardRequest = new AddCreditCardInformationRequest();
        cardRequest.setAttendeeId(302L);
        cardRequest.setCardCVV(324);
        cardRequest.setCardHolderName("Sam Emma");
        cardRequest.setCreditCardNumber("3243567892316595");
        cardRequest.setCreditCardType(CreditCardType.VISA);
        cardRequest.setCardExpirationDate(LocalDate.now());
        AddCreditCardInformationResponse response = creditCardInformationService.addCreditCardInformation(cardRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Attendee creditcard information successfully added");
    }






}
