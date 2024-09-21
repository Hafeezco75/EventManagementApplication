package com.eventNaija.data.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendees {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long attendeeId;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String password;
    @OneToOne
    @NonNull
    private CreditCardInformation creditCardInformation;
}
