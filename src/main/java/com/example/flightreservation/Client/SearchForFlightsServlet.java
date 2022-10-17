package com.example.flightreservation.Client;

import DAO.FlightDao;
import Models.Flight;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchForFlightsServlet", value = "/search-for-flights")
public class SearchForFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departureCity = request.getParameter("departure-city");
        String arrivalCity = request.getParameter("arrival-city");
        String flightDate = request.getParameter("flight-date");
        System.out.println(departureCity);
        System.out.println(arrivalCity);
        System.out.println(flightDate);
        FlightDao flightDao = new FlightDao();
        List<Flight> flights = flightDao.getFlights(departureCity, arrivalCity, flightDate);
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("Client/DisplayFlights.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
