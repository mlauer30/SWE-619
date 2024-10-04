package module5.groupAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

// Participation Scores: 
// Matthew Lauer - 100%
// Sophia Nadasy - 100%
// Dan Le - 100%
// Sri Teja Kale - 100%
// Sri Bhuvan Maddipudi - 100%
public class StackTesterBuggy {

  @Test
  public void repOk_testPopEmptyStack() {
    StackBuggy stack = new StackBuggy();
    stack.pop();
    assertFalse("It failed because of a nullpointer", stack.repOk());
  }
}