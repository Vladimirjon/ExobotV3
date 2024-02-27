package InteligenciaArtificial;

public class IABOT {
    private static IABOT instance;
    private static String nombre;

    private IABOT(){}
    protected IABOT(IABOT iabot){
        if(iabot != null){
            instance = iabot;
        }
    }
    public static IABOT getInstance(String nombre){
        if(instance == null){
            instance = new IABOT();
            instance.setNombre(nombre);
        }
        return instance;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
