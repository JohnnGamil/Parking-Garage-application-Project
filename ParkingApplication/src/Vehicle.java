/*Vehicle represents an abstraction of Vehicles in the src.Garage
*/
public class Vehicle
{
    //A unique identifier for every Vehicle
    private int id;
    //Model Name and Year of a Vehicle
    private String modelName;
    private int modelYear;
    //Width and Depth of every Vehicle
    private Dimensions vehicleDim;
    //A vehicle's Log (Arrival and Departure Times)
    private DateLog timeStamps;

    //A parameterized constructor initializing member variables
    public Vehicle(int id, String modelName, int modelYear, Dimensions vehicleDim)
    {
        this.id = id;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.vehicleDim = new Dimensions(vehicleDim);
        this.timeStamps = new DateLog();
    }
    //A copy constructor
    public Vehicle(Vehicle other)
    {
        this(other.id, other.modelName, other.modelYear, other.vehicleDim);
    }
    //getters for member Variables
    public int getId()
    {
        return id;
    }

    public String getModelName()
    {
        return modelName;
    }

    public int getModelYear()
    {
        return modelYear;
    }

    public Dimensions getDimensions()
    {
        return vehicleDim;
    }

    public DateLog getTimeStamps()
    {
        return timeStamps;
    }
    //Overriding the toString function to customize the printed content of the class
    @Override
    public String toString()
    {
        return "\nID: "+id+"\nModel Name: "+modelName+"\nModel Year: "+modelYear+"\n";
    }
}
