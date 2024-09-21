package com.eventNaija.services;

import com.eventNaija.data.models.Event;
import com.eventNaija.dtos.requests.BookEventRequest;
import com.eventNaija.dtos.response.BookEventResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    BookEventResponse addBookEvent(BookEventRequest bookEventRequest);

    List<Event> getAllBookEvents();

    List<Event> deleteBookedEvent(Long eventId);
}
