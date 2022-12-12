/*
    * GarageController: A control class used to include some garage functions, such as calculating number of vehicles
     and total income
*/
public class GarageController
{
    // A variable that stores the total income of the garage
    private double income;

    // A function that calculate the number of vehicles currently parked in the garage
    public static int calcNumVehicles(Garage garage)
    {
        int count = 0;

        ParkingSpace[] spots = garage.getSpots();

        // loops over all parking spots
        for(int i=0; i<spots.length; i++)
        {
            // if the spot is occupied, increments the counter
            if(spots[i].getVehicle() != null)
                count++;
        }

        return count;
    }

    // a getter for the total income, used when displaying it
    public double getIncome()  {return this.income;}

    // A function used to add the new income to the total income when parking out
    public void incrementIncome(double newInc)
    {
        income+=newInc;
    }

    // A function that displays unoccupied spots in the garage
    public static void displayAvailableSpots(Garage garage)
    {
        // gets all spots
        ParkingSpace[] spots = garage.getSpots();

        // loops over them
        for(int i=0; i<spots.length; i++)
        {
            // if a spot has no vehicle in it, prints its information
            if(spots[i].getVehicle() == null)
                System.out.println("Spot "+(i+1)+":"+spots[i]);
        }
    }
    // A constructor initializing the income to zero
    public GarageController()
    {
        income = 0;
    }
}
