package com.example.repairingcompanyadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty Long id,
        @JsonProperty String city,
        @JsonProperty String voivodeship
) {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\": ").append("\"" + id + "\"");
        sb.append(", city='").append(city).append('\'');
        sb.append(", voivodeship='").append(voivodeship).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String toAddString(){
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"city\": ").append("\""+ city + '\"');
        sb.append(", \"voivodeship\": ").append("\""+ voivodeship + '\"'+"}");
        return sb.toString();
    }
}

