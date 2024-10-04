// Participation Scores: 
// Matthew Lauer - 100%
// Sophia Nadasy - 100%
// Dan Le - 100%
// Sri Teja Kale - 100%
// Sri Bhuvan Maddipudi - 0% 

import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import org.junit.*;
public class SlimStackRI2Tests {

    @Test
    public void repOk_testEmptyStack() {
        SlimStackRI2 stack = new SlimStackRI2();
        assertTrue(stack.repOkRI2()); 
    }
    @Test
    public void repOk_testPush() {
        SlimStackRI2 stack = new SlimStackRI2();
        stack.push(5);
        assertTrue(stack.repOkRI2()); 
    }
    @Test
    public void repOk_testMultiplePush() {
        SlimStackRI2 stack = new SlimStackRI2();
        stack.push(5);
        stack.push(6);
        assertTrue(stack.repOkRI2()); 
    }
    @Test(expected = EmptyStackException.class)
    public void repOk_testEmptyStackPop() {
        SlimStackRI2 stack = new SlimStackRI2();
        stack.pop();
    }
    @Test
    public void repOk_testPushPop() {
        SlimStackRI2 stack = new SlimStackRI2();
        stack.push(5);
        stack.pop();
        assertTrue(stack.repOkRI2()); 
    }


}