package Connection;
public class TicketJoinFlight {
    private int ticketid;
    private int customerid;
    private String name;
    private String Class;
    private int flightid;
    private String flightdate;
    private String startingpoint;
    private String destination;
    private String airline;
    private String departure;
    private String arrival;

    public TicketJoinFlight(int ticketID,int customerID,String Name,String claSS,int flightID,String flightDate,String StartingPoint,String Destination,String Airline,String Departure,String Arrival) {
        this.ticketid = ticketID;
        this.customerid = customerID;
        this.name = Name;
        this.Class = claSS;
        this.flightid = flightID;
        this.flightdate = flightDate;
        this.startingpoint=StartingPoint;
        this.destination=Destination;
        this.airline = Airline;
        this.departure = Departure;
        this.arrival = Arrival;
        
        
    }

    public int getTicketID() {
        return ticketid;
    }

    public int getCustomerID() {
        return customerid;
    }

    public String getName() {
        return name;
    }
    
    public String getFlightClass()
    {
        return Class;
    }
    
    public int getFlightID()
    {
        return flightid;
    }
    
    public String getFlightDate()
    {
        return flightdate;
    }
    
    public String getStartingPoint() {
        return startingpoint;
    }

    public String getDestination() {
        return destination;
    }

    public String getAirline() {
        return airline;
    }

    public String getDepartureTime() {
        return departure;
    }

    public String getArrivalTime() {
        return arrival;
    }
}
