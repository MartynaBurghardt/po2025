module com.example.samochodgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;


    opens com.example.samochodgui to javafx.fxml;
    exports com.example.samochodgui;
}