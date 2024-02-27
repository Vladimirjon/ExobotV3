package EjercitoRuso;
public class Soldado extends Humano implements IHumanoExtremidad{
    private Boolean habilidadBrazoIzquierdo;
    private Boolean habilidadBrazoDerecho;

    public Soldado(String nombre){
        //
        super(nombre);

        if(Soldado.brazoDerecho)
            setHabilidadBrazoDerecho(getHabilidadRandom());
        System.out.println("Brazo Derecho :"+ getHabilidadBrazoDerecho());

        if(Soldado.brazoIzquierdo)
            setHabilidadBrazoIzquierdo(getHabilidadRandom());
        System.out.println("Brazo Izquierdo :"+ getHabilidadBrazoIzquierdo());

        if(Soldado.piernaDerecha)
            System.out.println("Pierna Derecha");

        if(Soldado.piernaIzquierda)
            System.out.println("Pierna Izquierda");

        if(Soldado.cabeza)
            System.out.println("Cabeza");

        if(Soldado.tronco)
            System.out.println("Tronco");

        
    }
    boolean getHabilidadRandom(){
        int bias = 50;
        return (Math.random()*100<bias);
    }

    public Boolean getHabilidadBrazoIzquierdo(){
        return habilidadBrazoIzquierdo;
    }

    public void setHabilidadBrazoIzquierdo(Boolean habilidadBrazoIzquierdo) {
        this.habilidadBrazoIzquierdo = habilidadBrazoIzquierdo;
    }

    public Boolean getHabilidadBrazoDerecho() {
        return habilidadBrazoDerecho;
    }

    public void setHabilidadBrazoDerecho(Boolean habilidadBrazoDerecho) {
        this.habilidadBrazoDerecho = habilidadBrazoDerecho;
    }

}
