package EjercitoRuso;

import java.util.Random;

import InteligenciaArtificial.IABOT;

public class Mecatronico extends Humano{
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LONGITUD = 5;

    public static String generarNumeroSerie() {
        StringBuilder numeroSerie = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LONGITUD; i++) {
            int indiceAleatorio = random.nextInt(CARACTERES.length());
            numeroSerie.append(CARACTERES.charAt(indiceAleatorio));
        }
        return numeroSerie.toString();
    }

    
}
