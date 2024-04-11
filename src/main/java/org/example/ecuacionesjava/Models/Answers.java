package org.example.ecuacionesjava.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.ecuacionesjava.DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Answers {
    int IdAnswer;
    int IdQuestion;
    int IdValue;
    String Answer;
    static Answers instance;

    public ObservableList<Answers> getAnswers(int IdPregunta) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        ObservableList<Answers> answers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ecuaciones.answers where idQuestion=?";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, IdPregunta);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idAnswer = resultSet.getInt(1);
                    int idQuestion = resultSet.getInt(2);
                    int idValue = resultSet.getInt(3);
                    String answer = resultSet.getString(4);
                    Answers answer1 = new Answers(idAnswer, idQuestion, idValue, answer);
                    answers.add(answer1);
                }
                database.dropConnection();
                System.out.println("Listo");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return answers;
    }

    public static Answers getInstance() {
        if (instance == null) {
            instance = new Answers();
        }
        return instance;
    }

    @Override
    public String toString() {
        return getAnswer();
    }
}
