package com.example.demo.repository;

import com.example.demo.domain.VoteResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteJpaRepository extends JpaRepository<VoteResult, Long> {
}
