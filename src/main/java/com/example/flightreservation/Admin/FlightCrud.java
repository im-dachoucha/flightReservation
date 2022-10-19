package com.example.flightreservation.Admin;

import DAO.FlightDao;
import DAO.SendingEmail;
import Models.Flight;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

//@WebServlet(name = "FlightCrud", value = "/FlightCrud")
public class FlightCrud extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path =request.getServletPath();
        System.out.println(path);
         if(path.equals("/Admin/index.php")){
             FlightDao flightDao = new FlightDao();
             List<Flight> flights = flightDao.getAll();
             request.setAttribute("flights", flights);
             System.out.println("test test");
             request.getRequestDispatcher("../DisplayFlights.jsp").forward(request, response);

         }
         else if (path.equals("/Admin/Delete.php")){
             long idFlight = Long.parseLong(request.getParameter("IdFlight")) ;
             FlightDao flightDao = new FlightDao();
             flightDao.delete(idFlight);
             List<Flight> flights = flightDao.getAll();
             request.setAttribute("flights", flights);
             request.getRequestDispatcher("../DisplayFlights.jsp").forward(request, response);
         }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path =request.getServletPath();
        System.out.println(path);
         if (path.equals("/Admin/addFlight.php")){
          String flightDate = request.getParameter("flightDate");
          String takeOff = request.getParameter("takeOff");
          String landing = request.getParameter("landing");
          String nbrPlace = request.getParameter("nbrPlace");
          String departureCity=request.getParameter("departureCity");
          String arrivalCity=request.getParameter("arrivalCity");
          String price = request.getParameter("price");
          FlightDao flightDao = new FlightDao();
          flightDao.save(new Flight(flightDate,takeOff,landing,Integer.parseInt(nbrPlace),departureCity,arrivalCity, Float.parseFloat(price) ));
          List<Flight> flights = flightDao.getAll();
          request.setAttribute("flights", flights);
          request.getRequestDispatcher("../DisplayFlights.jsp").forward(request, response);
         }

    }
}
