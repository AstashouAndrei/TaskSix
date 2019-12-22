package by.gstu.airline.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gstu.airline.dao.FactoryDAO;
import by.gstu.airline.dao.StaffDAO;
import by.gstu.airline.entity.Staff;
import by.gstu.airline.exception.DAOException;
import org.apache.log4j.Logger;
import org.json.JSONObject;

@WebServlet("/StaffController")
public class StaffController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Logger logger = Logger.getLogger(StaffController.class.getName());

    public StaffController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FactoryDAO factoryDAO = FactoryDAO.getFactoryDAO();
        StaffDAO staffDAO = factoryDAO.getStaffDAO();
        JSONObject jsonStaff = new JSONObject();
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByID(Integer.parseInt(request.getParameter("id")));
            jsonStaff.put("id", staff.getId());
            jsonStaff.put("firstName", staff.getFirstName());
            jsonStaff.put("lastName", staff.getLastName());
            jsonStaff.put("profession", staff.getProfession().getProfession());
        } catch (DAOException e) {
            logger.error("Cannot get user by given ID from data base", e);
        }
        if (staff == null) {
            jsonStaff.put("id", Integer.parseInt(request.getParameter("id")));
            jsonStaff.put("firstName", "-");
            jsonStaff.put("lastName", "-");
            jsonStaff.put("profession", "-");
        }

        response.setContentType("application/json");
        response.getWriter().write(jsonStaff.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}