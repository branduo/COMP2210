import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {

   private final Term[] terms;
   private int length;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) {
   
      if (terms == null) {
         throw new NullPointerException();
      }
      
      else {
         this.terms = Arrays.copyOf(terms, terms.length);
         Arrays.sort(this.terms);
      }
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) {
      
      if (prefix == null) {
         throw new NullPointerException();
      }
      
      else {
         Term prefixTerm = new Term(prefix, 0);
         int firstIndex = BinarySearch.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
         int lastIndex = BinarySearch.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
         
         if (firstIndex == -1 || lastIndex == -1) {
            return new Term[0];
         }
         
         Term[] match = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1);
         Arrays.sort(match, Term.byDescendingWeightOrder());
         return match;
      }
      
   }

}

