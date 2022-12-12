/*
    * Garage: A class representing the garage itself, contains parking spaces, as well as multiple controllers that
     perform different garage functionalities
*/
public class Garage
{
    // the garage's parking spots
    private ParkingSpace[] parkingSpaces;

    // A control class for parkIn Functions
    private ParkInController parkInCtrl;

    // A control class for parkOut Functions
    private ParkOutController parkOutCtrl;

    // A control class for payment Functions
    private PaymentController paymentCtrl;

    // A control class for Garage related Functions (to avoid putting them in the garage class)
    private GarageController garageCtrl;

    // Applying the singleton pattern on this class
    static private Garage instance;

    // getter returning the parking spots of the garage
    public ParkingSpace[] getSpots(){return parkingSpaces;}

    // getInstance function to have only one place of access to the garage instance (singleton)
    public static Garage getInstance()
    {
        if(instance == null)
        {
            instance = new Garage();
        }
        return instance;
    }

    // The constructor is private, to allow only one instance to be created (singleton)
    private Garage()
    {
        parkInCtrl = new ParkInController();
        parkOutCtrl = new ParkOutController();
        garageCtrl = new GarageController();
        paymentCtrl = new PaymentController();
    }

    // A setter that takes an array of ParkingSpaces and assigns it to the garage
    public void setParkingSpaces(ParkingSpace[] parkingSpaces)
    {
        this.parkingSpaces = new ParkingSpace[parkingSpaces.length];
        for(int i=0;i<parkingSpaces.length;i++)
            this.parkingSpaces[i] = parkingSpaces[i];
    }

    // A function calling the required parkInController methods to simulate the entire parkIn process
    public void performParkIn(Vehicle vehicle)
    {
        // Find a free spot
        int spotNumber = parkInCtrl.performFind(this, vehicle);

        // If a spot is found
        if(spotNumber!=-1)
        {
            //mark the vehicle's arrival time
            vehicle.getTimeStamps().setArrival();

            //and assign it to the parking spot
            parkInCtrl.assignVehicle(vehicle, this, spotNumber);
            System.out.println("Vehicle successfully Assigned to spot "+(spotNumber+1)+"\n");
        }
        // if no spots are found, display a message
        else
            System.out.println("No Fitting Spaces are Available.\n");
    }

    // A function calling the required parkOutController methods to simulate the entire parkOut process
    public void performParkOut(int vehicleID)
    {
        // Use the id to get the spot where the vehicle is parked
        ParkingSpace spot = parkOutCtrl.getSpotOfVehicle(this, vehicleID);

        // if the spot is not found, then an invalid ID was entered
        if(spot == null)
            System.out.println("Car Not Found, Invalid ID");

        // if the spot is found:
        else
        {
            // Mark the departure time of the vehicle
            Vehicle vehicle = spot.getVehicle();
            vehicle.getTimeStamps().setDeparture();

            // Calculate the parking fees of the vehicle
            double fees = parkOutCtrl.calcFees(vehicle, 5);

            // display the fees to the user
            System.out.println("Parking Fees: " + fees +" EGP");

            // add the current income to the variable storing total income
            garageCtrl.incrementIncome(fees);

            // take the vehicle out of the spot
            parkOutCtrl.freeSpot(spot);

            // Inform the user and simulate the payment process
            System.out.println("Vehicle Released Successfully");
            paymentCtrl.cashPayment();
        }
    }

    // parkInController Getter used to access its functions outside the class
    public ParkInController getParkInCtrl()
    {
        return parkInCtrl;
    }

    // parkOutController Getter used to access its functions outside the class
    public ParkOutController getParkOutCtrl()
    {
        return parkOutCtrl;
    }

    // GarageController Getter used to access its functions outside the class
    public GarageController getGarageCtrl()
    {
        return garageCtrl;
    }

    // PaymentController Getter used to access its functions outside the class
    public PaymentController getPaymentCtrl()  {return paymentCtrl;}
}
