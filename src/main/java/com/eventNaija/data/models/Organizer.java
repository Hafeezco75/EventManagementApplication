package com.eventNaija.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organizer {
    @Id
    @GeneratedValue
    private Long organizerId;
    private String companyName;
    private String companyEmail;
    private String companyAddress;

}
