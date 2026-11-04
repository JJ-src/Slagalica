module com.example.slagalica {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.slagalica to javafx.fxml;
    exports com.example.slagalica;
}