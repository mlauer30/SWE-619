package com.module.discussion;

public class oldStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
 
 
    public oldStack() {
      this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
 
    public void push (Object e) {
      ensureCapacity();
      elements[size++] = e;
    }
 
    public Object pop () {
      if (size == 0) throw new IllegalStateException("Stack.pop");
      Object result = elements[--size];
      elements[size] = null;    // Eliminate obsolete reference
      return result;
    }
 
    private void ensureCapacity() {
       if (elements.length == size) {
          Object oldElements[] = elements;
          elements = new Object[2*size + 1];
          System.arraycopy(oldElements, 0, elements, 0, size);
       }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        
    }
}
