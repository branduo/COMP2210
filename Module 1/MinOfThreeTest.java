import org.junit.Assert;
import org.junit.Test;


public class MinOfThreeTest {

   /** A test that always fails. **/
   @Test public void min1Test1() {
      int a = 3;
      int b = 1;
      int c = 2;
      int min = MinOfThree.min1(a, b, c);
      Assert.assertEquals(b, min);
   }
   
   @Test public void min1Test2() {
      int a = 1;
      int b = 2;
      int c = 3;
      int min = MinOfThree.min1(a, b, c);
      Assert.assertEquals(a, min);
   }
   
   @Test public void min1Test3() {
      int a = 2;
      int b = 3;
      int c = 1;
      int min = MinOfThree.min1(a, b, c);
      Assert.assertEquals(c, min);
   }
   
   @Test public void min2Test1() {
      int a = 3;
      int b = 1;
      int c = 2;
      int min = MinOfThree.min2(a, b, c);
      Assert.assertEquals(b, min);
   }
   
   @Test public void min2Test2() {
      int a = 1;
      int b = 2;
      int c = 3;
      int min = MinOfThree.min2(a, b, c);
      Assert.assertEquals(a, min);
   }
   
   @Test public void min2Test3() {
      int a = 2;
      int b = 3;
      int c = 1;
      int min = MinOfThree.min2(a, b, c);
      Assert.assertEquals(c, min);
   }
}
