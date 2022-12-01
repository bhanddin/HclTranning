package com.dinesh.servlet;



import com.dinesh.model.*;
import com.dinesh.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDemo UserDemo;

    public void init() {
        UserDemo = new UserDemo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getRequestURI();
System.out.println(action);
        try {
            switch (action) {
                case "/EmployeeManagement/new":
                    showNewForm(request, response);
                    break;
                case "/EmployeeManagement/insert":
                    insertUser(request, response);
                    break;
                case "/EmployeeManagement/delete":
                    deleteUser(request, response);
                    break;
                case "/EmployeeManagement/edit":
                    showEditForm(request, response);
                    break;
                case "/EmployeeManagement/update":
                    updateUser(request, response);
                    break;
                case "/EmployeeManagement/validate":
                    validateusers(request, response);
                    break;
              
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <User> listUser = UserDemo.getAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayuser.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("adduser.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = UserDemo.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adduser.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User newUser = new User(name, email, country, phone,password);
        UserDemo.saveUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = new User(id, name, email, country,phone,password);
        UserDemo.updateUser(user);
        response.sendRedirect("list");
    }
    
    private void validateusers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Login user = new Login(name,password);
        UserDemo.validateusers(user);
        response.sendRedirect("list");
    }
    
    
    

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDemo.deleteUser(id);
        response.sendRedirect("list");
    }
    

}