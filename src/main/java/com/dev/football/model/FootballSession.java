package com.dev.football.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "football_session")
public class FootballSession {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "football_id")
    private Football football;
    @ManyToOne
    private FootballHall footballHall;
    private LocalDateTime localDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Football getFootball() {
        return football;
    }

    public void setFootball(Football football) {
        this.football = football;
    }

    public FootballHall getFootballHall() {
        return footballHall;
    }

    public void setFootballHall(FootballHall footballHall) {
        this.footballHall = footballHall;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDate(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "FootballSession - [id = " + id
                + football + ", " + footballHall
                + ", date " + localDateTime.toString() + "]";
    }
}
