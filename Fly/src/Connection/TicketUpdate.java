package Connection;
public class TicketUpdate {
    private int ticketid;
    private String name;
    private String Cla;
    private int flightid;
    private String bill;
    private String classrate;
    private String seat;
    private String total;
    
    public TicketUpdate(int TicketID,String Name,String cls,int FlightID,String Bill,String ClassRate,String Seat,String TotalBill)
    {
        this.ticketid=TicketID;
        this.name=Name;
        this.Cla=cls;
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
    public String getclas(){
        return Cla;
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
