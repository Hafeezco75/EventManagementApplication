package com.eventNaija.services;

import com.eventNaija.data.models.Event;
import com.eventNaija.data.repositories.AttendeesRepository;
import com.eventNaija.data.repositories.EventRepository;
import com.eventNaija.dtos.requests.BookEventRequest;
import com.eventNaija.dtos.response.BookEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeesRepository attendeesRepository;

    @Override
    public BookEventResponse addBookEvent(BookEventRequest bookEventRequest) {
        validateEventExists(bookEventRequest.getEventId());
        BookEventResponse bookEventResponse = new BookEventResponse();
        Event events = new Event();
        events.setTitle(bookEventRequest.getTitle());
        events.setDescription(bookEventRequest.getDescription());
        events.setEventLocation(bookEventRequest.getEventLocation());
        events.setTicketType(bookEventRequest.getTicketType());
        events.setDate(bookEventRequest.getDate());
        eventRepository.save(events);

        bookEventResponse.setMessage("Event have been successfully booked");
        bookEventResponse.setEventId(bookEventResponse.getEventId());
        return bookEventResponse;
    }

    private void validateEventExists(Long eventId){
        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                throw new RuntimeException("Event already exists");
            } else {
                event.setEventId(eventId);
            }
        }
    }


    @Override
    public List<Event> getAllBookEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    @Override
    public List<Event> deleteBookedEvent(Long eventId) {
        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                eventRepository.delete(event);
            }else {
                throw new RuntimeException("Event cannot be found, input event properly");
            }
        }
        return null;
    }
}
