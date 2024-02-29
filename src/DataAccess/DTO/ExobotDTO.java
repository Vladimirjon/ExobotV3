package DataAccess.DTO;

  
public class ExobotDTO {  
    private Integer idExobot;  
    private String nombre;  
  
    public ExobotDTO() {}  
  
    public ExobotDTO(Integer Id, String nombre) {  
        this.idExobot = Id;  
        this.nombre = nombre;  
    }  
  
    public Integer getIdExobot() {  
        return idExobot;  
    }  
  
    public void setIdExobot(Integer idExobot) {  
        this.idExobot = idExobot;  
    }  
  
    public String getNombre() {  
        return nombre;  
    }  
  
    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  
}
