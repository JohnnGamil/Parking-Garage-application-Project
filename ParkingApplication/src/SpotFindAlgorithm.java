/* SpotFindAlgorithm: An Interface that can be implemented by concrete classes to provide different algorithms of
 finding a parking spot for a vehicle
*/
public interface SpotFindAlgorithm
{
    // the method to be defined when the interface is implemented
    int getSpot(Garage garage, Vehicle vehicle);
}
