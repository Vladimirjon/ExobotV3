package BussinessLogic.Entities.EjercitoRuso;

import java.util.ArrayList;
import java.util.Random;

public abstract class Humano implements IHumanoExtremidad{
    // this.pjequiparlaser = random.nextBoolean();
    //     this.pjequiparmetralleta = random.nextBoolean();
    Boolean tjbrazoIzquierdo = brazoIzquierdo;
    Boolean tjbrazoDerecho = brazoDerecho;
    Boolean tjpiernaIzquierda = piernaIzquierda;
    Boolean tjpiernaDerecha = piernaDerecha;
    Boolean tjcabeza = cabeza;
    Boolean tjtronco = tronco;
    
    private ArrayList<String> TJnombreHumano;

    public Humano(String tjnombre) {
        
       TJnombreHumano = new ArrayList<>();
       
        Random random = new Random();

        this.tjcabeza = true;
        this.tjtronco = true;
        this.tjbrazoIzquierdo = random.nextBoolean();
        this.tjbrazoDerecho = random.nextBoolean();
        this.tjpiernaIzquierda = random.nextBoolean();
        this.tjpiernaDerecha = random.nextBoolean();
    }

    public Humano(){

    }

    
    public void agregarNombres() {
        for (int i = 1; i <= 20; i++) {
            TJnombreHumano.add("Wladimir " + i);
        }
    }

    public ArrayList<String> getArrayList(){
        return this.TJnombreHumano;
    }
}
