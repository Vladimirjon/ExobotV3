package DataAccess.DTO;

  
public class ExobotDTO {  
    private Integer idExobot;  
    private String modelo;  
    private String armaIzquierda;  
    private String armaDerecha;  
    private Boolean aprenderEspanol;
    private Boolean aprenderIngles;
    
    public ExobotDTO() {}  
  
    public ExobotDTO(Integer Id, String modelo,String armaIzq,String armaDer,Boolean espanol, Boolean ingles) {  
        this.idExobot = Id;  
        this.modelo = modelo;  
        this.armaIzquierda= armaIzq; 
        this.armaDerecha= armaDer;    
        this.aprenderEspanol=espanol;
        this.aprenderIngles= ingles;
    }  

    public Integer getIdExobot() {
        return idExobot;
    }

    public void setIdExobot(Integer idExobot) {
        this.idExobot = idExobot;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getArmaIzquierda() {
        return armaIzquierda;
    }

    public void setArmaIzquierda(String armaIzquierda) {
        this.armaIzquierda = armaIzquierda;
    }

    public String getArmaDerecha() {
        return armaDerecha;
    }

    public void setArmaDerecha(String armaDerecha) {
        this.armaDerecha = armaDerecha;
    }
    public Boolean getAprenderEspanol() {
        return aprenderEspanol;
    }

    public void setAprenderEspanol(Boolean aprenderEspanol) {
        this.aprenderEspanol = aprenderEspanol;
    }
    public Boolean getAprenderIngles() {
        return aprenderIngles;
    }

    public void setAprenderIngles(Boolean aprenderIngles) {
        this.aprenderIngles = aprenderIngles;
    }

  

  

}
