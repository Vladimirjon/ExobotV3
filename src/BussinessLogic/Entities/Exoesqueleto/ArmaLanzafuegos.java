package BussinessLogic.Entities.Exoesqueleto;


public class ArmaLanzafuegos implements IArmaDerecha {
    private String nombre;

    // Constructor que acepta un parámetro String (nombre)
    public ArmaLanzafuegos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void activarArma(int tiempo) {
        // Implementación del método activarArma para ArmaLanzafuegos
        for (int i = 0; i < tiempo; i++) {
            System.out.print("+");
        }
    }
}