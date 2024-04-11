package org.example.ecuacionesjava.Models;

import javafx.scene.control.Alert;
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
public class User {
    int IdUser;
    String Name;
    static User instancia;

    public void insertIntoUser(String _Name) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement ps_insert = null, ps_select = null;
        ResultSet rs_select = null;
        String select = "select * from ecuaciones.users where User = ?";
        String insert = "INSERT INTO ecuaciones.users (User) VALUES (?)";
        try {
            if (connection != null) {
                ps_select = connection.prepareStatement(select);
                ps_select.setString(1, _Name);
                rs_select = ps_select.executeQuery();
                if (rs_select.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Usuario Existente");
                    alert.setContentText("El usuario " + _Name + " ya existe");
                    alert.showAndWait();
                } else {
                    ps_insert = connection.prepareStatement(insert);
                    ps_insert.setString(1, _Name);
                    ps_insert.execute();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUsers(String Usuario) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement ps_select;
        ResultSet resultSet;
        int idUser = 0;
        String select = "SELECT * FROM ecuaciones.users where User = ?";
        try {
            if (connection != null) {
                ps_select = connection.prepareStatement(select);
                ps_select.setString(1, Usuario);
                resultSet = ps_select.executeQuery();
                while (resultSet.next()) {
                    idUser = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    User user = new User(idUser, name);

                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return idUser;


    }

    public static User getInstance() {
        if (instancia == null) {
            instancia = new User();
        }
        return instancia;
    }
}
