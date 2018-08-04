package com.ceepdode.reportingsystem.repository;

import com.ceepdode.reportingsystem.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
