/*
* Dimensions is a class that stores the width and depth of a Vehicle or a Parking Space
*/
public class Dimensions
{
    //two member variables: width & depth
    private double width;
    private double depth;

    //setters and getters for the width and depth
    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getDepth()
    {
        return depth;
    }

    public void setDepth(double depth)
    {
        this.depth = depth;
    }
    //default constructor that does nothing
    public Dimensions(){}
    //parameterized constructor that initializes both variables
    public Dimensions(double width, double depth)
    {
        this.width = width;
        this.depth = depth;
    }
    //A copy constructor
    public Dimensions(Dimensions other)
    {
        this(other.width, other.depth);
    }

    //A function used to determine whether a Parking space fits a Vehicle or not
    public boolean fits(Dimensions carDim)
    {
        return (this.width >= carDim.width && this.depth >= carDim.depth);
    }

    public double getArea()
    {
        return (this.getWidth() * this.getDepth());
    }

    //Overriding the toString function to customize the printed content of the class
    @Override
    public String toString()
    {
        return "\nWidth: "+width+"\nDepth: "+depth;
    }
}
