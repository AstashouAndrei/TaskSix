package by.gstu.airline;

import by.gstu.airline.dao.*;
import by.gstu.airline.dao.mysql.MySqlStaffDAO;
import by.gstu.airline.entity.*;
import by.gstu.airline.entity.services.*;
import by.gstu.airline.exception.DAOException;

import java.util.Vector;

/**
 * Class for running application
 */
public class Runner {

    public static void main(String[] args) {

//        // Creating DAO's
//        FactoryDAO factoryDAO = FactoryDAO.getFactoryDAO();
//        StaffDAO staffDAO = factoryDAO.getStaffDAO();
//        ItineraryDAO itineraryDAO = factoryDAO.getItineraryDAO();
//        PlaneDAO planeDAO = factoryDAO.getPlaneDAO();
//        CrewDAO crewDAO = factoryDAO.getCrewTeamDAO();
//        FlightDAO flightDAO = factoryDAO.getFlightDAO();
//        UserDAO userDAO = factoryDAO.getUserDAO();
//
//        // Get users from data base by id
//        User userDispatcher = userDAO.getUserById(2);
//        User userAdministrator = userDAO.getUserById(1);
//
//        // Creating dispatcher and administrator services
//        DispatcherService dService = new DispatcherService(staffDAO, crewDAO, planeDAO);
//        AdministratorService aService = new AdministratorService(staffDAO, crewDAO);
//
//        // Creating dispatcher and administrator, using users from data base and services
//        Dispatcher dispatcher = new Dispatcher(userDispatcher, dService);
//        Administrator administrator = new Administrator(userAdministrator, aService);
//
//        // Getting two existing flights from data base
//        Flight fromMoscowToBeijing = flightDAO.getIFlightByID(7);
//        Flight fromKazanToMoscow = flightDAO.getIFlightByID(4);
//
//        // Creating new flight with new Itinerary and plane getting from data base
//        Itinerary fromDubaiToMoscow = new Itinerary("SU0521", "Dubai", "Moscow");
//        itineraryDAO.addItinerary(fromDubaiToMoscow);
//        Plane a330_300 = planeDAO.getPlaneByID(1);
//        Flight flightFromDubaiToMoscow = new Flight(fromDubaiToMoscow, a330_300);
//        flightDAO.addFlight(flightFromDubaiToMoscow);
//
//        // Dispatcher build crews for all three flight with random staff.
//        // Each staff from each crew adds to crew table in data base, also each stuff
//        // changes current state in staff table into "Scheduled",
//        // which makes them unavailable to getting on others flights
//        dispatcher.buildCrewWithRandomStaff(fromMoscowToBeijing);
//        dispatcher.buildCrewWithRandomStaff(fromKazanToMoscow);
//        dispatcher.buildCrewWithRandomStaff(flightFromDubaiToMoscow);
//
//        // Administrator starts flight from Moscow to Beijing. All staff from this flight
//        // crew changes current state in staff table to "On flight"
//        administrator.startFlight(fromMoscowToBeijing);
//
//        // Administrator delays flight from Kazan to Moscow. All staff from this flight
//        // crew keeps current state as "Scheduled" and waits for starting or canceling flight.
//        administrator.delayFlight(fromKazanToMoscow);
//
//        // Administrator starts flight from Dubai to Moscow. All staff from this flight
//        // crew changes current state in staff table to "On flight"
//        administrator.startFlight(flightFromDubaiToMoscow);
//
//        // Administrator finishes flight from Moscow to Beijing. All staff from this flight
//        // crew changes current state in staff table to "Standby" which makes them
//        // available to get to other flights. Also crew from this flight removes from
//        // crew table in data base
//        administrator.finishFlight(fromMoscowToBeijing);
    }
}
