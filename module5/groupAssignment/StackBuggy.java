package module5.groupAssignment;

import java.util.*;

// Participation Scores: 
// Matthew Lauer - 100%
// Sophia Nadasy - 100%
// Dan Le - 100%
// Sri Teja Kale - 100%
// Sri Bhuvan Maddipudi - 100%
public class StackBuggy {

  private Object[] elements;
  private int size = 0;

  // Rep-invariant:
  //
  // elements != null
  // elements.length >= 0
  // size >= 0
  // size <= elements.length
  //

  boolean repOk() {
    return (
      elements != null &&
      elements.length >= 0 &&
      size >= 0 &&
      size <= elements.length
    );
  }

  // AF(this) = a string representing the elements of the stack
  //
  //
  //
  //
  public String toString() {
    //"Stack:['NYC','DC','LA']"
    String output = "Stack:[";
    for (Object el : elements) {
      output += "'" + el.toString() + "',";
    }
    output =
      elements.length > 0
        ? output.substring(0, output.length() - 1) + "]"
        : output + "]";
    return output;
  }

  // Effects: creates an empty stack
  public StackBuggy() {
    this.elements = new Object[0];
  }

  // Effects: Pushes e onto the top of this stack
  //		   i.e., this becomes this + [e]
  //          throws IllegalArgumentException if e is null
  public void push(Object e) {
    if (e == null) throw new IllegalArgumentException();
    ensureCapacity();
    elements[size++] = e;
  }

  // Effects: Removes the object at the top of this stack and returns it as the value of this function
  //	       i.e., this becomes this - [e]
  //          throws EmptyStackException if this stack is empty
  public Object pop() {
    if (size <= 0) {
      this.elements = null; // makes elements null, violating the rep-invariant
      return null; 
    }
    Object result = elements[--size];
    elements[size] = null;
    return result;
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      Object oldElements[] = elements;
      elements = new Object[2 * size + 1];    
      System.arraycopy(oldElements, 0, elements, 0, size);
    }
  }
}
