package com.ceepdode.reportingsystem.repository;

import com.ceepdode.reportingsystem.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
