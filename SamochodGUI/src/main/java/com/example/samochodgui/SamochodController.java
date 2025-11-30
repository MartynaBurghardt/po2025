package com.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Kontroler został załadowany!");

        samochody.add(new Samochod("Toyota", "ABC123", 1200, 0));
        samochody.add(new Samochod("BMW", "XYZ789", 1500, 0));
        samochody.add(new Samochod("Range Rover", "RR2025", 2200, 0));

        samochodComboBox.setItems(FXCollections.observableArrayList(
                samochody.stream().map(Samochod::getModel).toList()
        ));

        samochodComboBox.setOnAction(event -> {
            int index = samochodComboBox.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                aktualnySamochod = samochody.get(index);
                aktualizujPola();
            }
        });
    }

    @FXML
    private void onDodajNowyClick() {
        System.out.println("Dodawanie nowego samochodu...");

        Samochod nowy = new Samochod("Nowy", "000000", 1000, 0);
        samochody.add(nowy);

        samochodComboBox.getItems().add(nowy.getModel());
    }

    @FXML
    private void onUsunClick() {
        System.out.println("Usuwanie samochodu...");

        int index = samochodComboBox.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            samochody.remove(index);
            samochodComboBox.getItems().remove(index);
        }
    }

    @FXML
    private void onPrzyciskClick() {
        System.out.println("Kliknięto dodatkowy przycisk!");
    }

    @FXML
    private void onWlaczClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.wlacz();
            aktualizujPola();
        }
    }

    @FXML
    private void onWylaczClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.wylacz();
            aktualizujPola();
        }
    }

    @FXML
    private void onZwiekszBiegClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.zwiekszBieg();
            aktualizujPola();
        }
    }

    @FXML
    private void onZmniejszBiegClick() {
        if (aktualnySamochod != null) {
            aktualnySamochod.zmniejszBieg();
            aktualizujPola();
        }
    }

    private void aktualizujPola() {
        modelTextField.setText(aktualnySamochod.getModel());
        nrRejestracyjnyTextField.setText(aktualnySamochod.getNrRejestracyjny());
        wagaTextField.setText(String.valueOf(aktualnySamochod.getWaga()));
        predkoscTextField.setText(String.valueOf(aktualnySamochod.getPredkosc()));
        biegTextField.setText(String.valueOf(aktualnySamochod.getBieg()));
        stanSilnikaTextField.setText(aktualnySamochod.isSilnikWlaczony() ? "ON" : "OFF");
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

        public void wlacz() { silnikWlaczony = true; }
        public void wylacz() { silnikWlaczony = false; predkosc = 0; bieg = 0; }
        public void zwiekszBieg() { if (bieg < 6) bieg++; }
        public void zmniejszBieg() { if (bieg > 0) bieg--; }

        public String getModel() { return model; }
        public String getNrRejestracyjny() { return nrRejestracyjny; }
        public int getWaga() { return waga; }
        public int getPredkosc() { return predkosc; }
        public int getBieg() { return bieg; }
        public boolean isSilnikWlaczony() { return silnikWlaczony; }
    }
}
