package DAO;

import Connection.ConnectionFactory;
import Models.Flight;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements Dao<Flight> {

    public List<Flight> getFlights(String departureCity, String arrivalCity, String flightDate) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select idFlight, takeOff, landing, nbrPlace, price from flight where departureCity like ? and arrivalCity like ? and flightDate = ?";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, departureCity);
            statement.setString(2, arrivalCity);
            statement.setDate(3, Date.valueOf(flightDate));

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return null;
            }
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("idFlight");
                int nbrPlace = resultSet.getInt("nbrPlace");
                String takeoff = String.valueOf(resultSet.getTime("takeoff"));
                String landing = String.valueOf(resultSet.getTime("landing"));
                float price = resultSet.getFloat("price");
                flights.add(new Flight(id, flightDate, takeoff, landing, nbrPlace, departureCity, arrivalCity, price));
            }
            return flights;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public Flight get(long id) {
        return null;
    }

    @Override
    public List<Flight> getAll() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select * from flight ";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {

                long id = resultSet.getLong("idFlight");
                int nbrPlace = resultSet.getInt("nbrPlace");
                String flightDate = String.valueOf(resultSet.getDate("flightDate"));
                String arrivalCity = resultSet.getString("arrivalCity");
                String landing = String.valueOf(resultSet.getTime("landing"));
                String departureCity = resultSet.getString("departureCity");
                String takeoff = String.valueOf(resultSet.getTime("takeoff"));
                float price = resultSet.getFloat("price");
                flights.add(new Flight(id, flightDate, takeoff, landing, nbrPlace, departureCity, arrivalCity, price));
            }
            return flights;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public Long save(Flight flight) {
        try {
            Connection connection = ConnectionFactory.getConnection();

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement("insert into flight(flightDate, takeOff, landing, nbrPlace, departureCity, arrivalCity, price) values (?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            System.out.println(Time.valueOf(flight.getTakeoff() + ":00"));
            statement.setDate(1, Date.valueOf(flight.getFlightDate()));
            statement.setTime(2, Time.valueOf(flight.getTakeoff() + ":00"));
            statement.setTime(3, Time.valueOf(flight.getLanding() + ":00"));
            statement.setInt(4, flight.getNbrPlace());
            statement.setString(5, flight.getDepartureCity());
            statement.setString(6, flight.getArrivalCity());
            statement.setFloat(7, flight.getPrice());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();


            if (resultSet.next()) {
                flight.setId(resultSet.getLong(1));
            }
            statement.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flight.getId();
    }

    @Override
    public void update(Flight flight, String[] params) {

    }

    @Override
    public void delete(long id) {
        try{
            System.out.println("hello"+id);
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("hello1");
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement("DELETE FROM flight WHERE idFlight=? ");
            System.out.println("hello2");

            statement.setLong(1,id);
            System.out.println("hello3");
            statement.executeUpdate();
            System.out.println("hello4");
        }
        catch (Exception e){
            e.getMessage();
        }


    }
}
