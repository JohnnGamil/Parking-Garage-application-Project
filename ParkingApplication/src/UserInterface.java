/* User Interface:
    * a boundary class that User Interacts with, including multiple display and initialize functions
    * as well as the main menu
*/

import java.util.Scanner;
public class UserInterface
{
    //Scanner used to input values from users
    static private final Scanner in = new Scanner(System.in);
    //variable representing menu choice
    static private int choice=1;
    //variable representing the Main Garage
    static private Garage garage = Garage.getInstance();
    //A variable used to store the user's input for the slot configuration method

    //A function that prints the main menu
    public static void displayMenu()
    {
        System.out.println("""
                1- Park In
                2- Park Out
                3- Display Available Slots
                4- Display Total Income
                5- Display Current Number of Vehicles
                6- Exit
                """);
    }
    //A function used to get and validate user's input for the slot configuration method
    public static void methodInput()
    {
        System.out.println("""
                Enter the preferred slot configuration:
                1- First Come, First Serve
                2- Best-Fit Approach
                """);

        int spotConfig = in.nextInt();
        while(spotConfig!=1&&spotConfig!=2)
        {
            System.out.println("Invalid Choice");
            System.out.println("""
                Enter the preferred slot configuration:
                1- First Come, First Serve
                2- Best-Fit Approach
                """);
            spotConfig = in.nextInt();
        }
        if(spotConfig == 1)
            garage.getParkInCtrl().setFinder(new FirstComeFirstServe());
        else
            garage.getParkInCtrl().setFinder(new BestFit());
    }
    //A function that prints information about Parking Spots that are currently vacant
    public static void displayAvailableSpots()
    {
        GarageController.displayAvailableSpots(garage);
    }
    //A function used to get user input for the Vehicle to be parked in
    public static Vehicle identifyVehicle()
    {
        int id, modelYear;
        String modelName;
        double width, depth;

        System.out.println("Please Enter Vehicle Information: ");
        System.out.println("ID: ");

        id = in.nextInt();

        System.out.println("Model Name: ");

        modelName = in.next();

        System.out.println("Model Year: ");

        modelYear = in.nextInt();
        System.out.println("Width and Depth: ");
        //handling the exception when the Vehicle's dimensions are invalid
        try
        {
            width = in.nextDouble();
            depth = in.nextDouble();
            if(width <= 0 || depth <= 0)
                throw new Exception("Invalid Dimensions");
            return new Vehicle(id, modelName, modelYear, new Dimensions(width,depth));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        //if the vehicle is invalid, return null;
        return null;
    }
    //A function that displays the number of Vehicles currently in the Garage
    public void displayNumberOfVehicles()
    {

        System.out.println("The Number of Vehicles is: "+GarageController.calcNumVehicles(garage));
    }

    //The function that is activated when the User starts the program
    public static void main(String[] args)
    {

        System.out.println("Garage Setup\nEnter Garage Capacity: ");

        //Getting garage capacity
        int garageCapacity = in.nextInt();

        //a temp array of parking spaces
        ParkingSpace[] arr = new ParkingSpace[garageCapacity];
        for(int i=0;i<arr.length;i++)
        {
            //getting and validating the dimensions of parking spaces
            System.out.println("Enter width and depth of Slot "+ (i+1) +":");
            double width=0, depth=0;
            try
            {
                width = in.nextDouble();
                depth = in.nextDouble();
                if(width <= 0 || depth <= 0)
                    throw new Exception("Invalid Dimensions");
                arr[i] = new ParkingSpace(new Dimensions(width, depth));
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                //decrementing i to allow the user to re-enter the same slot again
                i--;
            }
        }
        methodInput();
        garage.setParkingSpaces(arr);

        System.out.println("Garage Initialized Successfully.");

        //main menu choices
        while(choice!=6)
        {
            displayMenu();
            choice = in.nextInt();

            //Park in choice
            if(choice==1)
            {
                Vehicle current = identifyVehicle();
                if(current != null)
                    garage.performParkIn(current);
            }
            //Display available slots choice
            else if(choice==3)
                displayAvailableSpots();
            //Park Out choice
            else if(choice==2)
            {
                System.out.println("Please Enter Vehicle ID: ");
                int vID = in.nextInt();
                garage.performParkOut(vID);
            }
            else if(choice==4)
            {
                System.out.println("Total Income: "+garage.getGarageCtrl().getIncome()+"\n");
            }
            else if(choice == 5)
            {
                System.out.println("Total Number of Vehicles Currently: "+GarageController.calcNumVehicles(garage)+"\n");
            }
            //Exit Choice
            else if(choice==6)
                System.out.println("Thanks for Using Our Software\n");
            //Handling Invalid Choices
            else
                System.out.println("Invalid Choice\n");
        }
    }
}
