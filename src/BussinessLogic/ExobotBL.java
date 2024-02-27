package BussinessLogic;
import java.util.List;
import DataAccess.DTO.ExobotDTO;
import DataAccess.ExobotDAO;

public class ExobotBL {
    private ExobotDTO exobotDTO;
    private ExobotDAO exobotDAO = new ExobotDAO();

    public ExobotBL(){}
    
    public List<ExobotDTO> getAll() throws Exception{
        return exobotDAO.readAll();
    }
    public ExobotDTO getByIdDato(int idExobot) throws Exception{
        exobotDTO = exobotDAO.readBy(idExobot);
        return exobotDTO;
    }
    public boolean create(ExobotDTO eDTO) throws Exception{   
        return exobotDAO.create(eDTO);
    }
    public boolean update(ExobotDTO eDTO) throws Exception{
        return exobotDAO.update(eDTO);
    }
    public boolean delete(int idExobot) throws Exception{
        return exobotDAO.delete(idExobot);
    }
    
}
