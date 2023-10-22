package org.example.repository;

import org.example.entity.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserBalanceRepository extends JpaRepository<UserBalance, Integer> {
}
