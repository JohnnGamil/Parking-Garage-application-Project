/* ParkInController: A control class used to include All ParkIn functions*/
public class ParkInController
{
    // Contains an object of the spot find algorithm to assign it to different concrete algorithms easily (strategy)
    private SpotFindAlgorithm spotFinder;

    // a setter for the finder object that can take any concrete algorithm that implements spotFindAlgorithm
    public void setFinder(SpotFindAlgorithm finder)
    {
        spotFinder = finder;
    }

    // Executes whatever algorithm is chosen
    public int performFind(Garage garage, Vehicle vehicle)
    {
        return spotFinder.getSpot(garage,vehicle);
    }

    // Assign a vehicle to a spot during parkIn
    void assignVehicle(Vehicle vehicle, Garage garage, int spotID)
    {
        garage.getSpots()[spotID].setVehicle(vehicle);
    }
}
