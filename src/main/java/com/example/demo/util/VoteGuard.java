package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class VoteGuard {

    private final Set<String> votedIps = ConcurrentHashMap.newKeySet();

    public boolean canVote(String ip) {
        return votedIps.add(ip); // 이미 있으면 false
    }
}