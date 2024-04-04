package org.example.ecuacionesjava.DataBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Database {
    static Settings settings = Settings.getInstance();
    static Connection connection;
    static Database instancia;
    ResultSet rs;
    PreparedStatement ps;

    //CREAR CONECCION
    public Connection getConnection() {
        try {
            Class.forName(settings.getDriver());
            connection = DriverManager.getConnection(settings.getURL(), settings.getUser(), settings.getPassword());
            return connection;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //TIRAR CONEXION
    public void dropConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        if (instancia == null) {
            instancia = new Database();
        }
        return instancia;
    }

}
