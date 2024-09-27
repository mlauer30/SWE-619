package module5.groupAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * StackBuggyTester
 */
public class StackTesterBuggy {

  @Test
  public void repOk_testPopEmptyStack() {
    StackBuggy stack = new StackBuggy();
    stack.pop();
    assertFalse("It failed because of a nullpointer", stack.repOk());
  }
}