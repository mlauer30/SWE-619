import java.util.ArrayList;
import java.util.List;

public class Discussion1_IdentifyingIssues {
    public static void main(String[] args) {
        
        // Given the following variable declarations, independently consider the given 6 sequences of Java instructions.
        String string = "bat";
        Integer x = 7;
        Object[] objects;
        List rawList; // Needs generics
        List<Object> objectList;
        List<String> stringList;

        // Identify any code that results in a compiler error or warning. Identify any code that raises a runtime exception. 
        // Once a compiler error is noted, you do not need to analyze the sequence further.
        
        // Question #1
        // Errors
        // objects = new String[1];
        // objects[0] = string;
        // objects[0] = x;
        
        // Question #2
        objects = new Object[1];
        objects[0] = string;
        objects[0] = x;

        // Question #3
        stringList = new ArrayList<String>();
        stringList.add(string);

        // Question #4
        // Errors
        // objectList = new ArrayList<String>();
        // objectList.add(string);

        // Question #5
        objectList = new ArrayList<Object>();
        objectList.add(string);
        objectList.add(x);
        
        // Question #6
        // Needs Generics
        rawList = new ArrayList();
        rawList.add(string);
        rawList.add(x);

    }
}
