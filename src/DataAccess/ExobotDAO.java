package DataAccess;

  

//import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataAccess.DTO.ExobotDTO;
import Framework.PatException;
  
public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO> {  
  

  
    public ExobotDAO() {  
        
    }  
  
    @Override  
    public ExobotDTO readBy(Integer id) throws Exception {  
        ExobotDTO  exobot = null; 
        try {
            
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery("SELECT * FROM Exobot WHERE IdExobot = " + id);                      
            
            
            if (rs.next()) {  
                exobot = new ExobotDTO(rs.getInt("IdExobot"),rs.getString("Modelo"),rs.getString("Arma Izquieda")
                ,rs.getString("Arma Derecha"),rs.getBoolean("Aprender Espanol"),rs.getBoolean("Aprender Ingles"));  
            } else {  
                exobot = null;  
            }
        }
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
         catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return exobot;
    }  
  
    @Override  
    public List<ExobotDTO> readAll() throws Exception {
        Connection connection = openConnection();  
        List<ExobotDTO> exobots = new ArrayList<>();  
        Statement statement = connection.createStatement();  
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Exobot");  
        while(resultSet.next()) {  
            exobots.add(new ExobotDTO(resultSet.getInt("IdExobot"),resultSet.getString("Modelo"),resultSet.getString("Arma Izquieda")
            ,resultSet.getString("Arma Derecha"),resultSet.getBoolean("Aprender Espanol"),resultSet.getBoolean("Aprender Ingles")));  
        }  
        return exobots;  
    }  
  
    @Override  
    public boolean create(ExobotDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Exobot (Modelo) VALUES (?)");  
        statement.setString(1, entity.getModelo());  
        return statement.executeUpdate() > 0; 
         
    }  
  
    @Override  
    public boolean update(ExobotDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("UPDATE Exobot SET Modelo = ? WHERE IdExobot = ?");  
        statement.setInt(1, entity.getIdExobot());  
        statement.setString(2, entity.getModelo());  
        statement.setString(3, entity.getArmaIzquierda());  
        statement.setString(4, entity.getArmaDerecha());  
        statement.setBoolean(5, true);
        statement.setBoolean(6, true);
        return statement.executeUpdate() > 0;  
    }  
  
    @Override  
    public boolean delete(Integer id) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Exobot WHERE IdExobot = ?");  
        statement.setInt(1, id);  
        return statement.executeUpdate() > 0;  
    }  
}

