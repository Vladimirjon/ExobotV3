package BusinessLogic;

import java.util.List;

import DataAccess.ExobotDAO;
import DataAccess.DTO.ExobotDTO;

public class ExobotBL {
     private ExobotDTO exobot;
    private ExobotDAO sDAO = new ExobotDAO();

    public ExobotBL(){}

    public List<ExobotDTO> getAll() throws Exception{
        return sDAO.readAll();
    }
    public ExobotDTO getByIdExobot(int idExobot) throws Exception{
        exobot = sDAO.readBy(idExobot);
        return exobot;
    }
    public boolean create(ExobotDTO exobotDTO) throws Exception{   
        return sDAO.create(exobotDTO);
    }
    public boolean update(ExobotDTO exobotDTO) throws Exception{
        return sDAO.update(exobotDTO);
    }
    public boolean delete(int idExobot) throws Exception{
        return sDAO.delete(idExobot);
    }
}
