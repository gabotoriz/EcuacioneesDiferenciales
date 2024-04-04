package org.example.ecuacionesjava.Controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.ecuacionesjava.Switcher;
import org.example.ecuacionesjava.Views;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainController {
    @FXML
    MFXButton BTN_Ejemplos;
    @FXML
    MFXButton BTN_Cuestionario;
    @FXML
    MFXButton BTN_Salir;
    @FXML
    MFXButton BTN_Teoria;

    public void toTeoria() {
        Switcher.switchTo(Views.Theory);
    }

    public void toCuestionary() {
        Switcher.switchTo(Views.Cuestionary);
    }

    public void toEjemplos() {
        Switcher.switchTo(Views.Examples);
    }

    public void toSalir() {
        System.exit(1);
    }
}