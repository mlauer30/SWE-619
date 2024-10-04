/*
 * Liskov's Poly class, as typed in out of her text
 * A typical Poly is c0 + c1 x + c2 x^2 + ...
 ** c0 : integers 
 * deg: non-neg int 
 * 1 variable ..   (3*x*y not allowed) 
 *
 *
 * (deg=2, terms=[5,0,3])  ->   5+3*x^2
 * (deg=2, terms=[5,0,3,0,0,0,0...]  -> 5+3*x^2+0*x^3:  is not allowed in this implementation
 */
 
package com.PolyLiskov;

public class Poly { // Immutable  (final??)
    private int[] trms;
    private int deg;

    // Effects: Initializes this to be the zero polynomial
    public Poly() {	// Creator
       trms = new int[1]; trms[0] = 0;
       deg = 0;
    }

    // Effects: If n < 0 throws IllegalArgumentException
    // else initializes this to be the polynomial c*x^n
    public Poly(int c, int n) throws IllegalArgumentException { // Creator
       if (n < 0) {
          throw new IllegalArgumentException("Poly(int, int) constructor");
       }
       if (c == 0) {
          trms = new int[1]; trms[0] = 0;
          deg = 0;
          return;
       }
       trms = new int[n+1];
       for (int i=0; i < n; i++) {
          trms[i] = 0;
       }
       trms[n] = c;
       deg = n;
    }

    private Poly (int n) {	// Creator
       trms = new int[n+1];
       deg = n;
    }

	// Effects: Returns the degree of this , i.e., the largest exponent
    // with a non-zero coefficient. Returns 0 if this is the zero Poly.
    public int degree() {	// Observer
       return deg;
    }

    // @throws IAE if d < 0
    // Effects: returns the coefficent of the term of this whose exponent is d
    public int coeff(int d) {	// Observer
       if (d < 0) throw new IllegalArgumentException();
       return (d > deg) ? 0 : trms[d];
    }

    // Effects: If q is null throw NullPointerException
    // else return the Poly "this - q"
    public Poly sub(Poly q) throws NullPointerException { // Producer
       return add(q.minus());
    }

    // Effects: return the Poly "-this"
    public Poly minus() {	// Producer
       Poly r = new Poly(deg); 
       for (int i=0; i <= deg; i++) {
          r.trms[i] = -trms[i];
       }
       return r;
    }

    // Effects: If q is null throw NullPointerException
    // else return the Poly "this + q"
    public Poly add(Poly q) {	// Producer (Note: does not allow trailing zeros)
       Poly la, sm;
       if (deg > q.deg) {
          la = this; sm = q;
       }
       else {
          la = q; sm = this;
       }
       int newdeg = la.deg; // newdeg is the larger degree
       if (deg == q.deg) {  // takes care of trailing zeros (but only if (deg == q.deg)?!)
          for (int k = deg; k > 0; k--) {
             if (trms[k] + q.trms[k] != 0) {
                break;
             }
             else {
                newdeg--;
             }
          }
       }
       Poly r = new Poly(newdeg); // get a new Poly
       int i;
       for (i = 0; i <= sm.deg && i <= newdeg; i++) { // overlaps
	   
           r.trms[i] = sm.trms[i] + la.trms[i];
       }
       for (int j = i; j <= newdeg; j++) {
          r.trms[j] = la.trms[j];
       }
       return r;
    }

/*
    // Effects: If q is null throw NullPointerException
    // else return the Poly "this * q"
    public Poly mul(Poly q) throws NullPointerException { // Producer

       if ((q.deg == 0 && q.trms[0] == 0) || (deg == 0 && trms[0] == 0)) {
          return new Poly();
       }

       Poly r = new Poly(deg + q.deg);
       r.trms[deg + q.deg] = 0; // prepare to compute coeffs
       for (int i = 0; i <= deg; i++) {
          for (int j = 0; j <= q.deg; j++) {
             r.trms[i+j] += trms[i]*q.trms[j];
          }
       }
       return r;
    }
*/
    public String toString() {
       String r = "Poly:";

       if (deg == 0 || trms[0] != 0) {
           r += " " + trms[0];
       }

       for (int i = 1; i <= deg; i++) {
          if (trms[i] < 0) {
             r += " - " + -trms[i] + "x^" + i;
          }
          else if (trms[i] > 0) {
             r += " + " +  trms[i] + "x^" + i;
          }
       }
       return r;
    }
}
