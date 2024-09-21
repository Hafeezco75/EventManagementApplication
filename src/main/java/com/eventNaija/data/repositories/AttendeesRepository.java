package com.eventNaija.data.repositories;

import com.eventNaija.data.models.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeesRepository extends JpaRepository<Attendees, Long> {

    List<Attendees> findAllByAttendeeId(Long attendeeId);

}
