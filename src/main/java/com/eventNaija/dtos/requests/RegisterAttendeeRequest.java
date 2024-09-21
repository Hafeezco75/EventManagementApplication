package com.eventNaija.dtos.requests;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAttendeeRequest {
    @Id
    private Long attendeeId;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String password;
}
