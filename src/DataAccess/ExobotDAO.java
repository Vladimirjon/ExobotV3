package DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.ExobotDTO;

public class ExobotDAO extends SQLiteDataHelper implements IDAO<ExobotDTO>{
    @Override
    public ExobotDTO readBy(Integer id) throws Exception{
        ExobotDTO edto = new ExobotDTO();

        // private Integer IdExobot;
        // private String Serie;
        // private String ArmaBrazoIzquierdo;
        // private String ArmaBrazoDerecho;
        // private Boolean ProfeEspanol;
        // private Boolean ProfeIngles;
        String query = " SELECT IdExobot  "
                + " ,Modelo_Serie  "
                + " , Arma Brazo Izquierdo "
                + " , Arma Brazo Derecho "
                + " , Aprender Espanol "
                + " , Aprender Ingles "
                + " , WHERE IdExobot "+ id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                edto = new ExobotDTO(rs.getInt(1)// IdExobot
                    ,rs.getString(2)// Modelo_Serie
                    ,rs.getString(3)// Arma Izquieda
                    ,rs.getString(4)// Arma Derecha
                    ,rs.getBoolean(5)// Espanol
                    ,rs.getBoolean(6));// Ingles
            }
        }catch(SQLException exception){
            throw exception;
        }
        return edto;

    }
    @Override
    public List<ExobotDTO> readAll() throws Exception {
        List<ExobotDTO> lst = new ArrayList<>();
        String query = " SELECT IdExobot  "
                + " ,Modelo_Serie  "
                + " , Arma Brazo Izquierdo "
                + " , Arma Brazo Derecho "
                + " , Aprender Espanol "
                + " , Aprender Ingles "
                + " , FROM IdExobot ";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                ExobotDTO exo = new ExobotDTO(rs.getInt(1) // IdSexo
                ,rs.getString(2)// Modelo_Serie
                ,rs.getString(3)// Arma Izquieda
                ,rs.getString(4)// Arma Derecha
                ,rs.getBoolean(5)// Espanol
                ,rs.getBoolean(6));// Ingles
                lst.add(exo);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(ExobotDTO entity) throws Exception {
        String query = " INSERT INTO Exobot (Modelo_Serie, ArmaIzquierda, ArmaDerecha, AprenderEspanol, AprenderIngles) VALUES (?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getSerie());
            pstmt.setString(2, entity.getArmaBrazoIzquierdo());
            pstmt.setString(3, entity.getArmaBrazoDerecho());
            pstmt.setBoolean(4, entity.getProfeEspanol());
            pstmt.setBoolean(5, entity.getProfeIngles());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(ExobotDTO entity) throws Exception {
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE Exobot SET Modelo_Serie = ?, ArmaIzquierda = ?, ArmaDerecha = ?, AprenderEspanol = ?, AprenderIngles  = ? WHERE IdExobot = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getSerie());
            pstmt.setString(2, entity.getArmaBrazoIzquierdo());
            pstmt.setString(3, entity.getArmaBrazoDerecho());
            pstmt.setBoolean(4, entity.getProfeEspanol());
            pstmt.setBoolean(5, entity.getProfeIngles());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " Delete Exobot WHERE IdExobot = ?";
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
