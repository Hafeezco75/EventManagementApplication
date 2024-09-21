package com.eventNaija.dtos.response;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookEventResponse {
    @Id
    private Long eventId;
    private String message;
}
