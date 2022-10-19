package DAO;

import Connection.ConnectionFactory;
import Models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TicketDao implements Dao<Ticket> {
    @Override
    public Ticket get(long id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public Long save(Ticket ticket) {
        try{
            Connection connection = ConnectionFactory.getConnection();
            String query = "insert into ticket(idFlight, idClient, fullname, email, passport) values (?, ?, ?, ?, ?)";

            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, ticket.getFlight().getId());
            statement.setLong(2, ticket.getClient().getId());
            statement.setString(3, ticket.getFullName());
            statement.setString(4, ticket.getEmail());
            statement.setString(5, ticket.getPassport());


            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.isBeforeFirst()){
                resultSet.next();
                return (long) resultSet.getInt("idTicket");
            }
            System.out.println("else");
            return -1L;
        }catch(Exception e){
            e.getStackTrace();
            return -1L;
        }
    }

    @Override
    public void update(Ticket ticket, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
