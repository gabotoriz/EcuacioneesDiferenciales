package org.example.ecuacionesjava.Controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.ecuacionesjava.Models.Answers;
import org.example.ecuacionesjava.Models.Cuestionary;
import org.example.ecuacionesjava.Models.Questions;
import org.example.ecuacionesjava.Models.User;

import java.net.URL;
import java.util.ResourceBundle;


@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FormController implements Initializable {
    @FXML
    Pane P_Questions;
    @FXML
    MFXButton BTN_RegistrarUsuario;
    @FXML
    TextField JTF_Usuario;
    @FXML
    MFXComboBox<Answers> CB_Answer1;
    @FXML
    MFXComboBox<Answers> CB_Answer2;
    @FXML
    MFXComboBox<Answers> CB_Answer3;
    @FXML
    MFXComboBox<Answers> CB_Answer4;
    @FXML
    MFXComboBox<Answers> CB_Answer5;
    @FXML
    MFXButton BTN_Registrar;
    @FXML
    Label L_Question5;
    @FXML
    Label L_Question2;
    @FXML
    Label L_Question3;
    @FXML
    Label L_Question4;
    @FXML
    Label L_Question1;

    public void getAnswers() {
        //SOLICITA A LA BASE DE DATOS LA LISTA DE RESPUESTAS SEGUN EL ID DE LA PREGUNTA
        Answers answers = Answers.getInstance();
        getCB_Answer1().setItems(answers.getAnswers(1));
        getCB_Answer2().setItems(answers.getAnswers(2));
        getCB_Answer3().setItems(answers.getAnswers(3));
        getCB_Answer4().setItems(answers.getAnswers(4));
        getCB_Answer5().setItems(answers.getAnswers(5));
    }

    public void getQuestions() {
        //SOLICITA A LA BASE DE DATOS LA LISTA DE PREGUNTAS SEGUN EL ID DE LA PREGUNTA Y LOS PONE EN LOS LABEL SCORRESPONDIENTES
        Questions questions = Questions.getInstance();
        questions.getQuestions(1, L_Question1);
        questions.getQuestions(2, L_Question2);
        questions.getQuestions(3, L_Question3);
        questions.getQuestions(4, L_Question4);
        questions.getQuestions(5, L_Question5);
    }

    public void insertIntoUser() {//REGISTRA AL USUARIO QUE VA A CONTESTAR EL EXAMEN
        User user = User.getInstance();
        String Usuario = getJTF_Usuario().getText().toUpperCase().trim();
        if (!Usuario.isEmpty()) {//SI EL USUARIO PONE UN NOMBRE DE USUARIO SE REGISTRA EN LA BASE DE DATOS
            getJTF_Usuario().setEditable(false);
            user.insertIntoUser(JTF_Usuario.getText());
            getJTF_Usuario().setText(Usuario);
            getP_Questions().setVisible(true);

        } else {//CASO CONTRATIO DA LA INFORMACIUON DE QUE DEBE DE PONER UN NOMBRE DE USUARIO
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("El campo de usuario no puede estar vacio");
            alert.show();
        }
    }

    public void setCuestionarys(int idUser, int idQuestions, int idAnswer) {
        Cuestionary cuestionary = Cuestionary.getInstance();
        cuestionary.insertIntoCuestionary(idUser, idQuestions, idAnswer);
    }

    public void insertIntoCuestionary() {
        //REGISTRA LAS RESPUESTAS DEL USUARIO EN LA BASE DE DATOS
        User user = User.getInstance();
        int IdUser = user.getUsers(getJTF_Usuario().getText());
        int idQuestions = 1;
        int idAnswer = getCB_Answer1().getSelectionModel().getSelectedItem().getIdAnswer();
        setCuestionarys(IdUser, idQuestions, idAnswer);
        insertIntoCuestionary2();
        insertIntoCuestionary3();
        insertIntoCuestionary4();
        insertIntoCuestionary5();

    }

    public void insertIntoCuestionary2() {
        User user = User.getInstance();
        int IdUser = user.getUsers(getJTF_Usuario().getText());
        int idQuestions = 2;
        int idAnswer = getCB_Answer2().getSelectionModel().getSelectedItem().getIdAnswer();
        setCuestionarys(IdUser, idQuestions, idAnswer);
    }

    public void insertIntoCuestionary3() {
        User user = User.getInstance();
        int IdUser = user.getUsers(getJTF_Usuario().getText());
        int idQuestions = 3;
        int idAnswer = getCB_Answer3().getSelectionModel().getSelectedItem().getIdAnswer();
        setCuestionarys(IdUser, idQuestions, idAnswer);
    }

    public void insertIntoCuestionary4() {
        User user = User.getInstance();
        int IdUser = user.getUsers(getJTF_Usuario().getText());
        int idQuestions = 4;
        int idAnswer = getCB_Answer4().getSelectionModel().getSelectedItem().getIdAnswer();
        setCuestionarys(IdUser, idQuestions, idAnswer);
    }

    public void insertIntoCuestionary5() {
        User user = User.getInstance();
        int IdUser = user.getUsers(getJTF_Usuario().getText());
        int idQuestions = 5;
        int idAnswer = getCB_Answer5().getSelectionModel().getSelectedItem().getIdAnswer();
        setCuestionarys(IdUser, idQuestions, idAnswer);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAnswers();
        getQuestions();
    }
}
