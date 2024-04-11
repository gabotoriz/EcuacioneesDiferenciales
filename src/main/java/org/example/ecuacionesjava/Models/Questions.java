package org.example.ecuacionesjava.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.ecuacionesjava.DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Questions {
    int IdQuestion;
    String Question;
    static Questions instance;

    public ObservableList<Questions> getQuestions(int _IdQuestion, Label pregunta) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        ObservableList<Questions> questions = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ecuaciones.questions WHERE IdQuestion = ?";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, _IdQuestion);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idQuestion = resultSet.getInt(1);
                    String _question = resultSet.getString(2);
                    Questions question = new Questions(idQuestion, _question);
                    questions.add(question);
                    pregunta.setText(_question);
                }
                database.dropConnection();
                System.out.println("Listo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    public static Questions getInstance() {
        if (instance == null) {
            instance = new Questions();
        }
        return instance;
    }

    @Override
    public String toString() {
        return getQuestion();
    }


}
