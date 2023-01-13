package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Company;
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

public class EditCompanyController {

    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");

    @FXML
    private ComboBox<String> companiesList;

    @FXML
    private ComboBox<String> companyListView;

    @FXML
    private TextField descriptionInput;


    @FXML
    private TextField emailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneInput;


    @FXML
    private TextField streetInput;

    Company[] companies;
    Location[] locations;

    Company company;
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
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
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
    void deleteCompany() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("conf"));
        alert.setContentText(bundle.getString("askConf"));
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            JSONApi api = new JSONApi("http://localhost:8080/api/v1/company/delete/"+company.id(), "DELETE", String.class);
            api.deleteValue();
            load();
        }
    }
    private  void load() throws IOException {
        clear();
        JSONApi api = new JSONApi("http://localhost:8080/api/v1/company/all", "GET", Company[].class);
        companies= (Company[]) api.readValue();
        for (Company company : companies){
            companiesList.getItems().add(company.companyName());
        }
        JSONApi api2 = new JSONApi("http://localhost:8080/api/v1/location/all", "GET", Location[].class);
        locations=(Location[]) api2.readValue();
        for (Location location : locations){
            companyListView.getItems().add(location.city());
        }
    }
    private void clear(){
        companiesList.getItems().clear();
        companyListView.getItems().clear();
        companiesList.getSelectionModel().clearSelection();
        nameInput.clear();
        phoneInput.clear();
        emailInput.clear();
        descriptionInput.clear();
        streetInput.clear();
    }
    @FXML
    void initialize() throws IOException {
        load();
        nameInput.setEditable(false);
    }
    @FXML
    void loadData() {
        if(!companiesList.getSelectionModel().isEmpty()) {
            int indeks = companiesList.getSelectionModel().getSelectedIndex();
            company = companies[indeks];
            nameInput.setText(company.companyName());
            phoneInput.setText(company.phoneNumber());
            emailInput.setText(company.mail());
            descriptionInput.setText(company.description());
            streetInput.setText(company.street());
            String lokacja = company.location().city();
            companyListView.getSelectionModel().select(lokacja);
        }
    }

    @FXML
    void saveChangesToCompany() throws IOException {
        int indeks=companiesList.getSelectionModel().getSelectedIndex();
        Company company1=new Company(companies[indeks].id(),nameInput.getText(),descriptionInput.getText(),companies[indeks].visits(),companies[indeks].location(),phoneInput.getText(),streetInput.getText(),emailInput.getText());
        Api api = new Api();
        api.update("http://localhost:8080/api/v1/company/update","PUT",company1.toString());
        System.out.println(company1);
    }
}
