package com.dev.football.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "football")
public class Football {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "football_id")
    private Long id;
    @Column (name = "football_title")
    private String title;
    @Column (name = "football_description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Football - [id = " + id
                + ", title = " + title
                + ", description = " + description + "]";
    }
}
