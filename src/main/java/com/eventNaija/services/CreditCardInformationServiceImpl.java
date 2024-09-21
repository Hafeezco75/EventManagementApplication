package com.eventNaija.services;

import com.eventNaija.data.models.Attendees;
import com.eventNaija.data.models.CreditCardInformation;
import com.eventNaija.data.repositories.AttendeesRepository;
import com.eventNaija.data.repositories.CreditCardInformationRepository;
import com.eventNaija.dtos.requests.AddCreditCardInformationRequest;
import com.eventNaija.dtos.response.AddCreditCardInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CreditCardInformationServiceImpl implements CreditCardInformationService {

    @Autowired
    CreditCardInformationRepository creditCardInformationRepository;

    @Autowired
    AttendeesRepository attendeesRepository;

    @Override
    public AddCreditCardInformationResponse addCreditCardInformation(AddCreditCardInformationRequest addCardRequest){
        validateAttendeeExists(addCardRequest.getAttendeeId());
        AddCreditCardInformationResponse addCreditCardResponse = new AddCreditCardInformationResponse();
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        creditCardInformation.setCardCVV(addCardRequest.getCardCVV());
        creditCardInformation.setCreditCardNumber(addCardRequest.getCreditCardNumber());
        creditCardInformation.setCardHolderName(addCardRequest.getCardHolderName());
        creditCardInformation.setCreditCardType(addCardRequest.getCreditCardType());
        creditCardInformation.setCardExpirationDate(addCardRequest.getCardExpirationDate());
        creditCardInformationRepository.save(creditCardInformation);

        addCreditCardResponse.setMessage("Attendee creditcard information successfully added");
        return addCreditCardResponse;
    }

    @Override
    public void validateAttendeeExists(Long attendeeId) {
        List<Attendees> attendeesList = attendeesRepository.findAll();
        for (Attendees attendee : attendeesList) {
            if (attendee.getAttendeeId().equals(attendeeId)) {
                attendeesRepository.save(attendee);
            }else {
                throw new NoSuchElementException("Attendee not found");
            }
        }
    }
}
