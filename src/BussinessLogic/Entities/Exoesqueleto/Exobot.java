package BussinessLogic.Entities.Exoesqueleto;


import java.util.Random;

import BussinessLogic.Entities.EjercitoRuso.ExpertoEspanol;
import BussinessLogic.Entities.EjercitoRuso.ExpertoIngles;
import BussinessLogic.Entities.EjercitoRuso.IHumanoExtremidad;
import BussinessLogic.Entities.InteligenciaArtificial.IABOT;

public class Exobot extends IABOT implements IHumanoExtremidad,ITecnicoEspanol,ITecnicoIngles {
    private ExpertoEspanol expertoEspanol;
    private FuentePoder efuentePoder;
    private TurboReactor eturboReactor;
    private BrazoDerecho ebrazoDerecho;
    private BrazoIzquierdo ebrazoIzquierdo;
    private Pierna epiernaDerecha;
    private Pierna epiernaIzqquierda;
    private ExpertoEspanol profeEspanol;
    private ExpertoIngles profeIngles;

    public Exobot(IABOT iabot, ExpertoEspanol profEspanol, ExpertoIngles profIngles) {
        super(iabot);
        eturboReactor = new TurboReactor();
        ebrazoDerecho = new BrazoDerecho();
        ebrazoIzquierdo = new BrazoIzquierdo();
        epiernaDerecha = new Pierna();
        epiernaIzqquierda = new Pierna();

        this.profeEspanol = profEspanol;
        this.profeIngles = profIngles;
        
        System.out.println("Experto Espanol: " );
        profeEspanol.traducirEspanolTecnico();
        System.out.println("Experto Ingles: " );
        profeIngles.traducirInglesTecnico();

        if (Exobot.brazoIzquierdo) {
            ebrazoIzquierdo = new BrazoIzquierdo();
            boolean habilidadBrazoIzquierdo = new Random().nextBoolean();
            System.out.println("Equipando arma en el Brazo Izquierdo...");
            if (habilidadBrazoIzquierdo)
                ebrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61 equipada "));
            else
                ebrazoIzquierdo.setArma(new ArmaBazuca("Bazuca antitanque equipada "));

        }

        if (Exobot.brazoDerecho) {
            ebrazoDerecho = new BrazoDerecho();
            boolean habilidadBrazoDerecho = new Random().nextBoolean();
            System.out.println("Equipando arma en el Brazo Derecho...");
        
            if (habilidadBrazoDerecho) {
                ebrazoDerecho.equiparArma(new ArmaLaser(10));
                System.out.println("Arma láser equipada ");
            } else {
                ebrazoDerecho.equiparArma(new ArmaLanzafuegos("Lanzallamas"));
                System.out.println("Lanzallamas equipado ");
            }
        
            ebrazoDerecho.activarArma(5);
        }
        
        if (Exobot.brazoDerecho)
        System.out.println("Tengo Brazo Derecho");

        if (Exobot.brazoIzquierdo)
        System.out.println("Tengo Brazo Izquierda");

        if (Exobot.piernaDerecha)
            System.out.println("Tengo Pierna Derecha");

        if (Exobot.piernaIzquierda)
            System.out.println("Tengo Pierna Izquierda");

        if (Exobot.tronco)
            System.out.println("Tengo Tronco");
        
        if(Exobot.cabeza)
            System.out.println("Tengo Cabeza");



    }
    
    

}
