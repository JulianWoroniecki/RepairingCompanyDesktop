module com.example.repairingcompanyadmin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.repairingcompanyadmin to javafx.fxml;
    exports com.example.repairingcompanyadmin;
}