package BusinessLogic;

import java.util.List;

import DataAccess.SoldadoDAO;
import DataAccess.DTO.SoldadoDTO;

public class SoldadoBL {
    private SoldadoDTO soldado;
    private SoldadoDAO sDAO = new SoldadoDAO();

    public SoldadoBL(){}

    public List<SoldadoDTO> getAll() throws Exception{
        return sDAO.readAll();
    }
    public SoldadoDTO getByIdSoldado(int idSoldado) throws Exception{
        soldado = sDAO.readBy(idSoldado);
        return soldado;
    }
    public boolean create(SoldadoDTO soldadoDTO) throws Exception{   
        return sDAO.create(soldadoDTO);
    }
    public boolean update(SoldadoDTO soldadoDTO) throws Exception{
        return sDAO.update(soldadoDTO);
    }
    public boolean delete(int idSoldado) throws Exception{
        return sDAO.delete(idSoldado);
    }

}
