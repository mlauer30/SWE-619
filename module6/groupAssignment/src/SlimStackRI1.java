import java.util.*;

// Abstract Description:
// A stack is a List that only allows insert/remove at right end.
// SlimStack is stack that does not allow for identical elements to be adjacent to each other.
// Note: duplicates are allowed, as long as they are not adjacent.
public class SlimStackRI1 {

	// AF(this) = a list built by copying the elements in "elements[0.. size-1]" while ignoring identical adjacent elements
	//  		e.g, if elements is [5 8 8 8 4 6 6 6 6 5 5] a SlimStack would be [5 8 4 6 5]
		
	// Rep-invariant1: elements != null and 0 <= size <= elements.length
	// 				 for any index i such that 0 <= i < size, elements[i] != null	
   
    // Rep-invariant2: elements != null and 0 <= size <= elements.length
    // 				 for any index i such that 0 <= i < size, elements[i] != null
    // 				 for any index i such that 1 <= i < size, elements[i].equals(elements[i-1]) is false   
   
   private Object[] elements;
   private int size = 0;

   // Rep-invariant1: 
   // elements != null and 0 <= size <= elements.length
	// for any index i such that 0 <= i < size, elements[i] != null
   boolean repOkRI1() {
      for (int i = 0; i < size; i++) {
         if (elements[i] == null) {
            return false;
         }
      }
      return (
      elements != null &&
      elements.length >= 0 &&
      size >= 0 &&
      size <= elements.length
      );
   }
   
     
    // Note: AF is the specification for toString()
	// Effects: returns a string representation of a list built by copying the elements in "elements[0.. size-1]" while ignoring identical adjacent elements
	//  		e.g, if elements is [5 8 8 8 4 6 6 6 6 5 5] a SlimStack would be [5 8 4 6 5]
   public String toString() {
		if (size == 0) return "SlimStack:[]";
		
		String output = "SlimStack:[";
      String prev = elements[0] instanceof String ? "'" + elements[0] + "'" : elements[0].toString();
      output += prev + " ";
		for (int i = 1; i < this.size; i++) {
         String current = elements[i] instanceof String ? "'" + elements[i] + "'" : elements[i].toString();
         if (!current.equals(prev)) {
            if (elements[i] instanceof String) { 
               output = output + "'" + elements[i] + "'";
            } else { 
               output = output + elements[i].toString();
            }
            prev = current;
            if (i < size-1) 
               output += " ";	
         }
				
		}
		output = output.trim() + "]";
		
		return output;
	}



   // Effects: creates an empty stack
   public SlimStackRI1() {
     this.elements = new Object[0];
   }

   // Effects: Pushes e onto the top of this stack
   //		   i.e., this becomes this + [e]
   //          throws IllegalArgumentException if e is null
   // Rep-invariant1: elements != null and 0 <= size <= elements.length
   // 				 for any index i such that 0 <= i < size, elements[i] != null	
   public void push (Object e) {
      if (e == null) throw new IllegalArgumentException();
       ensureCapacity();
       elements[size++] = e;
   }
   
   // Effects: Removes the object at the top of this stack and any identical objects adjacent to it
   //		   e.g, if the stack is [6 8 8 8 4 6 6 6 6 ] a SlimStack would be [6 8 8 8 4 ]
   //          throws EmptyStackException if this stack is empty 
   public void pop () {
     if (size <= 0) throw new EmptyStackException();
     Object top = elements[size - 1];
     while(size > 0 && elements[size - 1].equals(top)) {
        elements[--size] = null;
     }
   }

   private void ensureCapacity() {
      if (elements.length == size) {
         Object oldElements[] = elements;
         elements = new Object[2*size + 1];
         System.arraycopy(oldElements, 0, elements, 0, size);
      }
   }



   public static void main(String args[]) {
	   SlimStack s = new SlimStack(); // [5 8 8 8 4 6 6 6 6 5 5]
	   s.push(5);
	   s.push(8);
	   s.push(8);
	   s.push(8);
	   s.push(4);
	   s.push(6);
	   s.push(6);
	   s.push(6);
	   s.push(6);
	   s.push(5);
	   s.push(5);

      System.out.println(s);

	   s.pop();
	   s.pop();

	   System.out.println(s);

      s.pop();
      s.pop();

      System.out.println(s);
   }
}