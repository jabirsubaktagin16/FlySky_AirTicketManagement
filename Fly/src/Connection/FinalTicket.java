package Connection;
public class FinalTicket {
    private int ticketid;
    private String name;
    private int flightid;
    private String bill;
    private String classrate;
    private String seat;
    private String total;
    
    public FinalTicket(int TicketID,String Name,int FlightID,String Bill,String ClassRate,String Seat,String TotalBill)
    {
        this.ticketid=TicketID;
        this.name=Name;
        this.flightid=FlightID;
        this.bill=Bill;
        this.classrate=ClassRate;
        this.seat=Seat;
        this.total=TotalBill;
    }
    public int getTicket()
    {
        return ticketid;
    }
    public String getName()
    {
        return name;
    }
    public int getFlight()
    {
        return flightid;
    }
    public String getBill()
    {
        return bill;
    }
    public String getClassRate()
    {
        return classrate;
    }
    public String getSeat()
    {
        return seat;
    }
    public String getTotal()
    {
        return total;
    }
}
