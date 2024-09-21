package com.eventNaija.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String title;
    private String description;
    private LocalDate Date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketType ticketType;
    @OneToOne(cascade = CascadeType.ALL)
    private EventLocation eventLocation;


}
