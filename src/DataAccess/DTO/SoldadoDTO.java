package DataAccess.DTO;

public class SoldadoDTO {
    private Integer IdSoldado;
    private String NombreSoldado;

    public SoldadoDTO(){}

    public SoldadoDTO(int idSoldado,String nombre){
        IdSoldado=idSoldado;
        NombreSoldado=nombre;
    }

    public Integer getIdSoldado() {
        return IdSoldado;
    }
    public void setIdSoldado(Integer idSoldado) {
        IdSoldado = idSoldado;
    }
    public String getNombreSoldado() {
        return NombreSoldado;
    }
    public void setNombreSoldado(String nombreSoldado) {
        NombreSoldado = nombreSoldado;
    }



    public String toString(){
        return getClass().getName()
        + "\n IdSoldado:       "+ getIdSoldado()       
        + "\n Nombre:"+ getNombreSoldado();
    }

}
