package DataAccess;  
  
  
  
public class SoldadoDTO {  
    private Integer idSoldado;  
    private String nombre;  
  
    public SoldadoDTO() {}  
  
    public SoldadoDTO(Integer Id, String nombre) {  
        this.idSoldado = Id;  
        this.nombre = nombre;  
    }  
  
    public Integer getIdSoldado() {  
        return idSoldado;  
    }  
  
    public void setIdSoldado(Integer idSoldado) {  
        this.idSoldado = idSoldado;  
    }  
  
    public String getNombre() {  
        return nombre;  
    }  
  
    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  
}
