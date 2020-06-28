/* Prime Solution */
/** This class tests the code for Lab2: Exercise1.
 * It calls a method to calculate the nth prime and prints information about running time.
 * It expands upon a framework provided by Srini. */

import java.util.*;

public class Prime {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // execution time calculation variables
        long startTime, endTime, executionTime;

        long p = kb.nextLong(); // p is the order of the prime number
        while(p != 0){ // while input not 0
            startTime = System.currentTimeMillis(); // start timer
            System.out.print(p+" "+nthPrime(p));
            endTime = System.currentTimeMillis(); // end timer
            executionTime = endTime - startTime;
            System.out.println(" "+executionTime);
            p = kb.nextLong();
        }

    }

    // method to calculate nthPrime
    public static long nthPrime(long p) {
        // currNum is used to check if a number is prime or not; it starts with value 2
        long currNum = 2;
        // currPrime is used to store the most recent prime number in the sequence
        long currPrime = 0;
        boolean isPrime = true; // isPrime is true if a number is prime and vise-versa
        int primeCount = 0; // stores the number of prime numbers found so far
        long divisor; // divides the currNum to check if it's a prime

        // while the pth term has not reached
        while(primeCount < p) {
            divisor = 2;
            // square root of currNum is used for optimization because it is the highest possible factor
            while (divisor <= Math.sqrt(currNum)) {
                if (currNum % divisor == 0) { // if perfectly divisible
                    isPrime = false;
                    break;
                }
                divisor++;
            }
            if(isPrime) { // if prime
                primeCount++;
                currPrime = currNum;
            }
            currNum++;
            isPrime = true; // reset
        }

        return currPrime;
    }
}