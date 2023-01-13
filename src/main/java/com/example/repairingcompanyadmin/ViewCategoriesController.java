package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.VisitCategory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewCategoriesController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private TextArea categoriesList;


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
        StageSetter.buildStage("viewCategories.fxml",bundle.getString("vCtg"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("viewCategories.fxml",bundle.getString("vCtg"),bundle);
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
        JSONApi api = new JSONApi("http://localhost:8080/api/v1/visit/category/all", "GET", VisitCategory[].class);
        VisitCategory[] visitCategories = (VisitCategory[]) api.readValue();
//        categoriesList.setText(api.prettifyJSON(visitCategories));
        for (VisitCategory category : visitCategories){
            categoriesList.appendText("opis: " + category.humanReadableLabel() + "\n czas trwania: " + category.durationHours() + "h \n \n");
        }
        categoriesList.setEditable(false);
    }

}
