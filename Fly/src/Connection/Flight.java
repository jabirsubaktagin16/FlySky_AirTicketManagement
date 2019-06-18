package Connection;

public class Flight {

    private int id;
    private String arrival;
    private String trangit;
    private String departure;
    private String airline;
    private String arrivalTime;
    private String departureTime;
    private int seat;
    private String economic;
    private String business;

    public Flight(int ID, String Arrival, String Trangit, String Departure, String Airline, String ArrivalTime, String DepartureTime, int Seat, String Economic, String Business) {
        this.id = ID;
        this.arrival = Arrival;
        this.trangit = Trangit;
        this.departure = Departure;
        this.airline = Airline;
        this.arrivalTime = ArrivalTime;
        this.departureTime = DepartureTime;
        this.seat = Seat;
        this.economic = Economic;
        this.business = Business;
    }

    public int getID() {
        return id;
    }

    public String getArrival() {
        return arrival;
    }

    public String getTrangit() {
        return trangit;
    }

    public String getDeparture() {
        return departure;
    }

    public String getAirline() {
        return airline;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getSeat() {
        return seat;
    }

    public String getEconomic() {
        return economic;
    }

    public String getBusiness() {
        return business;
    }
}
