package BussinessLogic.Entities.Exoesqueleto;


public class TurboReactor {
    private String TurboReactor;
    private boolean vuelo;
    private int carga;

    public TurboReactor(){
        this.carga = 0;
        this.vuelo = false;
    }
    public void cargarCombustible(int cantidad){
        carga+= cantidad;
        System.out.println("Se ha cargado "+cantidad+"%");
    }
    public void activarVuelo(){
        if(carga>0){
            System.out.println("El exoesqueleto puede volar");
        }else{
            System.out.println("El exobot no puede volar. Necesita carga");
        }
    }
}
