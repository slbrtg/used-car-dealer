import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();

    // int year, String brand, String model, int miles, int price
    Vehicle hatchback = new Vehicle(1994, "Subaru", "Legacy", 170332, 4000);
    Vehicle suv = new Vehicle(2002, "Ford", "Explorer", 112121, 7000);
    Vehicle sedan = new Vehicle(2015, "Toyota", "Camry", 50000, 30000);
    Vehicle truck = new Vehicle(1999, "Ford", "Ranger", 100000, 4000);
    List<Vehicle> allVehicles = new ArrayList<Vehicle>();
    allVehicles.add(hatchback);
    allVehicles.add(suv);
    allVehicles.add(sedan);
    allVehicles.add(truck);

    while(true){
      System.out.println("Welcome to our car dealership. What would you like to do? Enter one of the following options: All Vehicles, Search Price, Add Vehicle, or Exit");

      String navChoice = myConsole.readLine();

      if (navChoice.equals("All Vehicles")){
        System.out.println("All Vehicles");
        for (Vehicle individualVehicle : allVehicles){
            System.out.println("____________________");
            System.out.println( individualVehicle.mYear );
            System.out.println( individualVehicle.mBrand );
            System.out.println( individualVehicle.mModel );
            System.out.println( individualVehicle.mMiles + " miles");
            System.out.println( individualVehicle.mPrice );
            System.out.println( "Cool Car!" );
          }
      } else if (navChoice.equals("Search Price")){
        System.out.println("What is your maximum budget for a vehicle?");
        int userMaxBudget = Integer.parseInt(myConsole.readLine());
        System.out.println("Here's what you can cop");
        for ( Vehicle individualVehicle : allVehicles ){
          if (individualVehicle.inBudget(userMaxBudget)){
            System.out.println( "----------------------" );
            System.out.println( individualVehicle.mYear );
            System.out.println( individualVehicle.mBrand );
            System.out.println( individualVehicle.mModel );
            System.out.println( individualVehicle.mMiles );
            System.out.println( individualVehicle.mPrice );
          }
        }
      } else if (navChoice.equals("Add Vehicle")){
        System.out.println("Alright, let's add a vehicle");
        System.out.println("What year was this vehicle made?");
        int userVehicleYear = Integer.parseInt(myConsole.readLine());
        System.out.println("What brand is this vehicle?");
        String userVehicleBrand = myConsole.readLine();
        System.out.println("What model is the vehicle?");
        String userVehicleModel = myConsole.readLine();
        System.out.println("And how many miles does it have on it?");
        int userVehicleMiles = Integer.parseInt(myConsole.readLine());
        System.out.println("Finally, what's its price?");
        int userVehiclePrice = Integer.parseInt(myConsole.readLine());
        // int year, String brand, String model, int miles, int price
        Vehicle userVehicle = new Vehicle(userVehicleYear, userVehicleBrand, userVehicleModel, userVehicleMiles, userVehiclePrice);
        allVehicles.add(userVehicle);
        System.out.println("Alright, here's your new vehicle:");
        System.out.println( "----------------------" );
        System.out.println( userVehicle.mYear );
        System.out.println( userVehicle.mBrand );
        System.out.println( userVehicle.mModel );
        System.out.println( userVehicle.mMiles );
        System.out.println( userVehicle.mPrice );
      } else if (navChoice.equals("Exit")){
        break;
      } else {
        System.out.println("I'm sorry, we don't recognize your input");
      }
    }
  }
}
