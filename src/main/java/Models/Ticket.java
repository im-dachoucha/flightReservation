package Models;

public class Ticket {

    private long id;
    private String fullName;
    private String email;
    private String passport;
    private Flight flight;
    private Client client;

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ticket(long id, String fullName, String email, String passport, Flight flight, Client client) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passport = passport;
        this.flight = flight;
        this.client = client;
    }
    public Ticket(String fullName, String email, String passport, Flight flight, Client client) {
        this.fullName = fullName;
        this.email = email;
        this.passport = passport;
        this.flight = flight;
        this.client = client;
    }
}
