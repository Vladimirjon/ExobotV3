package Exoesqueleto;

public class BrazoDerecho implements IArmaDerecha {
    private IArmaDerecha arma;

    public void equiparArma(IArmaDerecha nuevaArma) {
        this.arma = nuevaArma;
    }

    @Override
    public void activarArma(int tiempo) {
        if (arma != null) {
            StringBuilder disparo = new StringBuilder("Disparando: ");
            for (int i = 0; i < tiempo; i++) {
                disparo.append("+");
            }
            System.out.println(disparo.toString());
        } else {
            System.out.println("No se ha equipado un arma en el brazo derecho.");
        }
    }
}