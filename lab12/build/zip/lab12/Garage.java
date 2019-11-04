package lab12;// Lab 10: Garage.java
// Program calculates charges for parking

import java.util.Scanner;

public class Garage
{

   // begin calculating charges
   public void startCharging()
   {
      Scanner input = new Scanner( System.in );
      
      double totalReceipts = 0.0; // total fee collected for the day
      double fee; // the charge for the current customer
      double hours = 0; // hours for the current customer
            
      // read in the first customer's hours
      System.out.print(
         "Enter number of hours (a negative to quit): " );
      System.out.println(); //there is a very important reason why this is a separate line
      hours = input.nextDouble();

      while ( hours >= 0.0 )
      {

         /* Write code here to calculate the fee and assign it to the variable fee */
         fee = calculateCharges(hours);

         /* Write code here to calculate the total receipts */
         totalReceipts += fee;

         System.out.printf(
            "Current charge: $%.2f,\n Total receipts: $%.2f\n",
            fee, totalReceipts );

         // read in the next customer's hours
         System.out.print(
            "Enter number of hours (a negative to quit): " );
         System.out.println();
         hours = input.nextDouble();
      } // end while loop      
   } // end method startCharging


   // determines fee based on time
   /* Write the header for the calculateCharges method */
   private double calculateCharges(double hours) {
      // apply minimum charge
      /* Write a line of code that declares and initializes a variable 
         with the minimum charge of $2 */
      double charge = 2d;

      // add extra fees as applicable
      /* Write an if statement that determines whether hours is greater 
         than 3.0 and, if so, calculates the additional charge.  */
      if (hours > 3d) {
         charge += (hours - 3) * 0.5;
      }
      // apply maximum value if needed
      /* Write code here that determines whether the 10 hour maximum has been reached
         and if so sets the maximum charge */
      charge = Math.min(10d, charge);

      /* Write a line of code that returns the calculated charge */
      return charge;
   } // end method calculateCharges

} // end class Garage