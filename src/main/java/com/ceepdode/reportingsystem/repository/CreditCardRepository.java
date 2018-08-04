package com.ceepdode.reportingsystem.repository;

import com.ceepdode.reportingsystem.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    CreditCard findByCardNumber(Long cardNumber);

    Boolean existsByCardNumber(Long cardNumber);

    CreditCard getByCardNumber(Long cardNumber);

    void deleteByCardNumber(Long cardNumber);

    Double findCreditsByCardNumber(Long cardNumber);
}
