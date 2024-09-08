package com.module2;
// import java.util.List;
// import java.util.ArrayList;
/**
 * Participation Scores:
 * Matthew Lauer: 100%
 * Dan Le: 100% 
 * Sophia Nadasy: 100%
 * Sri Teja Kale: 100%
 * Sri Bhuvan Maddipudi: 100%
 */
public class Module2GroupAssignmentProgramSpecifications {
    
    private static boolean isPrime(int x) {
        for (int i = 2; i < Math.sqrt(x); i++) {
            if ((x % i) == 0) {
                return false;
            }
        }
        return true;
    }
    public static int find_Prime_Factor(int[] listA, int[] listB) {
    /*    
        Requires: a not None; b not None;
        there is some index i where b[i] is 
        both prime and a factor of a[i]

        Effects: return the least index
        at which b[i] is a prime factor of a[i]
        E.g. find_prime_factor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
        (Note: 6 is a factor of 12, but is not prime,
        and 2 is prime, but is not a factor of 25.  However,
        3 is a prime factor of 18. Hence, index "2" is the correct
        answer.  index "3" is not a possible answer, because the
        third index is not the least index with the desired property.)
        Also note that listA and listB need not be of the same length.
     
     */

        if (listA.length < listB.length) {
            for (int i = 0; i < listA.length; i++) {         
                if ((listA[i] % listB[i] == 0) && isPrime(listB[i])){ 
                    return i;                 
                }                 
            }     
        }else{     
            for (int i = 0; i < listB.length; i++) {         
                if ((listA[i] % listB[i] == 0) && isPrime(listB[i])){             
                    return i;             
                }     
            }   
        }     
        return -1; 

    }
    public static void main(String[] args) {      

        int[] A = {18,25,18,8};
        int[] B = {6,2,3,2};
        // int[] A = {};
        // int[] B = {};
        System.out.println(find_Prime_Factor(A, B));
    }
}