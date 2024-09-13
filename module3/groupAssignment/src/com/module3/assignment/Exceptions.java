package com.module3.assignment;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Iterator;

public class Exceptions {
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
		String x = null;
        x.length();
	}
	
	static public void throwsIOException()throws IOException {
		FileReader file = new FileReader("file.txt");
	}
	
	static public void throwsIndexOutOfBoundsException(){
		int[] a = new int[3];
        int b = a[4];
	}
	
	static public void throwsOutOfMemoryError(){
		int[] a = new int[100000*100000];
	}
	
	static public void throwsStackOverflowError(){
		// unbounded recursive calling to cause error
        throwsStackOverflowError();
	}
	
	static public void throwsNumberFormatException(){
		String str = "abc";
        int number = Integer.parseInt(str);
	}
	
	static public void throwsArithmeticException(){
		int number = 10;
        int zero = 0;
        int divideByZero = number/zero;
	}
	
	static public void throwsClassCastException(){
		Object number = new Integer(0);
        String badString = (String)number; 
	}
	
	static public void throwsConcurrentModificationException(){
		List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for(String letter : list){
            if(letter.equals("A")){
                list.remove(letter);
            }
        }
	}	
}
