package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Location;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditLocalisationController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");

    @FXML
    private TextField cityInput;

    @FXML
    private ComboBox<String> localisationsList;

    @FXML
    private TextField vvshipInput;

    Location[] locations;

    Location location;

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
        StageSetter.buildStage("EditLocalisation.fxml",bundle.getString("eL"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditLocalisation.fxml",bundle.getString("eL"),bundle);
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
    void deleteLocalisation() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("conf"));
        alert.setContentText(bundle.getString("askConf"));
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            JSONApi api = new JSONApi("http://localhost:8080/api/v1/location/delete/"+location.id(), "DELETE", String.class);
            api.deleteValue();
            load();
        }
    }
    @FXML
    void saveLocalisationChanges() throws IOException {
        int indeks=localisationsList.getSelectionModel().getSelectedIndex();
        Location location1=new Location(locations[indeks].id(),cityInput.getText(),vvshipInput.getText());
        URL url = new URL("http://localhost:8080/api/v1/location/update");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestProperty("Content-Type", "application/json; charset=utf8");
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        OutputStream os = httpCon.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
        osw.write(location1.toAddString());
        osw.flush();
        osw.close();
        os.close();
        System.out.println(httpCon.getResponseCode());
    }
    private void load() throws IOException {
        clear();
        JSONApi api = new JSONApi("http://localhost:8080/api/v1/location/all","GET", Location[].class);
        locations = (Location[]) api.readValue();
        for (Location location : locations){
            localisationsList.getItems().add(location.city());
        }
    }
    private void clear(){
        localisationsList.getItems().clear();
        localisationsList.getSelectionModel().clearSelection();
        cityInput.clear();
        vvshipInput.clear();
    }
    @FXML
    void initialize() throws IOException {
        load();
    }
    @FXML
    void loadData(){
        if(!localisationsList.getSelectionModel().isEmpty()) {
            int indeks = localisationsList.getSelectionModel().getSelectedIndex();
            location = locations[indeks];
            cityInput.setText(location.city());
            vvshipInput.setText(location.voivodeship());
        }
    }
}
