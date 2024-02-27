package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnectionExobot = "jdbc:sqlite:database//Exobot.sqlite"; 
    private static String DBPathConnectionSoldado = "jdbc:sqlite:database//Soldado.sqlite"; 
    private static Connection conn = null;
    protected SQLiteDataHelper(){    }
    
    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnectionExobot);
                conn = DriverManager.getConnection(DBPathConnectionSoldado);
        } catch (SQLException e) {
             throw e; //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return conn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw e;//new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}

