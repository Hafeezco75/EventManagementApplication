package com.eventNaija.dtos.requests;


import com.eventNaija.data.models.Attendees;
import com.eventNaija.data.models.EventLocation;
import com.eventNaija.data.models.TicketType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEventRequest {
    @Id
    private Long eventId;
    private String title;
    private String description;
    private LocalDate Date;
    private TicketType ticketType;
    @OneToOne(cascade = CascadeType.ALL)
    private EventLocation eventLocation;
}
