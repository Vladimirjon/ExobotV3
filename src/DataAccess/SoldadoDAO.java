package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.SoldadoDTO;

public class SoldadoDAO extends SQLiteDataHelper implements IDAO<SoldadoDTO>{
    @Override
    public SoldadoDTO readBy(Integer id) throws Exception{
        SoldadoDTO sdto = new SoldadoDTO();

        // private Integer IdSoldado;
        // private String NombreSoldado;
    
        String query = " SELECT IdSoldado  "
                + " ,NombreSoldado  "
                + " , WHERE IdSoldado "+ id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                sdto = new SoldadoDTO(rs.getInt(1)// IdSoldado
                    ,rs.getString(2));// NombreSoldado
            }
        }catch(SQLException exception){
            throw exception;
        }
        return sdto;

    }
    @Override
    public List<SoldadoDTO> readAll() throws Exception {
        List<SoldadoDTO> lst = new ArrayList<>();
        String query = " SELECT IdSoldado  "
                + " , NombreSoldado  "
                + " , FROM IdSoldado";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                SoldadoDTO sold = new SoldadoDTO(rs.getInt(1) // IdSoldado
                ,rs.getString(6));// NombreSoldado
                lst.add(sold);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(SoldadoDTO entity) throws Exception {
        String query = " INSERT INTO Soldado (NombreSoldado) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSoldado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    

    @Override
    public boolean update(SoldadoDTO entity) throws Exception {
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Soldado SET NombreSoldado = ? WHERE IdSoldado = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSoldado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " Delete Soldado WHERE IdSoldado = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

}
