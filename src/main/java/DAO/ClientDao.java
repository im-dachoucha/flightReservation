package DAO;

import Connection.ConnectionFactory;
import Models.Client;
import Security.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ClientDao implements Dao<Client> {

    public Client getClientForAuth(String email, String password) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select idClient, fullname, phone, email, password from client where email like ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                if (!BCrypt.checkpw(password, resultSet.getString("password")))
                    return null;

                long id = resultSet.getLong("idClient");
                String fullName = resultSet.getString("fullname");
                String phone = resultSet.getString("phone");
                return new Client(id, fullName, phone, email);
            }
            return null;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public Client get(long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Long save(Client client) {
        return null;
    }

    @Override
    public void update(Client client, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
