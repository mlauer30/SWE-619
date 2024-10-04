package module5.groupAssignment;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.util.EmptyStackException;

//import static org.junit.Assert.*;
//import org.junit.jupiter.api.Test;

import org.junit.*;
import org.junit.runner.RunWith;


// Participation Scores: 
// Matthew Lauer - 100%
// Sophia Nadasy - 100%
// Dan Le - 100%
// Sri Teja Kale - 100%
// Sri Bhuvan Maddipudi - 100%
public class StackTester {

  @Test
  public void repOk_testEmptyStack() {
    Stack stack = new Stack();
    assertTrue(stack.repOk()); 
  }

	@Test
  public void repOk_testPushMultipleThenPopOnce() {
    Stack stack = new Stack();
		stack.push("Dog");
		stack.push("Cat");
		stack.pop();
    assertTrue(stack.repOk());
  }

  //repOk() test
  @Test(expected = EmptyStackException.class)
  public void repOk_testEmptyStackPop() {
    Stack stack = new Stack();
    stack.pop();
  }

  @Test
  public void repOk_testOnePush() {
    Stack stack = new Stack();
    stack.push("NY"); 
    assertTrue(stack.repOk());
  }

  @Test
  public void repOk_testPushAfterPop() {
    Stack stack = new Stack();
    stack.push("Dan");
	stack.push("Matthew");
	stack.push("Sophia");
	stack.pop();
	stack.push("Sri");
    assertTrue(stack.repOk());
  }



  @Test
  public void toString_testPush() {
    Stack stack = new Stack();
    stack.push("NYC");
    stack.push("DC");
    stack.push("LA");

    assertEquals("Stack:['NYC','DC','LA']", stack.toString());
  }

  @Test
  public void toString_testInitialStack() {
    Stack stack = new Stack();
    assertEquals("Stack:[]", stack.toString());
  }

  @Test
  public void toString_testIntegerStack() {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals("Stack:['1','2','3']", stack.toString());
  }

  @Test
  public void toString_testPushMultiplePopOnce() {
    Stack stack = new Stack();
    stack.push("NYC");
    stack.push("DC");
    stack.push("LA");
    stack.pop();

    assertEquals("Stack:['NYC','DC','null']", stack.toString());
  }

  @Test
  public void toString_testPushAfterPop() {
    Stack stack = new Stack();
    stack.push("NYC");
    stack.push("DC");
    stack.push("LA");
    stack.pop(); // Removes "LA"
    stack.push("VA"); // Push "VA" to replace it

    assertEquals("Stack:['NYC','DC','VA']", stack.toString());
  }
}
