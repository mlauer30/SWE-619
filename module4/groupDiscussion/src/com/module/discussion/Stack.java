package com.module.discussion;
public final class Stack {

  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  
  public Stack() {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  private Stack(Object[] elements, int size, Object e) {
    this.elements = new Object[elements.length];
    // copy elements list
    System.arraycopy(elements, 0, this.elements, 0, size);
    // set the size
    this.size = size;
    // set new element into new elements list
    this.elements[this.size++] = e;
  }

  public Stack push(Object e) {
    ensureCapacity();
    Stack newStack = new Stack(this.elements, this.size, e);
    return newStack;
  }

  public Stack pop() {
    if (size == 0) throw new IllegalStateException("Stack.pop");
    // Object result = elements[--size];
    Stack result = new Stack(this.elements, this.size - 1, null);
    //elements[size] = null; // Eliminate obsolete reference
    result.size = size - 1;
    return result;
  }

  public Object peek() {
    if (size == 0) throw new IllegalStateException("Stack.pop");
    return elements[size - 1];
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      Object oldElements[] = elements;
      elements = new Object[2 * size + 1];
      System.arraycopy(oldElements, 0, elements, 0, size);
    }
  }

  public String toString() {
    String s = "";
    int index = 0;
    while(elements[index] != null) {
      s += elements[index++] + " ";
    }    
    return s;
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack = stack.push("1");
    stack = stack.push("2");
    stack = stack.push("3");
    stack = stack.push("4");
    stack = stack.push("5");
    System.out.println("peeking " + stack.peek());

    // Stack test = new Stack();
    // Stack testPointer = test;
    // System.out.println(test == testPointer);
    // test = test.push("1");
    // System.out.println(test == testPointer);

    // System.out.println(stack.pop());
    stack = stack.pop();
    System.out.println(stack.toString());
    stack = stack.push("5");
    System.out.println(stack.peek());
  }
}
