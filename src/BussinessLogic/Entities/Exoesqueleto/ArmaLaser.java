package BussinessLogic.Entities.Exoesqueleto;


public class ArmaLaser implements IArmaDerecha {
    private int tiempo;

    // Constructor que acepta un parámetro int (tiempo)
    public ArmaLaser(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void activarArma(int tiempo) {
        // Implementación del método activarArma en la clase ArmaLaser
        for (int i = 0; i < tiempo; i++) {
            System.out.print("+");
        }
    }
}
