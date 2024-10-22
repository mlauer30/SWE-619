package com.Discussion2.AClassInNeedOfGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * First, simply generify by adding a type to the Chooser class. What is the compiler error with this approach?
 * error: incompatible types: Object[] cannot be converted to T[]
 * 
 * How can you turn the compiler error into a compiler warning?
 * By casting choiceArray = (T[])choices.toArray() to result in an unchecked cast, required: T[], found: Object[]
 * 
 * Can this warning be suppressed? Should it?
 * Yes, it can be suppressed with the annotation @SuppressWarnings("unchecked"), but we're better off eliminating the cause of the warning by using Lists instead of Arrays.
 * 
 * How can you adopt Bloch's advice about arrays and lists to get a typesafe Chooser class without doing anything else that is complicated?
 * Substitute the array collection for a list. Bloch states that this is the least complex solution that substitutes an array for a generic. 
 * He states that the solution is invariant and erased as opposed to being covariant and reified.
 * 
 * Add rep invariants and contracts (e.g., throw exceptions in unwanted cases); check if code satisfies these; and if not modify code to satisfy them. 
 * This question will take the most time!
 * 
 * For the rep invariant we made it so that class must not be instantiated with a null list. 
 * rep invariant: choiceList != NULL && choices.size > 0
 * The Chooser method was not checking for the rep invariant, so we added an exception to here that throws an IllegalAccessError and
 * also checks that the explicit rep invariant is satisified by also throwing a NullPointerException in the case scenario the choices are null.
 * The other methods were modified to check for the rep invariant in the same way.
 * 
 * Add a addChoice method to the API and write appropriate contracts for it
 * add choice was created to further populate the choiceList
 * 
 */

// Chooser - a class badly in need of generics!
// Bloch 3rd edition, Chapter 5, Item 28:  Prefer lists to arrays
public class Chooser<T> {
    private final List<T> choiceList;

    // rep invariant: choiceList != NULL && choices.size > 0
    public boolean repOk() {
        return choiceList != null & !choiceList.isEmpty();
    }

    /**
     * EFFECTS: choiceList contains a copy of the elements from choices
     * @param choices choices collection
     * @throws IllegalAccessError if collection of choices is empty
     * @throws NullPointerException if choices is NULL
     */
    public Chooser (Collection<T> choices) {
        if (choices == null) throw new NullPointerException();
        if (choices.size() == 0) throw new IllegalAccessError();
        choiceList = new ArrayList<>(choices);
    }

     /**
      * REQUIRES: choiceList has at least one element
      * EFFECTS: returns a random element from choiceList
      */
    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
    
    /**
     * REQUIRES: choice is not NULL
     * EFFECTS: the choice is added to choiceList
     * @param choice the element to be added to choiceList
     * @throws IllegalArgumentException if choice is NULL
     */
    public void addChoice(T choice) { 
        if (choice == null) throw new IllegalArgumentException("choice can't be empty");
        choiceList.add(choice);
    }
}
