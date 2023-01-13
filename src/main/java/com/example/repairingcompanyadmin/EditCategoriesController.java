package com.example.repairingcompanyadmin;


import com.example.repairingcompanyadmin.dto.VisitCategory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditCategoriesController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");

    @FXML
    private ComboBox<String> categoriesList;

    @FXML
    private TextField dHoursInput;

    @FXML
    private TextField descriptionInput;
    @FXML
    private TextField typeInput;

    VisitCategory[] categories;

    VisitCategory category;

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
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("EditCategories.fxml",bundle.getString("eCtg"),bundle);
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
    void saveCategoryChanges() {

    }
    @FXML
    void deleteCategory() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("conf"));
        alert.setContentText(bundle.getString("askConf"));
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            JSONApi api = new JSONApi("http://localhost:8080/api/v1/visit/category/delete/"+category.id(), "DELETE", String.class);
            api.deleteValue();
            load();
        }

    }
    private void clear(){
        categoriesList.getItems().clear();
        categoriesList.getSelectionModel().clearSelection();
        descriptionInput.clear();
        typeInput.clear();
        dHoursInput.clear();
    }
    private void load() throws IOException {
        clear();
        JSONApi api = new JSONApi("http://localhost:8080/api/v1/visit/category/all","GET",VisitCategory[].class);
        categories = (VisitCategory[]) api.readValue();
        for (VisitCategory category : categories){
            categoriesList.getItems().add(category.humanReadableLabel());
        }
    }
    @FXML
    void initialize() throws IOException {
        load();
    }
    @FXML
    void loadData() {
        if(!categoriesList.getSelectionModel().isEmpty()) {
            int indeks = categoriesList.getSelectionModel().getSelectedIndex();
            category = categories[indeks];
            descriptionInput.setText(category.humanReadableLabel());
            typeInput.setText(category.type());
            dHoursInput.setText(Long.toString(category.durationHours()) + 'h');
        }
    }
}
