package BussinessLogic.Entities.Exoesqueleto;


public interface IArmaDerecha {

    public void activarArma(int tiempo);

    default void disparar(int tiempo) {
        for (int i = 0; i < tiempo; i++)
            System.out.print("+");
    }
}