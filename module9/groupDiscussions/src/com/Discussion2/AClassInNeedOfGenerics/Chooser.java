package com.Discussion2.AClassInNeedOfGenerics;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * First, simply generify by adding a type to the Chooser class. What is the compiler error with this approach?
 * 
 * How can you turn the compiler error into a compiler warning?
 * 
 * Can this warning be suppressed? Should it?
 * 
 * How can you adopt Bloch's advice about arrays and lists to get a typesafe Chooser class without doing anything else that is complicated?
 * 
 * Add rep invariants and contracts (e.g., throw exceptions in unwanted cases); check if code satisfies these; and if not modify code to satisfy them. 
 * This question will take the most time!
 * 
 * Add a addChoice method to the API and write appropriate contracts for it
 * 
 * 
 */

// Chooser - a class badly in need of generics!
// Bloch 3rd edition, Chapter 5, Item 28:  Prefer lists to arrays
public class Chooser {
        private final Object[] choiceArray;

    public Chooser (Collection choices) { //Generic goes here lol
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray [rnd.nextInt(choiceArray.length)];
    }

    public void addChoice(Object choice) { // Haven't learned this yet, brb
        choiceArray[choiceArray.length] = choice;
    }
}
