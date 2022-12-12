import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import static java.lang.Math.ceil;
/*
* DateLog stores a vehicle's arrival and departure times and performs some calculations on them
* */
public class DateLog
{
    //two variables that store the times of arrival and departure in milliseconds
    private long arrival;
    private long departure;

    //default constructor that does nothing
    public DateLog(){}
    //constructor that takes initializes both variables
    public DateLog(long arrival, long departure)
    {
        this.arrival = arrival;
        this.departure = departure;
    }
    //copy contructor
    public DateLog(DateLog other)
    {
        this(other.arrival, other.departure);
    }
    //standard setters and getters for the class
    public void setArrival()
    {
        this.arrival = Calendar.getInstance().getTimeInMillis();
    }

    public void setDeparture()
    {
        this.departure = Calendar.getInstance().getTimeInMillis();
    }

    public long getArrival()
    {
        return arrival;
    }

    public long getDeparture()
    {
        return departure;
    }

    //A function that returns the number of hours spent (including ceil operation so
    //if a driver spends 1.5 hours for example, they are charged for 2 hours

    public int getTimeDifference()
    {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.departure - this.arrival);
        double inHrs = (double)seconds/3600;
        return (int)ceil(inHrs);
    }
}
