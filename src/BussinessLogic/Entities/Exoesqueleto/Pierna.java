package BussinessLogic.Entities.Exoesqueleto;


public class Pierna {
    private String piernaIzquierda;
    private String piernaDerecha;
    private String habilidad;
    private String Pierna;
    public Pierna(){
        
    }
    
    public Pierna(String piernaIzquierda, String piernaDerecha, String habilidad){
        this.piernaIzquierda = piernaIzquierda;
        this.piernaDerecha = piernaDerecha;
        this.habilidad= habilidad;
    }
    public void habilidad(){
        System.out.println("Ahora el exobot puede correr a altas velocidades y dar grandes saltos");
    }
    
    }
