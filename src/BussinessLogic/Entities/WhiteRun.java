package BussinessLogic.Entities;
import java.util.ArrayList;

import BussinessLogic.Entities.EjercitoRuso.ExpertoEspanol;
import BussinessLogic.Entities.EjercitoRuso.ExpertoIngles;
import BussinessLogic.Entities.EjercitoRuso.Mecatronico;
import BussinessLogic.Entities.EjercitoRuso.Soldado;
import BussinessLogic.Entities.Exoesqueleto.Exobot;
import BussinessLogic.Entities.InteligenciaArtificial.IABOT;

public class WhiteRun {
    public static void main(String[] args) throws Exception {
        String redColorCode = "\u001B[35m";
        String resetColorCode = "\u001B[0m";
        Soldado osoldado = new Soldado("Juan");
        IABOT iabot = IABOT.getInstance("IA-RUSA");
        ExpertoEspanol profeEspanol = new ExpertoEspanol();
        ExpertoIngles profeIngles = new ExpertoIngles();
        Mecatronico oMecatronico = new Mecatronico();
        osoldado.agregarNombres();
        ArrayList<String> TJnombreHumano = osoldado.getArrayList();
        for(int i=0;i<20;i++){
            System.out.println(redColorCode + " - - - EXOBOT "+(i+1)+" - - - " + resetColorCode);
            System.out.println("Soldado asignado: " + TJnombreHumano.get(i));
            System.out.println("Numero de Serie: " + oMecatronico.generarNumeroSerie()  );
            Exobot exobot = new Exobot(iabot,profeEspanol,profeIngles);
            System.out.println();
        }

        
    }
}


