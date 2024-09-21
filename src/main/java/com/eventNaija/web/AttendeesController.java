package com.eventNaija.web;

import com.eventNaija.dtos.requests.RegisterAttendeeRequest;
import com.eventNaija.dtos.response.ApiResponse;
import com.eventNaija.dtos.response.RegisterAttendeeResponse;
import com.eventNaija.services.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AttendeesController {
    @Autowired
    AttendeesService attendeesService;


    @PostMapping("/register")
    public ResponseEntity<?> registerAttendee(RegisterAttendeeRequest request) {
        try {
            RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
            return new ResponseEntity<>(attendeeResponse, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }




}
