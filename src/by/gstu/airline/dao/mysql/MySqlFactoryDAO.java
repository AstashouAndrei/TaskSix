package by.gstu.airline.dao.mysql;

import by.gstu.airline.dao.*;

/**
 * DAO generator description
 */
public class MySqlFactoryDAO extends FactoryDAO {

    @Override
    public PlaneDAO getPlaneDAO() {
        return new MySqlPlaneDAO();
    }

    @Override
    public CrewDAO getCrewTeamDAO() {
        return new MySqlCrewDAO();
    }

    @Override
    public StaffDAO getStaffDAO() {
        return new MySqlStaffDAO();
    }

    @Override
    public ItineraryDAO getItineraryDAO() {
        return new MySqlItineraryDAO();
    }

    @Override
    public FlightDAO getFlightDAO() {
        return new MySqlFlightDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }
}
