package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Company;
import com.example.repairingcompanyadmin.dto.Visit;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditVisitsController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");

    @FXML
    private DatePicker dateInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private ComboBox<String> visitsList;

    @FXML
    private TextField endingInput;
    @FXML
    private TextField startingInput;
    Visit[] visits;

    Company[] companies;
    Visit visit;
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
        StageSetter.buildStage("EditVisits.fxml",bundle.getString("eV"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditVisits.fxml",bundle.getString("eV"),bundle);
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
    void deleteVisit() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("conf"));
        alert.setContentText(bundle.getString("askConf"));
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            JSONApi api = new JSONApi("https://repairingcompany.azurewebsites.net/api/v1/visit/delete/"+visit.id(), "DELETE", String.class);
            api.deleteValue();
            load();
        }
    }
    @FXML
    void saveVisitChanges() throws IOException {
        if(validate()) {
            int indeks = visitsList.getSelectionModel().getSelectedIndex();
            JSONApi api2 = new JSONApi("https://repairingcompany.azurewebsites.net/api/v1/company/all", "GET", Company[].class);
            companies = (Company[]) api2.readValue();
            Visit visit = new Visit(visits[indeks].id(), companies[0], visits[indeks].date(), LocalTime.parse(startingInput.getText()), descriptionInput.getText(), visits[indeks].category(), LocalTime.parse(endingInput.getText()));
            Api api = new Api();
            api.update("https://repairingcompany.azurewebsites.net/api/v1/visit/update", "PUT", visit.toString());
            load();
        }
        else{
            InfoWindow window = new InfoWindow();
            window.text(bundle.getString("error"), bundle.getString("errorHour"), Alert.AlertType.ERROR);
        }
    }
    private void load() throws IOException {
        clear();
        JSONApi api = new JSONApi("https://repairingcompany.azurewebsites.net/api/v1/visit/all","GET", Visit[].class);
        visits = (Visit[]) api.readValue();
        for (Visit visit: visits){
            visitsList.getItems().add(visit.description());

        }
    }

    private void clear(){
        visitsList.getItems().clear();
        visitsList.getSelectionModel().clearSelection();
        descriptionInput.clear();
        startingInput.clear();
        endingInput.clear();
        dateInput.setValue(null);
    }
    @FXML
    void initialize() throws IOException {
        load();
        descriptionInput.setEditable(false);
        dateInput.setEditable(false);
        System.out.println(visits[0].description());
    }
    @FXML
    void loadData(){
        if(!visitsList.getSelectionModel().isEmpty()) {
            int indeks = visitsList.getSelectionModel().getSelectedIndex();
            visit = visits[indeks];
            descriptionInput.setText(visit.description());
            startingInput.setText(visit.startTime().toString());
            endingInput.setText(visit.endTime().toString());
            dateInput.setValue(visit.date());
        }
    }
    private boolean validate(){
        return startingInput.getText().matches("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$") && endingInput.getText().matches("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$");
    }
}

