package DataAccess.DTO;

public class ExobotDTO {
    private Integer IdExobot;
    private String Serie;
    private String ArmaBrazoIzquierdo;
    private String ArmaBrazoDerecho;
    private Boolean ProfeEspanol;
    private Boolean ProfeIngles;

    public ExobotDTO(){}

    public ExobotDTO(int idExobot,String serie,String armaizquierda,
                    String armaderecha,Boolean profespanol,Boolean profeingles){
        IdExobot=idExobot;
        Serie=serie;
        ArmaBrazoIzquierdo=armaizquierda;
        ArmaBrazoDerecho=armaderecha;
        ProfeEspanol=profespanol;
        ProfeIngles=profeingles;
    }

    public Integer getIdExobot() {
        return IdExobot;
    }
    public void setIdExobot(Integer idExobot) {
        IdExobot = idExobot;
    }
    public String getSerie() {
        return Serie;
    }
    public void setSerie(String serie) {
        Serie = serie;
    }
    public String getArmaBrazoIzquierdo() {
        return ArmaBrazoIzquierdo;
    }
    public void setArmaBrazoIzquierdo(String armaBrazoIzquierdo) {
        ArmaBrazoIzquierdo = armaBrazoIzquierdo;
    }
    public String getArmaBrazoDerecho() {
        return ArmaBrazoDerecho;
    }
    public void setArmaBrazoDerecho(String armaBrazoDerecho) {
        ArmaBrazoDerecho = armaBrazoDerecho;
    }
    public Boolean getProfeEspanol() {
        return ProfeEspanol;
    }
    public void setProfeEspanol(Boolean profeEspanol) {
        ProfeEspanol = profeEspanol;
    }
    public Boolean getProfeIngles() {
        return ProfeIngles;
    }
    public void setProfeIngles(Boolean profeIngles) {
        ProfeIngles = profeIngles;
    }

    public String toString(){
        return getClass().getName()
        + "\n IdExobot:       "+ getIdExobot()       
        + "\n ModeloSerie:       "+ getSerie()       
        + "\n Arma Izquierda:       "+ getArmaBrazoIzquierdo()       
        + "\n Arma Derecha:    "+ getArmaBrazoDerecho()    
        + "\n Aprender Espanol:"+ getProfeEspanol()
        + "\n Aprender Ingles:"+ getProfeIngles();
    }


}
