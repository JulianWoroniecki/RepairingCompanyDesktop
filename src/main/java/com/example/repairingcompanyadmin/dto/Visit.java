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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"visitId\": ").append(id);
        sb.append(", \"date\": \"").append(date).append("\"");
        sb.append(", \"description\": \"").append(description).append('\"');
        sb.append(", \"endTime\": \"").append(endTime).append('\"');
        sb.append(", \"startTime\": \"").append(startTime).append('\"');
        sb.append(", \"visitCategoryId\": ").append(category.id());
        sb.append(", \"companyId\": ").append(company.id());
        sb.append('}');
        return sb.toString();
    }
}
