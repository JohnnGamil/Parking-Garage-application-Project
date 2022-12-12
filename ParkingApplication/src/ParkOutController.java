/* ParkOutController: A control class used to include All ParkOut functions*/
public class ParkOutController
{
    // A function that removes a vehicle from a spot
    public void freeSpot(ParkingSpace spot)
    {
        spot.setVehicle(null);
    }

    // A function that takes a vehicle and an hourly rate and calculates the parking fees for that vehicle
    public double calcFees(Vehicle vehicle, double hrRate)
    {
        return hrRate * vehicle.getTimeStamps().getTimeDifference();
    }

    // A function that takes a vehicleID and returns the spot the vehicle is in, used during parkOut
    public ParkingSpace getSpotOfVehicle(Garage garage, int VehicleID)
    {
        // gets all parking spots
        ParkingSpace[] spots = garage.getSpots();

        // loops over them
        for(int i=0;i<spots.length;i++)
        {
            // if a spot is occupied and the ID of its vehicle is the same as the passed ID
            if(spots[i].getVehicle()!=null&&VehicleID == spots[i].getVehicle().getId())
            {
                // return that spot
                return spots[i];
            }
        }

        // if the vehicle is not found, return null
        return null;
    }
}
