package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Location;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddLocalisationController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private TextField cityInput;

    @FXML
    private TextField voivodeshipInput;

    @FXML
    void addCompany() throws IOException {
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
    }

    @FXML
    void addLocalisation() throws IOException {
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
    }

    @FXML
    void editCompany() throws IOException {
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
    }

    @FXML
    void editLocalisation() throws IOException {
        StageSetter.buildStage("EditLocalisation.fxml",bundle.getString("eL"),bundle);
    }

    @FXML
    void editVisits() throws IOException {
        StageSetter.buildStage("EditVisits.fxml",bundle.getString("eV"),bundle);
    }

    @FXML
    void langENG() throws IOException {
        Locale.setDefault(new Locale("en_US"));
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
    }

    @FXML
    void viewCategories() throws IOException {
        StageSetter.buildStage("viewCategories.fxml",bundle.getString("vCtg"),bundle);
    }

    @FXML
    void viewCompanies() throws IOException {
        StageSetter.buildStage("viewCompanies.fxml",bundle.getString("vCmp"),bundle);
    }

    @FXML
    void viewLocalisations() throws IOException {
        StageSetter.buildStage("viewLocalisations.fxml",bundle.getString("vL"),bundle);
    }

    @FXML
    void viewVisits() throws IOException {
        StageSetter.buildStage("ViewVisits.fxml",bundle.getString("vV"),bundle);
    }
    @FXML
    void submitLocation() throws IOException {
        URL url = new URL("http://localhost:8080/api/v1/location/add");
        Location location = new Location(0L,cityInput.getText(),voivodeshipInput.getText());
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestProperty("Content-Type", "application/json; charset=utf8");
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
        osw.write(location.toAddString());
        osw.flush();
        osw.close();
        os.close();
        int status = httpCon.getResponseCode();
        System.out.println(status);
    }

}
