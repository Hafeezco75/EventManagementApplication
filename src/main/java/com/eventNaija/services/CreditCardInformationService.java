package com.eventNaija.services;

import com.eventNaija.dtos.requests.AddCreditCardInformationRequest;
import com.eventNaija.dtos.response.AddCreditCardInformationResponse;
import org.springframework.stereotype.Service;

@Service
public interface CreditCardInformationService {

    AddCreditCardInformationResponse addCreditCardInformation(AddCreditCardInformationRequest addCardRequest);


    void validateAttendeeExists(Long attendeeId);
}
