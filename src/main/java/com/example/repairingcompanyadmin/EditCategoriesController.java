package com.example.repairingcompanyadmin;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class EditCategoriesController {
    private ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private Button addCompanyButton;

    @FXML
    private Button addLocalisationButton;

    @FXML
    private ComboBox<String> categoriesList;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private Button saveCategoriesChangesButton;
    @FXML
    private Label companyEmail;

    @FXML
    private Label companyName;

    @FXML
    private Label companyNumber;

    @FXML
    private TextField dHoursInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private Button editCategoriesButton;

    @FXML
    private Label editCategoriesTitle;

    @FXML
    private Button editCompanyButton;

    @FXML
    private Button editLocalisationButton;

    @FXML
    private Button editVisitsButton;

    @FXML
    private ToggleButton langENGButton1;

    @FXML
    private ToggleButton langPLButton;

    @FXML
    private TextField typeInput;

    @FXML
    private Button viewCategoriesButton;

    @FXML
    private Button viewCompaniesButton;

    @FXML
    private Button viewLocalisationsButton;

    @FXML
    private Button viewVisitsButton;

    @FXML
    private void initialize(){
        categoriesList.getItems().setAll("test","test2");
    }
    @FXML
    void addCompany(ActionEvent event) throws IOException {
        StageSetter.buildStage("AddCompany.fxml",bundle.getString("aC"),bundle);
    }

    @FXML
    void addLocalisation(ActionEvent event) throws IOException {
        StageSetter.buildStage("AddLocalisation.fxml",bundle.getString("aL"),bundle);
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
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
    }

    @FXML
    void langPL(ActionEvent event) throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
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
    @FXML
    void saveCategoryChanges(ActionEvent event) {

    }
    @FXML
    void deleteCategory(ActionEvent event) {

    }

}
