package com.module2;
/** 
 * Participation Scores:
 * Matthew Lauer: 100%
 * Dan Le: 100% 
 * Sophia Nadasy: 100%
 * Sri Teja Kale: 100%
 * Sri Bhuvan Maddipudi: 100%
 * 
  @param principal:  Amount of the initial principal 
  @param rate:       Annual interest rate  (8% rate expressed as rate = 0.08) 
  @param payment:    Amount of the monthly payment 
*/ 
public class Module2GroupAssignmentContract {
    public static int months (int principal, double rate, int payment){
        // Requires: principal, rate, and payment all positive and payment is sufficiently large to drive the principal to zero. 
        // Effects:  return the number of months required to pay off the principal 
        int months = 0;
        double monthlyInterestRate = rate/12.0;
        double oldPrincipal = (double) principal;
        double newPrincipal;
        if (payment <= 0) {
            throw new IllegalArgumentException("Payment must be a positive integer");
        }
        if (payment <= (principal* monthlyInterestRate)) {
            throw new IllegalArgumentException("Payment is not sufficient to ever pay off the loan");
        }
        while (oldPrincipal > 0) {
            newPrincipal = oldPrincipal * (1 + monthlyInterestRate) - payment;
            oldPrincipal = newPrincipal;
            months++;
        }
        return months;
    } 
    public static void main(String[] args) {
        System.out.println(months(100000, 0.08, 1000));
        System.out.println(months(100000, 0.08, 1100));    
    }
}
