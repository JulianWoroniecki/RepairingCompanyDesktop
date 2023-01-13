package com.example.repairingcompanyadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VisitCategory (
        @JsonProperty Long id,
        @JsonProperty String type,
        @JsonProperty Long durationHours,
        @JsonProperty String humanReadableLabel
) {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VisitCategory{");
        sb.append("humanReadableLabel='").append(humanReadableLabel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
