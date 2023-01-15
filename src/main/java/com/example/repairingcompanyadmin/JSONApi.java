package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JSONApi<T> {

    private final ObjectMapper mapper;
    private final String url;
    private final String httpMethod;
    private final Class<T> clazz;

    public JSONApi(String url, String httpMethod, Class<T> clazz) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.clazz = clazz;
        mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    public T readValue() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(this.httpMethod);
        connection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        T result = this.mapper.readValue(content.toString(), this.clazz);

        in.close();
        connection.disconnect();

        return result;
    }

    public String deleteValue() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(this.httpMethod);
        connection.getResponseCode();
        return Integer.toString(connection.getResponseCode());
    }
}
