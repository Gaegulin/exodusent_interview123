package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "vote_result")
public class VoteResult {

    @Id
    private Long id = 1L; // 항상 1 row만 사용

    private int jajang;
    private int jjamppong;

    protected VoteResult() {}

    public VoteResult(int jajang, int jjamppong) {
        this.jajang = jajang;
        this.jjamppong = jjamppong;
    }

    public Long getId() {
        return id;
    }

    public int getJajang() {
        return jajang;
    }

    public int getJjamppong() {
        return jjamppong;
    }

    public void addJajang() {
        this.jajang++;
    }

    public void addJjamppong() {
        this.jjamppong++;
    }
}
