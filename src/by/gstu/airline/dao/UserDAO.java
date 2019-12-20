package by.gstu.airline.dao;

import by.gstu.airline.entity.services.Access;
import by.gstu.airline.entity.services.User;
import by.gstu.airline.exception.DAOException;

import java.util.List;

/**
 * UserDAO methods description
 */
public interface UserDAO {

    User getUserById(int id) throws DAOException;

    User getUserByLogin(String login) throws DAOException;

    List<User> getUsers(Access access) throws DAOException;

    void addUser(User user) throws DAOException;

    void removeUserById(int id) throws DAOException;

}
