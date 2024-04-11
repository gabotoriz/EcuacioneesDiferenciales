package org.example.ecuacionesjava.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ecuacionesjava.DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cuestionary {
    int idCuestionary;
    int idUser;
    int idQuestion;
    int Answer;
    static Cuestionary instance;

    public ObservableList<Cuestionary> selectCuestionary() {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ObservableList<Cuestionary> cuestionary = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ecuaciones.cuestionary";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int idCuestionary = rs.getInt(1);
                    int idUser = rs.getInt(2);
                    int idQuestion = rs.getInt(3);
                    int Answer = rs.getInt(4);
                    Cuestionary cuestionary1 = new Cuestionary(idCuestionary, idUser, idQuestion, Answer);
                    cuestionary.add(cuestionary1);
                }
                database.dropConnection();
                System.out.println("Listo");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cuestionary;
    }

    public void insertIntoCuestionary(int IdUser, int IdQuestion, int IdAnswer) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ObservableList<Cuestionary> cuestionary = FXCollections.observableArrayList();
        String sql = "INSERT INTO ecuaciones.cuestionary (idUser, idQuestion, idAnswer) VALUES (?,?,?)";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, IdUser);
                ps.setInt(2, IdQuestion);
                ps.setInt(3, IdAnswer);
                ps.executeUpdate();
                database.dropConnection();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Cuestionary getInstance() {
        if (instance == null) {
            instance = new Cuestionary();
        }
        return instance;
    }

}
