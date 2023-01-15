package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Location;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewLocalisationsController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");

    @FXML
    private TextArea localisationList;

    @FXML
    void addCompany() throws IOException {
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
    }

    @FXML
    void addLocalisation() throws IOException {
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
    }

    @FXML
    void editCategories() throws IOException {
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
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
        StageSetter.buildStage("viewLocalisations.fxml",bundle.getString("vL"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("viewLocalisations.fxml",bundle.getString("vL"),bundle);
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
    void initialize() throws IOException {
        JSONApi api = new JSONApi("https://repairingcompany.azurewebsites.net/api/v1/location/all", "GET", Location[].class);
        Location[] locations = (Location[]) api.readValue();
        for (Location location : locations){
            localisationList.appendText(location.id().toString() + ". " +
                    location.city() + "\n" +
                    bundle.getString("vvship") + ": " + location.voivodeship() + "\n\n"
            );
        }
        localisationList.setEditable(false);
    }

}
