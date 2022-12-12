/*
* Parking Space represents an abstraction of a real-life parking space in the garage
*/
public class ParkingSpace
{
    //A static variable used to assign IDs to parking spaces
    private static int id_cnt = 0;
    //the id of each parking space
    private int id;
    //width and depth of each parking space
    private Dimensions spaceDim;
    //the vehicle assigned to the space
    Vehicle vehicle;

    //a default constructor that initializes the space as empty and initializes the dimensions object
    ParkingSpace()
    {
        vehicle = null;
        spaceDim = new Dimensions();
    }

    //a copy constructor (used when creating the temp GarageController)
    public ParkingSpace(ParkingSpace other)
    {
        //copying all attributes of the other parking space
        spaceDim = new Dimensions(other.getSpaceDim().getWidth(), other.getSpaceDim().getDepth());

        id = other.id;
        if(other.vehicle!=null) vehicle = new Vehicle(other.vehicle);
        else vehicle = null;
    }
    //A parameterized constructor
    public ParkingSpace(Dimensions other, Vehicle vehicle1)
    {
        id = ++id_cnt;
        vehicle = new Vehicle(vehicle1);
        spaceDim = new Dimensions(other);
    }
    //An Overloading of the parameterized constructor (used when initializing the main src.Garage)
    public ParkingSpace(Dimensions other)
    {
        vehicle = null;
        spaceDim = new Dimensions(other);
        id = ++id_cnt;
    }
    //getters for some needed member variables
    public double getWidth()
    {
        return spaceDim.getWidth();
    }
    public double getDepth()
    {
        return spaceDim.getWidth();
    }
    public int getId()
    {
        return id;
    }
    public Dimensions getSpaceDim()
    {
        return spaceDim;
    }
    public Vehicle getVehicle()
    {
        return vehicle;
    }
    //setters for member variables
    public void setSpaceDim(Dimensions spaceDim)
    {
        this.spaceDim = new Dimensions(spaceDim);
    }
    public void setVehicle(Vehicle vehicle)
    {
        if(vehicle == null)
            this.vehicle = null;
        else
            this.vehicle = vehicle;
    }

    //Overriding the toString function to customize the printed content of the class
    @Override
    public String toString()
    {
        String res="";
        res+="\nDimensions: "+spaceDim+"\nVehicle: ";
        if(vehicle==null) res+="None";
        else res+=vehicle;
        res+="\n";
        return res;
    }
}
