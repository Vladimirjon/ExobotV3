package BussinessLogic;
import java.util.List;
import DataAccess.DTO.SoldadoDTO;
import DataAccess.SoldadoDAO;

public class SoldadoBL {
    private SoldadoDTO soldado;
    private SoldadoDAO soldadoDAO = new SoldadoDAO();

    public SoldadoBL(){}
    
    public List<SoldadoDTO> getAll() throws Exception{
        return soldadoDAO.readAll();
    }
    public SoldadoDTO getByIdDato(int idExobot) throws Exception{
        soldado = soldadoDAO.readBy(idExobot);
        return soldado;
    }
    public boolean create(SoldadoDTO sDTO) throws Exception{   
        return soldadoDAO.create(sDTO);
    }
    public boolean update(SoldadoDTO sDTO) throws Exception{
        return soldadoDAO.update(sDTO);
    }
    public boolean delete(int idExobot) throws Exception{
        return soldadoDAO.delete(idExobot);
    }
    
}

