//CODIGO DE JOSE PALLARES
package Exoesqueleto;

public class FuentePoder {
    private int nivelEnergia;

    public void FuenteDePoder(){
        this.nivelEnergia = 0;
    }
    public void recargar(int  energia){
        nivelEnergia  += energia;
        System.out.println("Se ha recargado la fuente de poder con " +energia+ "%");
        }
        
    }