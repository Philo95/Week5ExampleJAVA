module com.example.week5example {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week5example to javafx.fxml;
    exports com.example.week5example;
}