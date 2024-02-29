package BussinessLogic;

import DataAccess.DTO.SoldadoDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Soldadoconndata {
    public static void main(String[] args) {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database
            String url = "jdbc:sqlite:../Database/Soldado.sqlite";
            Connection connection = DriverManager.getConnection(url);

            // Insert data into the Soldado table for 20 soldiers
            for (int i = 1; i <= 20; i++) {
                SoldadoDTO soldado = new SoldadoDTO(i, "WLADIMIR" + i);
                insertSoldado(connection, soldado);
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertSoldado(Connection connection, SoldadoDTO soldado) throws SQLException {
        String insertQuery = "INSERT INTO Soldado(IdSoldado, Nombre) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, soldado.getIdSoldado());
            preparedStatement.setString(2, soldado.getNombreSoldado());
            preparedStatement.executeUpdate();
        }
    }
}