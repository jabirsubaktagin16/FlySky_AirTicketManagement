package Connection;

public class FlightInfoFinal {

    private int id;
    private int id2;
    private String date;
    private String arrival;
    private String trangit;
    private String departure;
    private String airline;
    private String arrivalTime;
    private String departureTime;
    private int seat;
    private String economic;
    private String business;

    public FlightInfoFinal(int ID, int ID2, String Date, String Arrival, String Trangit, String Departure, String Airline, String ArrivalTime, String DepartureTime, int Seat, String Economic, String Business) {
        this.id = ID;
        this.id2 = ID2;
        this.date = Date;
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

    public int getID2() {
        return id2;
    }

    public String getDate() {
        return date;
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
