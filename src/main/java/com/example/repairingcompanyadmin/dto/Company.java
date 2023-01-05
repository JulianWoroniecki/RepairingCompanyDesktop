package com.example.repairingcompanyadmin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Company(
        @JsonProperty Long id,
        @JsonProperty String companyName,
        @JsonProperty String description,
        @JsonProperty List<Visit> visits,
        @JsonProperty Location location,
        @JsonProperty String phoneNumber,
        @JsonProperty String street,
        @JsonProperty String mail

) {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("id=").append(id);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", visits=").append(visits);
        sb.append(", location=").append(location);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", mail='").append(mail).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
