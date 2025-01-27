/**
 * Count the number of odd values in an array.
 *
 */
public class CountOdds {

   //  C O M P L E T E   T H I S    M E T H O D 

   /**
    * Returns the number of odd values in the paramter.
    */
   public static int countOdds(int[] values) {
      int odds = 0;
      for (int num : values) {
         if (num % 2 == 1) {
            odds++;
         }
      }
      return odds;
   }

}

