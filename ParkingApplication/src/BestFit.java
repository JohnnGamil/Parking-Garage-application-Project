/* BestFit:
    A class that implements the SpotFindAlgorithm interface and defines a concrete algorithm for finding a free spot
*/
public class BestFit implements SpotFindAlgorithm
{
    // defining getSpot from the interface
    public int getSpot(Garage garage, Vehicle vehicle)
    {
        //gets all parking spots in the garage
        ParkingSpace [] spots = garage.getSpots();

        //searches through all spots for a spot of minimum area that fits the vehicle
        int i=0, minInd=-1;
        double minArea = Double.MAX_VALUE;

        for(; i< spots.length; i++)
        {
            //if area of spot is less than min Area, and it fits the vehicle, then it is the new Minimum
            if(spots[i].getSpaceDim().getArea() < minArea && spots[i].getSpaceDim().fits(vehicle.getDimensions()))
            {
                minInd = i;
                minArea = spots[i].getSpaceDim().getArea();
            }
        }
        //the index of the spot is returned (or -1 if not found)
        return minInd;
    }
}
