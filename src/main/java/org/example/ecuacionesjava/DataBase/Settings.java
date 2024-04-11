package org.example.ecuacionesjava.DataBase;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Settings {
    public static Settings instancia;
    String DataBase = "ecuaciones";
    String User = "root";
    String Password = "Gabo230105302.";
    String Driver = "com.mysql.cj.jdbc.Driver";
    String Ip = "127.0.0.1";
    String Port = "3306";
    String URL = "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getDataBase();

    public static Settings getInstance() {
        if (instancia == null) {
            instancia = new Settings();
        }
        return instancia;
    }

}
