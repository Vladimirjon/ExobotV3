package DataAccess;

  

//import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.SexoDTO;
import Framework.PatException;

import DataAccess.ExobotDTO;
import Framework.PatException;  
  
public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO> {  
  

  
    public ExobotDAO() {  
        
    }  
  
    @Override  
    public ExobotDTO readBy(Integer id) throws Exception {  
        ExobotDTO  soldado = null; 
        try {
            
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery("SELECT * FROM Exobot WHERE IdExobot = " + id);                      
            
            
            if (rs.next()) {  
                soldado = new ExobotDTO(rs.getInt("IdExobot"),rs.getString("Nombre"));  
            } else {  
                soldado = null;  
            }
        }
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
         catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return soldado;
    }  
  
    @Override  
    public List<ExobotDTO> readAll() throws Exception {
        Connection connection = openConnection();  
        List<ExobotDTO> soldiers = new ArrayList<>();  
        Statement statement = connection.createStatement();  
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Exobot");  
        while(resultSet.next()) {  
            soldiers.add(new ExobotDTO(resultSet.getInt("IdExobot"),resultSet.getString("Nombre")));  
        }  
        return soldiers;  
    }  
  
    @Override  
    public boolean create(ExobotDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Exobot (Nombre) VALUES (?)");  
        statement.setString(1, entity.getNombre());  
        return statement.executeUpdate() > 0; 
         
    }  
  
    @Override  
    public boolean update(ExobotDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("UPDATE Exobot SET Nombre = ? WHERE IdExobot = ?");  
        statement.setString(1, entity.getNombre());  
        statement.setInt(2, entity.getIdExobot());  
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

