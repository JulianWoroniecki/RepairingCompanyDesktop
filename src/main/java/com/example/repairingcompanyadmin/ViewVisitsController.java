package com.example.repairingcompanyadmin;

import com.example.repairingcompanyadmin.dto.Company;
import com.example.repairingcompanyadmin.dto.Visit;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewVisitsController {
    private final ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @FXML
    private TextArea visitsList;

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
        StageSetter.buildStage("ViewVisits.fxml",bundle.getString("vV"),bundle);
    }

    @FXML
    void langPL() throws IOException {
        Locale.setDefault(new Locale("pl"));
        StageSetter.buildStage("ViewVisits.fxml",bundle.getString("vV"),bundle);
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
        JSONApi api = new JSONApi("http://localhost:8080/api/v1/visit/all", "GET", Visit[].class);
        Visit[] visits = (Visit[]) api.readValue();
        for (Visit visit : visits){
            JSONApi api2 = new JSONApi("http://localhost:8080/api/v1/company/"+visit.id(), "GET", Company.class);
            Company company = (Company) api2.readValue();
            visitsList.appendText(visit.id().toString() + ". " +
                    visit.description() + "\n" +
                    bundle.getString("date") + ": "+ visit.date() + "\n" +
                    bundle.getString("cmp") + ": "+ company.companyName() + "\n" +
                    bundle.getString("sDate") + ": "+ visit.startTime() + "\n" +
                    bundle.getString("eDate") + ": "+ visit.endTime() + "\n\n"
            );
        }
        visitsList.setEditable(false);
    }

}
