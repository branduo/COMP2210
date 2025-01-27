import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Brandon Duong (bhd0014@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01/29/2023
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
   private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     * 
     * @param a represents array a and is used to find the minimum.
     * @return minimum variable that represents the smallest number in
     * array a.
     * @throws IllegalArgumentException if array a has a length of 0
     * or is null.
     */
   public static int min(int[] a) {
      int minimum = a[0];
      
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] < minimum) {
            minimum = a[i];
         }
      }
      return minimum;
   }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     *
     * @param a represents array a and is used to find the maximum.
     * @return maximum variable that represents the biggest number in
     * array a.
     * @throws IllegalArgumentException if array a has a length of 0
     * or is null.
     */
   public static int max(int[] a) {
      int maximum = a[0];
      
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      else {
         for (int i = 0; i < a.length; i++) {
            if (a[i] > maximum) {
               maximum = a[i];
            }
         }
      }
      return maximum;
   }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     * 
     * @param a represents array a.
     * @param k represents the kth value to look for.
     * @return kmin variable.
     * @throws IllegalArgumentException if array a has a length of 0
     * or is null.
     */
   public static int kmin(int[] a, int k) {
      int[] aCopy = Arrays.copyOf(a, a.length);
      int distinct = 1;
      int kmin = 0;
     
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      else {
         Arrays.sort(aCopy);
         
         if (k == 1) {
            kmin = aCopy[0];
            return kmin;
         }
         
         for (int i = 1; i < a.length; i++) {
            if (aCopy[i] != aCopy[0]) {
               distinct++;
               if (distinct == k) {
                  kmin = aCopy[i];
               }
            }
         }
      }
      
      if (k > distinct) {
         throw new IllegalArgumentException();
      }
      
      return kmin;
   }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     *
     * @param a represents array a.
     * @param k represents the kth value to look for.
     * @return kmax variable.
     * @throws IllegalArgumentException if array a has a length of 0
     * or is null.
     */
   public static int kmax(int[] a, int k) {
      int[] aCopy = Arrays.copyOf(a, a.length);
      int distinct = 1;
      int kmax = 0;
     
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      else {
         Arrays.sort(aCopy);
         
         if (k == 1) {
            kmax = aCopy[0];
            return kmax;
         }
         
         for (int i = aCopy.length - 1; i >= 0; i--) {
            if (aCopy[i] != aCopy[0]) {
               distinct++;
               if (distinct == k) {
                  kmax = aCopy[i];
               }
            }
         }
      }
      
      if (k > distinct) {
         throw new IllegalArgumentException();
      }
      
      return kmax;
   }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     * 
     * @param a represents array a.
     * @param low represents the lowest value in the array.
     * @param high represents the highest value in the array.
     * @return array variable containing all values between low and high.
     * @throws IllegalArgumentException if array a has a length of 0
     * or is null.
     * 
     */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int range = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            range++;
         }
      }
      
      int[] array = new int[range];
      if (range == 0) {
         return array;
      }
      
      int b = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            array[b] = a[i];
            b++;
         }
      }
      return array;
   }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     *
     * @param a represents array a.
     * @param key represents the value
     */
   public static int ceiling(int[] a, int key) {
     
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int ceiling = 0;
      boolean found = false;
      
      for (int i = 0; i < a.length; i++) {
         if (!found && a[i] >= key) {
            ceiling = a[i];
            found = true;
         }
         
         else if (a[i] >= key && a[i] <= ceiling) {
            ceiling = a[i];
         }
      }
      
      if (!found) {
         throw new IllegalArgumentException();
      }
      
      return ceiling;
   }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int floor = 0;
      boolean found = false; //Tels if first possible floor found
      for (int i = 0; i < a.length; i ++) {
         //If no first floor, only compare to key.
         if (!found && a[i] <= key) {
            floor = a[i];
            found = true;
         }
            //If already found a floor, compare to key and previous floor.
         else if (a[i] <= key && a[i] >= floor) {
            floor = a[i];
         }
      }
         //If never found a floor value, throw an exception.
      if (!found) {
         throw new IllegalArgumentException();
      }
      return floor;
   }

}
