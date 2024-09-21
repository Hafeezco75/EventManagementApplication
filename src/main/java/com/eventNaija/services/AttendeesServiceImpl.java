package com.eventNaija.services;

import com.eventNaija.data.models.Attendees;
import com.eventNaija.data.repositories.AttendeesRepository;
import com.eventNaija.dtos.requests.LoginAttendeeRequest;
import com.eventNaija.dtos.requests.RegisterAttendeeRequest;
import com.eventNaija.dtos.response.LoginAttendeeResponse;
import com.eventNaija.dtos.response.RegisterAttendeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class AttendeesServiceImpl implements AttendeesService {

    @Autowired
    AttendeesRepository attendeesRepository;

    boolean setLoggedIn;
    String email_reg;

    @Override
    public RegisterAttendeeResponse registerAttendee(RegisterAttendeeRequest request) {
        Attendees attendees = new Attendees();
        validateAttendeeEmail(request);
        validateAttendeePassword(request);
        validatePasswordLength(request);
        checkAttendeesEmailContainsDotCom(request);
        attendees.setFirstname(request.getFirstname());
        attendees.setLastname(request.getLastname());
        attendees.setEmail(request.getEmail());
        attendees.setPassword(request.getPassword());
        attendeesRepository.save(attendees);

        RegisterAttendeeResponse response = new RegisterAttendeeResponse();
        response.setAttendeeId(attendees.getAttendeeId());
        response.setMessage("Attendee has been successfully registered");
        return response;
    }

    @Override
    public LoginAttendeeResponse loginAttendee(LoginAttendeeRequest attendeeRequest) {
        LoginAttendeeResponse attendeeResponse = new LoginAttendeeResponse();
        List<Attendees> attendeesList = attendeesRepository.findAll();
        email_reg = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

        Pattern pattern = Pattern.compile(email_reg);

        for (Attendees attendee : attendeesList) {
            if (pattern.matcher(attendeeRequest.getEmail()).matches()) {
                if(attendee.getPassword().equals(attendeeRequest.getPassword())) {
                    setLoggedIn = true;
                    attendee.setEmail(email_reg);
                    attendeesRepository.save(attendee);
                }
            }else {
                throw new NoSuchElementException("Email address is invalid, input a correct email address");
            }
        }
        attendeeResponse.setMessage("You have logged in successfully");
        return attendeeResponse;
    }

    @Override
    public List<Attendees> deleteAttendee(Long attendeeId) {
        List<Attendees> attendeesList = attendeesRepository.findAllByAttendeeId(attendeeId);
        for (Attendees attendee : attendeesList) {
            if(Objects.equals(attendee.getAttendeeId(), attendeeId)) {
                attendeesRepository.delete(attendee);
            }else {
                throw new NoSuchElementException("Attendee does not exist");
            }
        }
        return attendeesList;
    }


    @Override
    public List<Attendees> getAllAttendees() {
        return attendeesRepository.findAll();
    }

    @Override
    public List<Attendees> findAttendeesById(Long attendeeId) {
        List<Attendees> attendeesList = attendeesRepository.findAllByAttendeeId(attendeeId);
        return attendeesList;
    }


    private void validateAttendeeEmail(RegisterAttendeeRequest request) {
        String email = request.getEmail();

        for (Attendees attendee : attendeesRepository.findAll()) {
            if (attendee.getEmail().equalsIgnoreCase(email)) {
                throw new IllegalArgumentException("Email already exists,select another Email");
            } else {
                attendee.setEmail(email);
            }
        }
    }


    private void validateAttendeePassword(RegisterAttendeeRequest request) {
        String password = request.getPassword();

        for (Attendees attendee : attendeesRepository.findAll()) {
            if (attendee.getPassword().equals(password)) {
                throw new IllegalArgumentException("Invalid Password,enter a different Password");
            } else {
                attendee.setPassword(password);
            }
        }
    }


    private void checkAttendeesEmailContainsDotCom(RegisterAttendeeRequest request) {
        String email = request.getEmail();

        for (Attendees attendee : attendeesRepository.findAll()) {
            if (email.endsWith(".com")) {
                attendee.setEmail(email);
            } else {
                throw new RuntimeException("Email must end with .com");
            }
        }
    }

    private void validatePasswordLength(RegisterAttendeeRequest request) {
        String password = request.getPassword();

        for (Attendees attendees : attendeesRepository.findAll()) {
            if (password.length() <= 8) {
                throw new RuntimeException("Password must be at least 8 characters in length");
            } else {
                attendees.setPassword(password);
            }
        }
    }


}
