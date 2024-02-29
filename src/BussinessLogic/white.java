package BussinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BussinessLogic.Entities.EjercitoRuso.Humano;
import BussinessLogic.Entities.EjercitoRuso.Soldado;

public class white {

    static Soldado oSoldado = new Soldado();

    public static void main(String[] args) {
        oSoldado.agregarNombres();
    }
    public void escribirNombresSoldados() {  
        // Conexión a la base de datos  
        Connection conexion = null;  
  
        try {  
            // Abre la conexión a la base de datos  
            // Reemplaza "url", "usuario" y "contraseña" por tus propios valores  
            conexion = DriverManager.getConnection("url", "usuario", "contraseña");  
  
            // Prepara la consulta SQL para insertar un nombre  
            String consultaSQL = "INSERT INTO Soldados (nombre) VALUES (?)";  
            PreparedStatement sentencia = conexion.prepareStatement(consultaSQL);  
  
            // Inserta cada nombre en la base de datos  
            for (String nombre : Soldado.getArrayList) {  
                sentencia.setString(1, nombre);  
                sentencia.executeUpdate();  
            }  
        } catch (SQLException e) {  
            // Maneja cualquier error que pueda ocurrir  
            e.printStackTrace();  
        } finally {  
            // Cierra la conexión a la base de datos  
            if (conexion != null) {  
                try {  
                    conexion.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
}

