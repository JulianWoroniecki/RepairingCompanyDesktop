package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Company;
import com.example.repairingcompanyadmin.dto.Location;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddCompanyController {

    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private ComboBox<String> locations;

    @FXML
    private TextField descriptionInput;


    @FXML
    private TextField emailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneInput;

    @FXML
    private TextField sInput;

    Location[] locationsList;
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
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
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

    private void clear(){
        nameInput.clear();
        phoneInput.clear();
        emailInput.clear();
        descriptionInput.clear();
        sInput.clear();
        locations.getItems().clear();
    }

    @FXML
    void initialize() throws IOException {
        JSONApi api = new JSONApi("https://repairingcompany.azurewebsites.net/api/v1/location/all","GET", Location[].class);
        locationsList = (Location[]) api.readValue();
        for (Location location : locationsList){
            locations.getItems().add(location.city());
        }
    }
    @FXML
    void submitCompany() throws IOException {
        if(validate()) {
            Company company = new Company(null,nameInput.getText(),descriptionInput.getText(),null,locationsList[locations.getSelectionModel().getSelectedIndex()],phoneInput.getText(),sInput.getText(),emailInput.getText());
            Api api = new Api();
            api.update("https://repairingcompany.azurewebsites.net/api/v1/company/add","POST",company.toStringWithoutId());
            clear();
        }
        else{
            InfoWindow window = new InfoWindow();
            window.text(bundle.getString("error"), bundle.getString("errorMsg"), Alert.AlertType.ERROR);
        }
    }
    private boolean validate(){
        return phoneInput.getText().matches("^\\d\\d\\d\\d\\d\\d\\d\\d\\d$") && emailInput.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
