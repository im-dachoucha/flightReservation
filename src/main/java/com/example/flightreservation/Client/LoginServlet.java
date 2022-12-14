package com.example.flightreservation.Client;

import DAO.ClientDao;
import Models.Client;
import Security.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/client-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Client/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            ClientDao clientDao = new ClientDao();
            Client client = clientDao.getClientForAuth(email, password);
            if (client == null) {
                request.getRequestDispatcher("Client/Login.jsp").forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("client", client);
            response.sendRedirect("Client/Home.jsp");
//            request.getRequestDispatcher("Client/Home.jsp").forward(request, response);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
