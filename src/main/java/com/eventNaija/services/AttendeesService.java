package com.eventNaija.services;

import com.eventNaija.data.models.Attendees;
import com.eventNaija.dtos.requests.LoginAttendeeRequest;
import com.eventNaija.dtos.requests.RegisterAttendeeRequest;
import com.eventNaija.dtos.response.LoginAttendeeResponse;
import com.eventNaija.dtos.response.RegisterAttendeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendeesService {

    RegisterAttendeeResponse registerAttendee(RegisterAttendeeRequest request);


    LoginAttendeeResponse loginAttendee(LoginAttendeeRequest request);

    List<Attendees> deleteAttendee(Long attendeeId);

    List<Attendees> getAllAttendees();

    List<Attendees> findAttendeesById(Long attendeeId);
}
