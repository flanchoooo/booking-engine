package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(Object username);
}
