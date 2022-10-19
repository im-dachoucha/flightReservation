package com.example.flightreservation.Client;

import DAO.FlightDao;
import DAO.TicketDao;
import Models.Client;
import Models.Flight;
import Models.Ticket;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookFlightServlet", value = "/book-flight")
public class BookFlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long idFlight = Long.parseLong(request.getParameter("idFlight"));
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String passport = request.getParameter("passport");

            HttpSession session = request.getSession();
            TicketDao ticketDao = new TicketDao();
            FlightDao flightDao = new FlightDao();

            Client client = (Client) session.getAttribute("client");
            Flight flight = flightDao.get(idFlight);
            Ticket ticket = new Ticket(fullname, email, passport, flight, client);

            long idTicket = ticketDao.save(ticket);

            request.getRequestDispatcher("");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
