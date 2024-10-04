import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import org.junit.*;
public class SlimStackRI1Tests {
    
    // Rep-invariant1: 
    // elements != null and 0 <= size <= elements.length
	// for any index i such that 0 <= i < size, elements[i] != null

    @Test
    public void repOk_testEmptyStack() {
        SlimStackRI1 stack = new SlimStackRI1();
        assertTrue(stack.repOkRI1()); 
    }
    @Test
    public void repOk_testPush() {
        SlimStackRI1 stack = new SlimStackRI1();
        stack.push(5);
        assertTrue(stack.repOkRI1()); 
    }
    @Test
    public void repOk_testMultiplePush() {
        SlimStackRI1 stack = new SlimStackRI1();
        stack.push(5);
        stack.push(6);
        assertTrue(stack.repOkRI1()); 
    }
    @Test(expected = EmptyStackException.class)
    public void repOk_testEmptyStackPop() {
        SlimStackRI1 stack = new SlimStackRI1();
        stack.pop();
    }
    @Test
    public void repOk_testPushPop() {
        SlimStackRI1 stack = new SlimStackRI1();
        stack.push(5);
        stack.pop();
        assertTrue(stack.repOkRI1()); 
    }


}