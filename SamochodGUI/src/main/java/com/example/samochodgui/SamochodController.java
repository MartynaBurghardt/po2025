package com.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class SamochodController {

    @FXML private Button dodajNowyButton;
    @FXML private Button usunButton;
    @FXML private Button wlaczButton;
    @FXML private Button wylaczButton;
    @FXML private Button zwiekszBiegButton;
    @FXML private Button zmniejszBiegButton;
    @FXML private Button przyciskButton;

    @FXML private ComboBox<String> samochodComboBox;

    @FXML private TextField modelTextField;
    @FXML private TextField nrRejestracyjnyTextField;
    @FXML private TextField wagaTextField;
    @FXML private TextField predkoscTextField;
    @FXML private TextField biegTextField;
    @FXML private TextField stanSilnikaTextField;

    private List<Samochod> samochody = new ArrayList<>();
    private Samochod aktualnySamochod;

    @FXML
    public void initialize() {
        samochody.add(new Samochod("Toyota", "ABC123", 1200, 200));
        samochody.add(new Samochod("BMW", "XYZ789", 1500, 250));
        samochody.add(new Samochod("Range Rover", "RR2025", 2200, 180));

        samochodComboBox.setItems(FXCollections.observableArrayList(
                samochody.stream().map(Samochod::getModel).toList()
        ));

        samochodComboBox.setOnAction(event -> {
            int index = samochodComboBox.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                aktualnySamochod = samochody.get(index);
                refresh();
            }
        });
    }

    @FXML
    private void onDodajNowyClick() {
        openAddCarWindow();
    }

    public void openAddCarWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));

            // Tworzymy nowy kontroler, przekazując mu referencję do tego kontrolera
            DodajSamochodController controller = new DodajSamochodController(this);
            loader.setController(controller);

            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Dodaj nowy samochód");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Obsługa błędu ładowania FXML
        }
    }

    /**
     * Metoda publiczna wywoływana przez DodajSamochodController, aby dodać nowy samochód.
     * Odpowiednik MainController.addCarToList z instrukcji.
     */
    public void addNewCar(String model, String nrRejestracyjny, double wagaDouble, int predkosc) {
        // Konwersja wagi na int, aby pasowała do obecnego modelu Samochod.
        int waga = (int) wagaDouble;

        Samochod nowy = new Samochod(model, nrRejestracyjny, waga, predkosc);
        samochody.add(nowy);
        samochodComboBox.getItems().add(nowy.getModel());

        // Wybieranie nowego samochodu i odświeżanie głównego widoku
        samochodComboBox.getSelectionModel().select(nowy.getModel());
        refresh();
    }

    @FXML
    private void onUsunClick() {
        int index = samochodComboBox.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            samochody.remove(index);
            samochodComboBox.getItems().remove(index);
            aktualnySamochod = null;
            refresh();
        }
    }

    @FXML
    private void onPrzyciskClick() {
    }

    @FXML
    private void onWlaczClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.wlacz();
            refresh();
        }
    }

    @FXML
    private void onWylaczClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.wylacz();
            refresh();
        }
    }

    @FXML
    private void onZwiekszBiegClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.zwiekszBieg();
            refresh();
        }
    }

    @FXML
    private void onZmniejszBiegClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.zmniejszBieg();
            refresh();
        }
    }

    private void refresh() {
        if (aktualnySamochod != null) {
            modelTextField.setText(aktualnySamochod.getModel());
            nrRejestracyjnyTextField.setText(aktualnySamochod.getNrRejestracyjny());
            wagaTextField.setText(String.valueOf(aktualnySamochod.getWaga()));
            predkoscTextField.setText(String.valueOf(aktualnySamochod.getPredkosc()));
            biegTextField.setText(String.valueOf(aktualnySamochod.getBieg()));
            stanSilnikaTextField.setText(aktualnySamochod.isSilnikWlaczony() ? "ON" : "OFF");
        } else {
            modelTextField.setText("");
            nrRejestracyjnyTextField.setText("");
            wagaTextField.setText("");
            predkoscTextField.setText("");
            biegTextField.setText("");
            stanSilnikaTextField.setText("");
        }
    }

    private static class Samochod {
        private String model;
        private String nrRejestracyjny;
        private int waga;
        private int predkosc;
        private int bieg;
        private boolean silnikWlaczony;

        public Samochod(String model, String nrRejestracyjny, int waga, int predkosc) {
            this.model = model;
            this.nrRejestracyjny = nrRejestracyjny;
            this.waga = waga;
            this.predkosc = predkosc;
            this.bieg = 0;
            this.silnikWlaczony = false;
        }

        public void wlacz() {
            silnikWlaczony = true;
        }

        public void wylacz() {
            silnikWlaczony = false;
            predkosc = 0;
            bieg = 0;
        }

        public void zwiekszBieg() {
            if (silnikWlaczony && bieg < 6) bieg++;
        }

        public void zmniejszBieg() {
            if (silnikWlaczony && bieg > 0) bieg--;
        }

        public String getModel() {
            return model;
        }

        public String getNrRejestracyjny() {
            return nrRejestracyjny;
        }

        public int getWaga() {
            return waga;
        }

        public int getPredkosc() {
            return predkosc;
        }

        public int getBieg() {
            return bieg;
        }

        public boolean isSilnikWlaczony() {
            return silnikWlaczony;
        }
    }
}