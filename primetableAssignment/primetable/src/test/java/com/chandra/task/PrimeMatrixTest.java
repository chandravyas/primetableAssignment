package com.chandra.task;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test to test PrimeMatrix File
 */
public class PrimeMatrixTest
{

    /**
     * checks weather the characters are repeated correctly as per the length provided
     */
    @Test
    public void repeatTest() {
        assertEquals(PrimeMatrix.repeat(3, ' '),"   ");
        assertEquals(PrimeMatrix.repeat(4, 'a'),"aaaa");

    }

    /**
     * Does padding test for our input length
     */
    @Test
public void paddingTest() {
    assertEquals(PrimeMatrix.span(5, 1).length(), "5".length());
    assertEquals(PrimeMatrix.span(5, 2).length(), "5 ".length());
    assertEquals(PrimeMatrix.span(5, 3).length(), "5  ".length());
    assertEquals(PrimeMatrix.span(5, 4).length(), "5   ".length());
    assertEquals(PrimeMatrix.span(5, 5).length(), "5    ".length());
}


    /**
     * Checks weather different numbers are prime or not
     */
    @Test
    public void checkPrimeTest() {

        assertEquals(PrimeMatrix.isPrime(0),false);
        assertEquals(PrimeMatrix.isPrime(1),false);
        assertEquals(PrimeMatrix.isPrime(2),true);
        assertEquals(PrimeMatrix.isPrime(-2),true);
        assertEquals(PrimeMatrix.isPrime(100),false);
        assertEquals(PrimeMatrix.isPrime(-100),false);


    }

    /**
     * Checks weather correct number of primes are generated as per the given input n
     */

    @Test
    public void primeCountCheckTest() {
        int[] primes = PrimeMatrix.getNPrimes(5);
        assertEquals(primes.length,5);

        primes = PrimeMatrix.getNPrimes(0);
        assertEquals(primes.length,0);

    }

    /**
     * Checks weather the primegeneration function generates the correct primes by comparing the generated primes with precalculated prime list
     */

    @Test
    public void primeGenerationTest() {
        List<Integer> expected = new ArrayList<>();
        Scanner scanner = new Scanner(PrimeMatrixTest.class.getResourceAsStream("/precalculatedprimes.txt"));
        while (scanner.hasNextInt()) {
            final int i = scanner.nextInt();
            expected.add(i);
        }

        int[] calculatedPrimes = PrimeMatrix.getNPrimes(expected.size());
        List<Integer> actual =  new ArrayList<>();
        for(int i: calculatedPrimes)
        {
            actual.add(i);
        }
        assertEquals(expected, actual);
    }


}
