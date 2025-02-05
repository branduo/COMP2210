import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {

   String query;
   long weight;
   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) {
      if (query == null) {
         throw new NullPointerException();
      }
      
      if (weight < 0) {
         throw new IllegalArgumentException();
      }
      
      this.query = query;
      this.weight = weight;
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return 
         new Comparator<Term>() {
            public int compare(Term firstTerm, Term secondTerm) {
               return Long.compare(secondTerm.weight, firstTerm.weight);
            }
         };
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      if (length <= 0) {
         throw new IllegalArgumentException();
      }
      
      return 
         new Comparator<Term>() {
            public int compare(Term firstTerm, Term secondTerm) {
               String a = firstTerm.query;
               String b = secondTerm.query;
               a = a.substring(0, Math.min(length, a.length()));
               b = b.substring(0, Math.min(length, b.length()));
               return a.compareTo(b);
            }
         };
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      Term one = other;
      return this.query.compareTo(one.query);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return query + "\t" + weight;
   }

}

