package Models;

public class Flight {

    private final long id;
    private String flightDate;
    private String takeoff;
    private String landing;
    private int nbrPlace;
    private String departureCity;
    private String arrivalCity;
    private float price;

    public long getId() {
        return id;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Flight(long id, String flightDate, String takeoff, String landing, int nbrPlace, String departureCity, String arrivalCity, float price) {
        this.id = id;
        this.flightDate = flightDate;
        this.takeoff = takeoff;
        this.landing = landing;
        this.nbrPlace = nbrPlace;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.price = price;
    }
}
