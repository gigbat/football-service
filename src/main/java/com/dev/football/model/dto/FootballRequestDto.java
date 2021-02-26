package com.dev.football.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FootballRequestDto {
    @NotNull
    @Size(min = 2)
    private String title;
    @Size(min = 32)
    private String description;

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
}
