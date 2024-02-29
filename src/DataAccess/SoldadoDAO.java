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

import DataAccess.SoldadoDTO;
import Framework.PatException;  
  
public class SoldadoDAO extends SQLiteDataHelper implements IDAO<SoldadoDTO> {  
  

  
    public SoldadoDAO() {  
        
    }  
  
    @Override  
    public SoldadoDTO readBy(Integer id) throws Exception {  
        SoldadoDTO  soldado = null; 
        try {
            
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery("SELECT * FROM Soldado WHERE IdSoldado = " + id);                      
            
            
            if (rs.next()) {  
                soldado = new SoldadoDTO(rs.getInt("IdSoldado"),rs.getString("Nombre"));  
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
    public List<SoldadoDTO> readAll() throws Exception {
        Connection connection = openConnection();  
        List<SoldadoDTO> soldiers = new ArrayList<>();  
        Statement statement = connection.createStatement();  
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Soldado");  
        while(resultSet.next()) {  
            soldiers.add(new SoldadoDTO(resultSet.getInt("IdSoldado"),resultSet.getString("Nombre")));  
        }  
        return soldiers;  
    }  
  
    @Override  
    public boolean create(SoldadoDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Soldado (Nombre) VALUES (?)");  
        statement.setString(1, entity.getNombre());  
        return statement.executeUpdate() > 0; 
         
    }  
  
    @Override  
    public boolean update(SoldadoDTO entity) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("UPDATE Soldado SET Nombre = ? WHERE IdSoldado = ?");  
        statement.setString(1, entity.getNombre());  
        statement.setInt(2, entity.getIdSoldado());  
        return statement.executeUpdate() > 0;  
    }  
  
    @Override  
    public boolean delete(Integer id) throws Exception {
        Connection connection = openConnection();  
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Soldado WHERE IdSoldado = ?");  
        statement.setInt(1, id);  
        return statement.executeUpdate() > 0;  
    }  
}
