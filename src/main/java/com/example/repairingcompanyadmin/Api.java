package com.example.repairingcompanyadmin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Api {
    public int update(String URL,String method, String body) throws IOException {
        java.net.URL url = new URL(URL);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestProperty("Content-Type", "application/json; charset=utf8");
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod(method);
        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
        osw.write(body);
        osw.flush();
        osw.close();
        os.close();
        return httpCon.getResponseCode();
    }
}
