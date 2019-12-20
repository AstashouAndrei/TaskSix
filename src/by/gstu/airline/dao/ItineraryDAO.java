package by.gstu.airline.dao;

import by.gstu.airline.entity.Itinerary;
import by.gstu.airline.exception.DAOException;

/**
 * ItineraryDAO methods description
 */
public interface ItineraryDAO {

    void addItinerary(Itinerary itinerary) throws DAOException;

    Itinerary getItineraryByID(int ID) throws DAOException;

    void changeItineraryFlightCode(Itinerary itinerary, String flightCode) throws DAOException;

    void removeItineraryByID(int ID) throws DAOException;
}
