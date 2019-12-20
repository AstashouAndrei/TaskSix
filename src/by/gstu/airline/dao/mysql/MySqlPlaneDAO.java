package by.gstu.airline.dao.mysql;

import by.gstu.airline.dao.PlaneDAO;
import by.gstu.airline.entity.Plane;
import by.gstu.airline.exception.DAOException;
import by.gstu.airline.sql.SqlCommands;
import by.gstu.airline.sql.SqlConnection;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * DAO class with Plane CRUD methods
 */

public class MySqlPlaneDAO implements PlaneDAO {

    private static Logger logger = Logger.getLogger(MySqlPlaneDAO.class.getName());

    /**
     * Adds given planes to data base
     *
     * @param plane plane
     * @throws DAOException DAOException
     */
    @Override
    public void addPlane(Plane plane) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            logger.trace("Open connection");
            connection = SqlConnection.createConnection();
            logger.trace("Create prepared statement");
            statement = connection.prepareStatement(SqlCommands.getCommand("ADD_PLANE"),
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, plane.getPlaneType());
            statement.setInt(2, plane.getPassengerCapacity());
            statement.setInt(3, plane.getFlightRange());
            statement.setInt(4, plane.getFuelConsumption());
            statement.executeUpdate();
            logger.trace("Create result set");
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            plane.setID(resultSet.getInt(1));
        } catch (SQLException e) {
            logger.error("Cannot add plane to data base", e);
            throw new DAOException("Cannot add plane to data base", e);
        } finally {
            SqlConnection.close(resultSet);
            SqlConnection.close(statement);
            SqlConnection.close(connection);
        }
    }

    /**
     * Returns plane from data base by given id
     *
     * @param id plane id
     * @return plane
     * @throws DAOException DAOException
     */
    @Override
    public Plane getPlaneByID(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Plane plane;
        try {
            logger.trace("Open connection");
            connection = SqlConnection.createConnection();
            logger.trace("Create prepared statement");
//            statement = connection.prepareStatement(GET_PLANE_BY_ID);
            statement = connection.prepareStatement(SqlCommands.getCommand("GET_PLANE_BY_ID"));
            statement.setInt(1, id);
            logger.trace("Create result set");
            resultSet = statement.executeQuery();
            resultSet.next();
            String type = resultSet.getString("Model");
            int capacity = resultSet.getInt("PassengerCapacity");
            int range = resultSet.getInt("FlightRange");
            int fuel = resultSet.getInt("FuelConsumption");
            plane = new Plane(type, capacity, range, fuel);
            plane.setID(id);
        } catch (SQLException e) {
            logger.error("Cannot get plane from data base by given id", e);
            throw new DAOException("Cannot get plane from data base by given id", e);
        } finally {
            SqlConnection.close(resultSet);
            SqlConnection.close(statement);
            SqlConnection.close(connection);
        }
        return plane;
    }

    /**
     * Changes planes planes passenger capacity into given one
     *
     * @param plane             plane
     * @param passengerCapacity plane passenger capacity
     * @throws DAOException DAOException
     */
    @Override
    public void changePassengersCapacity(Plane plane, int passengerCapacity) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            logger.trace("Open connection");
            connection = SqlConnection.createConnection();
            logger.trace("Create prepared statement");
            statement = connection.prepareStatement(SqlCommands.getCommand("CHANGE_PLANE_CAPACITY"));
            statement.setInt(1, passengerCapacity);
            statement.setInt(2, plane.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Cannot change given plane passenger capacity", e);
            throw new DAOException("Cannot change given plane passenger capacity", e);
        } finally {
            SqlConnection.close(statement);
            SqlConnection.close(connection);
        }
    }

    /**
     * Remove plane from data base by given id
     *
     * @param id plane id
     * @throws DAOException DAOException
     */
    @Override
    public void removePlaneByID(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            logger.trace("Open connection");
            connection = SqlConnection.createConnection();
            logger.trace("Create prepared statement");
            statement = connection.prepareStatement(SqlCommands.getCommand("REMOVE_PLANE_BY_ID"));
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Cannot remove plane from data base by given id", e);
            throw new DAOException("Cannot remove plane from data base by given id", e);
        } finally {
            SqlConnection.close(statement);
            SqlConnection.close(connection);
        }
    }
}
