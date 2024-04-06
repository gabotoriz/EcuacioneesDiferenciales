package org.example.ecuacionesjava.Controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.ecuacionesjava.Models.User;

import java.net.URL;
import java.util.ResourceBundle;


@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CuestionaryController implements Initializable {
    @FXML
    VBox VB_Question1;
    @FXML
    VBox VB_Question2;
    @FXML
    VBox VB_Question3;
    @FXML
    VBox VB_Question4;
    @FXML
    VBox VB_Question5;
    @FXML
    Pane P_Questions;
    @FXML
    Pane P_Usaurio;
    @FXML
    Label L_Usaurio;
    @FXML
    TextField JTF_Usuario;
    @FXML
    MFXButton MFXB_Registrar;

    final String user = getJTF_Usuario().getText().toUpperCase().trim();

    public void registrarUser() {
        User u = User.getInstance();
        if (u.insertIntoUser(user)) {
            activateQuestions();
            getJTF_Usuario().setEditable(false);
        } else {
            getJTF_Usuario().clear();
        }

    }


    public void desactivateQuestions() {
        getP_Questions().setVisible(false);
        getVB_Question1().setVisible(false);
        getVB_Question2().setVisible(false);
        getVB_Question3().setVisible(false);
        getVB_Question4().setVisible(false);
        getVB_Question5().setVisible(false);
    }

    public void activateQuestions() {
        getP_Questions().setVisible(true);
        getVB_Question1().setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        desactivateQuestions();
    }
}
