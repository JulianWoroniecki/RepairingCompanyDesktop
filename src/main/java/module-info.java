module com.example.repairingcompanyadmin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    opens com.example.repairingcompanyadmin to javafx.fxml;
    opens com.example.repairingcompanyadmin.dto to com.fasterxml.jackson.databind;
    exports com.example.repairingcompanyadmin;
    exports com.example.repairingcompanyadmin.dto;
}