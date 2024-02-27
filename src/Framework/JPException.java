package Framework;

public class JPException extends Exception {

    public JPException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN IABot para el LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "NO sea sapo..";
    }    
}
