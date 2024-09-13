## Instructions

Insert appropriate code in all the functions named throwsXYZ() so that the program would output:

    - NullPointerException
    - IOException
    - IndexOutOfBoundsException
    - OutOfMemoryError
    - StackOverflowError
    - NumberFormatException
    - ArithmeticException
    - ClassCastException
    - ConcurrentModificationException

In other words, you need to write code that would induce the above exceptions.

```
public class inClass03B {
	public static void main(String[] args) {
		try {
			throwsNullPointerException();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		} 
		
		try {
			throwsIOException();
		} catch (IOException e) {
			System.out.println("IOException");
		} 
		
		try {
			throwsIndexOutOfBoundsException();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException");
		} 
		
		try {
			throwsOutOfMemoryError();
		} catch (OutOfMemoryError e) {
			System.out.println("OutOfMemoryError");
		} 
		
		try {
			throwsStackOverflowError();
		} catch (StackOverflowError e) {
			System.out.println("StackOverflowError");
		} 
		
		try {
			throwsNumberFormatException();
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		} 
		
		try {
			throwsArithmeticException();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		} 
		
		try {
			throwsClassCastException();
		} catch (ClassCastException e) {
			System.out.println("ClassCastException");
		} 
		
		try {
			throwsConcurrentModificationException();
		} catch (ConcurrentModificationException e) {
			System.out.println("ConcurrentModificationException");
		} 
		
	}
	
	static public void throwsNullPointerException(){
		
	}
	
	static public void throwsIOException()throws IOException {
		
	}
	
	static public void throwsIndexOutOfBoundsException(){
		
	}
	
	static public void throwsOutOfMemoryError(){
		
	}
	
	static public void throwsStackOverflowError(){
		
	}
	
	static public void throwsNumberFormatException(){
		
	}
	
	static public void throwsArithmeticException(){
		
	}
	
	static public void throwsClassCastException(){
		
	}
	
	static public void throwsConcurrentModificationException(){
		
	}	
}
```