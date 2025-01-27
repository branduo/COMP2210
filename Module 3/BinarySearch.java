import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      
      Arrays.sort(a);
      int left = 0;
      int right = a.length - 1;
      int firstIndex = -1;
      
      while (left <= right) {
         int middle = (left + right) / 2;
         int comp = comparator.compare(key, a[middle]);
         
         if (comp < 0) {
            right = middle - 1;
         }
         
         else if (comp > 0) {
            left = middle + 1;
         }
         
         else {
            firstIndex = middle;
            right = middle - 1;
         }
      }
      return firstIndex;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      
      Arrays.sort(a);
      int left = 0;
      int right = a.length - 1;
      int lastIndex = -1;
      
      while (left <= right) {
         int middle = (left + right) / 2;
         int comp = comparator.compare(key, a[middle]);
         if (comp < 0) {
            right = middle - 1;
         }
         
         else if (comp > 0) {
            left = middle + 1;
         }
         
         else {
            lastIndex = middle;
            left = middle + 1;
         }
      }
      return lastIndex;
   }

}
