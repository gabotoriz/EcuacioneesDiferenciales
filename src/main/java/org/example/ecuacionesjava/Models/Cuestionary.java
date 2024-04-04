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
import java.sql.SQLException;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cuestionary {
    int IdPregunta;
    String Usuario;
    String Pregunta;
    String Respuesta;
    int Puntuacion;


    public void insertIntoCuestionary(String _Usuario, String _Preguna, String _Respuesta, int _Puntuacion) {
        Database database = Database.getInstance();
        Connection databaseConnection = database.getConnection();
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO ecuaciones.cuestionary (Usuario, Pregunta, Respuesta, Puntuacion)values (?,?,?,?)";
        try {
            if (databaseConnection != null) {
                preparedStatement = databaseConnection.prepareStatement(sql);
                preparedStatement.setString(1, _Usuario);
                preparedStatement.setString(2, _Preguna);
                preparedStatement.setString(3, _Respuesta);
                preparedStatement.setInt(4, _Puntuacion);
                preparedStatement.execute();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Conexion");
                alert.setContentText("Hubo un error en la conexion\nRevise su conexion de internet y vuelva a intentarlo");
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
