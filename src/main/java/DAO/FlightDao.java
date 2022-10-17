package DAO;

import Connection.ConnectionFactory;
import Models.Flight;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                Long id = resultSet.getLong("idFlight");
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
        return null;
    }

    @Override
    public Long save(Flight flight) {
        return null;
    }

    @Override
    public void update(Flight flight, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
