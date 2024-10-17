/**
 * Participation:
 * Matthew Lauer: 100%
 * Dan Le: 100%
 * Sri Teja: 100%
 * Sophia Nadasy: 100%
 */
import java.util.*;
/**
 * Download and run Equality_Assignment8.java. Execute its code and provide a "detailed/convincing" explanation of its behavior. Make sure to consider the notes below.

 * Set interface precondition: "Great care must be exercised if mutable objects are used as set elements. 
 * The behavior of a set is not specified if the value of an object is changed in a manner that affects equals comparisons while the object is an element in the set."

 * ArrayList.equals() operates as follow: "Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list,
 * both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
 * In other words, two lists are defined to be equal if they contain the same elements in the same order." 
 * This implementation first checks if the specified object is this list.
 * If so, it returns true; if not, it checks if the specified object is a list. 
 * If not, it returns false; if so, it iterates over both lists, comparing corresponding pairs of elements. If any comparison returns false, this method returns false. 
 * If either iterator runs out of elements before the other it returns false (as the lists are of unequal length); otherwise it returns true when the iterations complete.
 */
public class Group5_Equality_Assignment8 {
    public static void main(String args[]) {	
        Set<List<String>> s = new HashSet<List<String>>();     
            System.out.println(s);
        
        List<String> x = new ArrayList<String>();  
            System.out.println(x);
        
        List<String> y = new ArrayList<String>();  
            System.out.println(y);
        
        s.add(x);		 
            System.out.println(s);
            
        s.add(y);		 
            System.out.println(s);
            
        boolean b = s.contains(y);    
            System.out.println(b);
            
        y.add("cat");	         
                                 
            System.out.println(y); 
            System.out.println(s);
            
        b = s.contains(y);           
            System.out.println(b);   
                                    
        s.add(y);		 	
            System.out.println(s);           
            
            
            
        y.remove("cat");	 
            System.out.println(s);  
    
        s.remove(y);             
            System.out.println(s);
            
        b = s.contains(y);           
            System.out.println(b);
            System.out.println("y = "+ y);
        
        b = s.contains(x);           
            System.out.println(b);
    }
}

// Line by line explanation of code 
// Output : 

// [] \\s output 

// [] \\x output 

// [] \\y output 

// [[]] \\s after s.add(x); 

// [[]] \\s after s.add(y); 

// true \\b output if s.contains(y);  returns true when the two sets being compared have the equivalent size and elements

// [cat] \\y output after y.add(“cat”); 

// [[]] \\s output 

// false \\b output after s.contains(y); 

// [[], [cat]] \\s output after s.add(y); 

// [[], []] \\s output after y.remove(“cat”); 

// [[]] \\s output after s.remove(y); 

// False \\b output after s.contains(y); 

// y = [] \\y output 

// False \\b output after s.contains(x); 

// Explanation of code behavior: 
/**
 * The program begins by defining a Set s and two List's x and y. 
 * s then adds the two lists, x and y, to its HashSet. We add an empty value x to s 
 * which places the unique empty value [] into the set, however when the empty value for y is added
 * no duplicates are allowed in the set so the set states remains the same.
 * 
 * The program then creates a boolean variable, b, to check if the set, s, contains y,
 * which returns true when the two sets being compared have the equivalent size and elements.
 * 
 * Then, the string "cat" is added to the List, y, and the contents of the Set s is checked 
 * and appears to continue to be empty, only containing [], demonstrating that the 
 * contents of the Set remains unchanged after altering its supposed contents of the List y.
 * 
 * This is because what is actually in the set, is the List x. 
 * The boolean checking earlier if s contained y returned true only because x and y happened to be the same, they were both empty.
 * This is where the set mutability issue arises. When "cat" is added to y, the hash code and 
 * equality of y change. However, since the set s relies on the original state of y (before the modification), 
 * it has no way of knowing about the change.
 * 
 * Another check is performed to see if s still contains y and returns false. 
 * This suggests that the List object, y, is not in the Set, even though when checked earlier, it returned true.
 * The addition of "cat" to the List y modified its reference from the Set because we are not allowed to have 
 * duplicate values in the HashSet.
 * 
 * Then the modified List y is added back to the Set, now modifiying the Set's contents.
 * This updates the reference from the Set to the List y, because now when y is modified,
 * in this case by removing "cat", the Set is updated accordingly.
 * 
 * Then, the empty List y is removed from the Set s, and the boolean b returns false when s checks for the reference to y. * 
 * Now that duplicate values have been introduced in the hash set, the place in memory that used to define x is no longer using the proper hash code, and is giving us an 
 * unexpected return where the value [] cannot be located even though we know that it is still in the set.
 * 
 * Because x and y are mutable Lists, the Set should use defensive copying or containers because the set's behavior is not specifed for the use of mutable objects as set elements. 
 */