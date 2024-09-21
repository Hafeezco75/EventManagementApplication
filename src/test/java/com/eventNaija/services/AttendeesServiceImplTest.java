package com.eventNaija.services;

import com.eventNaija.data.models.Attendees;
import com.eventNaija.dtos.requests.LoginAttendeeRequest;
import com.eventNaija.dtos.requests.RegisterAttendeeRequest;
import com.eventNaija.dtos.response.LoginAttendeeResponse;
import com.eventNaija.dtos.response.RegisterAttendeeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AttendeesServiceImplTest {

    @Autowired
    AttendeesService attendeesService;

    @Test
    public void testThatAttendeeCanBeRegistered(){
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstname("Emmanuel");
        request.setLastname("Samson");
        request.setEmail("sadf@email.com");
        request.setPassword("Samson421");
        RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("Attendee has been successfully registered");
    }

    @Test
    public void testThatAttendeeEmailShouldNotBeRegisteredTwice(){
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstname("Emmanuel");
        request.setLastname("Samson");
        request.setEmail("bolasamsuel@email.com");
        request.setPassword("Samson4321");
        RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("Attendee has been successfully registered");
    }

    @Test
    public void testThatAttendeePasswordShouldNotBeRegisteredTwice(){
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstname("Emmanuel");
        request.setLastname("Samson");
        request.setEmail("bolason@email.com");
        request.setPassword("Samson2134");
        RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("Attendee has been successfully registered");
    }

    @Test
    public void testThatAttendeeEmailShouldIncludeDotCom(){
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstname("Emma");
        request.setLastname("Sam");
        request.setEmail("bosail@email.com");
        request.setPassword("Samson3223");
        RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("Attendee has been successfully registered");
    }

    @Test
    public void testThatPasswordLengthMustBeAtLeast8Characters(){
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstname("Emma");
        request.setLastname("Samson");
        request.setEmail("bolasam@email.com");
        request.setPassword("Samson1612");
        RegisterAttendeeResponse attendeeResponse = attendeesService.registerAttendee(request);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("Attendee has been successfully registered");
    }

    @Test
    public void testThatAttendeeCanLogin(){
        LoginAttendeeRequest attendeeRequest = new LoginAttendeeRequest();
        attendeeRequest.setEmail("bosam@email.com");
        attendeeRequest.setPassword("Sams");
        LoginAttendeeResponse attendeeResponse = attendeesService.loginAttendee(attendeeRequest);
        assertThat(attendeeResponse).isNotNull();
        assertThat(attendeeResponse.getMessage()).isEqualTo("You have logged in successfully");
    }

    @Test
    public void testThatAllAttendeesCanBeRetrieved(){
        List<Attendees> attendeesList = attendeesService.getAllAttendees();
        assertThat(attendeesList).isNotNull();
        assertThat(attendeesList.size()).isEqualTo(4);
        assertThat(attendeesList.get(2).getEmail()).isEqualTo("bosail@email.com");
        assertThat(attendeesList.getFirst()).isNotNull();
    }

    @Test
    public void testThatAllAttendeesCanBeRetrievedById(){
        List<Attendees> attendeesList = attendeesService.findAttendeesById(452L);
        assertThat(attendeesList).isNotNull();
        assertThat(attendeesList.getFirst().getAttendeeId()).isEqualTo(452);
    }

    @Test
    public void testThatAttendeesCanBeDeletedById(){
        Attendees attendee = new Attendees();
        attendee.setAttendeeId(452L);
        List<Attendees> attendeesList = attendeesService.deleteAttendee(452L);
        assertThat(attendeesList).isNotNull();
        assertThat(attendeesList.size()).isEqualTo(0);
    }

}