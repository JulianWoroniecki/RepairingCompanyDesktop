package com.example.repairingcompanyadmin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class EditCompanyController {

    private ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private Button addCompanyButton;

    @FXML
    private Button addLocalisationButton1;
    @FXML
    private Button deleteCompanyButton;
    @FXML
    private ComboBox<String> companiesList;
    @FXML
    private Label companyDescription;

    @FXML
    private Label companyEmail;

    @FXML
    private Label companyLocation;

    @FXML
    private Label companyName;

    @FXML
    private Label companyNumber;

    @FXML
    private Label companyStreet;

    @FXML
    private Label companyTitle;

    @FXML
    private TextField descriptionInput;

    @FXML
    private Button editCategoriesButton1;

    @FXML
    private Button editCompanyButton1;

    @FXML
    private Button editLocalisationButton1;

    @FXML
    private Button editVisitsButton1;

    @FXML
    private TextField emailInput;

    @FXML
    private ToggleButton langENGButton;

    @FXML
    private ToggleButton langPLButton;

    @FXML
    private VBox locationList;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneInput;

    @FXML
    private Button saveCompanyChangesButton;

    @FXML
    private TextField streetInput;

    @FXML
    private Button viewCategoriesButton1;

    @FXML
    private Button viewCompaniesButton;

    @FXML
    private Button viewLocalisationsButton1;

    @FXML
    private Button viewVisitsButton1;

    @FXML
    void addCompany(ActionEvent event) throws IOException {
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
    }

    @FXML
    void addLocalisation(ActionEvent event) throws IOException {
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
    }

    @FXML
    void deleteCompany(ActionEvent event) {

    }

    @FXML
    void editCategories(ActionEvent event) throws IOException {
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
    }

    @FXML
    void editCompany(ActionEvent event) throws IOException {
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
    }

    @FXML
    void editLocalisation(ActionEvent event) throws IOException {
        StageSetter.buildStage("EditLocalisation.fxml",bundle.getString("eL"),bundle);
    }

    @FXML
    void editVisits(ActionEvent event) throws IOException {
        StageSetter.buildStage("EditVisits.fxml",bundle.getString("eV"),bundle);
    }

    @FXML
    void langENG(ActionEvent event) throws IOException {
        Locale.setDefault(new Locale("ang"));
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
    }

    @FXML
    void langPL(ActionEvent event) throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditCompany.fxml",bundle.getString("eCmp"),bundle);
    }

    @FXML
    void viewCategories(ActionEvent event) throws IOException {
        StageSetter.buildStage("viewCategories.fxml",bundle.getString("vCtg"),bundle);
    }

    @FXML
    void viewCompanies(ActionEvent event) throws IOException {
        StageSetter.buildStage("viewCompanies.fxml",bundle.getString("vCmp"),bundle);
    }

    @FXML
    void viewLocalisations(ActionEvent event) throws IOException {
        StageSetter.buildStage("viewLocalisations.fxml",bundle.getString("vL"),bundle);
    }

    @FXML
    void viewVisits(ActionEvent event) throws IOException {
        StageSetter.buildStage("ViewVisits.fxml",bundle.getString("vV"),bundle);
    }

}
