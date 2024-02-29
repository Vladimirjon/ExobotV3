package BussinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            
            // String urlexobot = "jdbc:sqlitec:sqlite:/ruta/a/tu/base/de/datos.db";
            String urlexobot = "jdbc:sqlite:Database/Exobot.sqlite";
            String urlsoldado = "jdbc:sqlite:Database/Soldado.sqlite";

            return DriverManager.getConnection(urlsoldado); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}