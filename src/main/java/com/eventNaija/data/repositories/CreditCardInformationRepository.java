package com.eventNaija.data.repositories;

import com.eventNaija.data.models.CreditCardInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardInformationRepository extends JpaRepository<CreditCardInformation, Long> {
}
