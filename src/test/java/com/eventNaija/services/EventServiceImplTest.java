package com.eventNaija.services;

import com.eventNaija.data.models.Attendees;
import com.eventNaija.data.models.Event;
import com.eventNaija.data.models.EventLocation;
import com.eventNaija.data.models.TicketType;
import com.eventNaija.dtos.requests.BookEventRequest;
import com.eventNaija.dtos.response.BookEventResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EventServiceImplTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testThatAttendeeCanBookForAnEvent() {
        BookEventRequest bookEventRequest = new BookEventRequest();
        bookEventRequest.setTitle("Simbian BabyFaceshow and Friends");
        bookEventRequest.setDescription("A fun-filling comedy and scattering table show of laughter");
        bookEventRequest.setTicketType(TicketType.VIP);
        bookEventRequest.setEventLocation(new EventLocation(33L, "Ikorodu", 101001, "Lagos","Nigeria"));
        bookEventRequest.setDate(LocalDate.ofYearDay(2023,13));
        BookEventResponse bookEventResponse = eventService.addBookEvent(bookEventRequest);
        assertThat(bookEventResponse.getEventId()).isNull();
        assertThat(bookEventResponse.getMessage()).isEqualTo("Event have been successfully booked");
    }

    @Test
    public void testThatAllBookedEventCanBeRetrieved(){
        List<Event> events = eventService.getAllBookEvents();
        assertThat(events.size()).isEqualTo(1);
        assertThat(events.getFirst().getEventId()).isNull();
        assertThat(events.toString()).isEqualTo("Event has been successfully booked");
    }

    @Test
    public void testThatAttendeeCanDeleteBookedEvent() {
        Event event = new Event();
        event.setEventId(852L);
        List<Event> events = eventService.deleteBookedEvent(852L);
        assertThat(events.size()).isEqualTo(0);
        assertThat(events).isNull();
    }


}
