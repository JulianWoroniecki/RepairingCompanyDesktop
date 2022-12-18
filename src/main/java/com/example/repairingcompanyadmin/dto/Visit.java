package com.example.repairingcompanyadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public record Visit(
        @JsonProperty Long id,
        @JsonProperty Company company,
        @JsonProperty LocalDate date,
        @JsonProperty LocalTime startTime,
        @JsonProperty String description,
        @JsonProperty VisitCategory category,
        @JsonProperty LocalTime endTime
) {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("id=").append(id);
        sb.append(", company=").append(company);
        sb.append(", date=").append(date);
        sb.append(", startTime=").append(startTime);
        sb.append(", description='").append(description).append('\'');
        sb.append(", category=").append(category);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }
}
