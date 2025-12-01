package com.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;


    @FXML private ChoiceBox<String> engineChoiceBox;
    @FXML private ChoiceBox<String> gearboxChoiceBox;


    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    private SamochodController mainController;

    public DodajSamochodController(SamochodController mainController) {
        this.mainController = mainController;
    }
    public DodajSamochodController() {}

    @FXML
    public void initialize() {
        engineChoiceBox.setItems(FXCollections.observableArrayList("Benzyna 1.6L", "Diesel 2.0L", "Elektryczny"));
        engineChoiceBox.getSelectionModel().selectFirst();

        gearboxChoiceBox.setItems(FXCollections.observableArrayList("Manualna (5-biegowa)", "Automatyczna (8-biegowa)"));
        gearboxChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie."); // [cite: 81]
            return;
        }

        if (mainController != null) {
            mainController.addNewCar(model, registration, (int) weight, speed);
        }

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
