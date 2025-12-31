package com.example.demo.service;

import com.example.demo.domain.VoteResult;
import com.example.demo.domain.VoteType;
import com.example.demo.repository.VoteJpaRepository;
import com.example.demo.util.VoteGuard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteService {

    private final VoteJpaRepository repository;
    private final VoteGuard voteGuard;

    public VoteService(VoteJpaRepository repository, VoteGuard voteGuard) {
        this.repository = repository;
        this.voteGuard = voteGuard;
    }

    @Transactional
    public boolean vote(VoteType type, String ip) {
        if (!voteGuard.canVote(ip)) {
            return false;
        }

        VoteResult result = repository.findById(1L)
                .orElseGet(() -> repository.save(new VoteResult(0, 0)));

        if (type == VoteType.JAJANG) {
            result.addJajang();
        } else {
            result.addJjamppong();
        }

        return true;
    }

    public VoteResult getResult() {
        return repository.findById(1L)
                .orElse(new VoteResult(0, 0));
    }
}
