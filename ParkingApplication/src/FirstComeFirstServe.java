/* FirstComeFirstServe:
    A class that implements the SpotFindAlgorithm interface and defines a concrete algorithm for finding a free spot
*/
public class FirstComeFirstServe implements SpotFindAlgorithm
{
    //defining the getSpot method in the interface
    public int getSpot(Garage garage, Vehicle vehicle)
    {
        //getting all spots in the garage
        ParkingSpace [] spots = garage.getSpots();

        //looping through them
        int i=0;
        for(; i< spots.length; i++)
        {
            // returning the index of the first spot that fits
            if (spots[i].getSpaceDim().fits(vehicle.getDimensions()))
                return i;
        }

        //if no spots fit, returns -1
        return -1;
    }
}
