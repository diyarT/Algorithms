package RSA;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.math.BigInteger.*;

/**
 * Inspiration: https://www.geeksforgeeks.org/how-to-generate-large-prime-numbers-for-rsa-algorithm/
 */
public class PrimeNumber {

    private int[] firstPrimes = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157,
            163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
            251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347,
            349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
            443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
    };


    public boolean lowLevelPrimeTest(BigInteger candidate) {
        for (int i = 0; i < firstPrimes.length; i++) {
            BigInteger prime = valueOf(firstPrimes[i]);
            if (candidate.mod(prime).equals(ZERO) &&
                    (prime.pow(2).compareTo(candidate) == -1 || prime.pow(2).compareTo(candidate) == 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean higherLevelPrimeTest(BigInteger candidate) {
        BigInteger testingNum = new RandomNumber(20, 20).genRandNumb();
        int counter = 0;
        while (testingNum.compareTo(candidate.subtract(valueOf(2))) != -1 || testingNum.compareTo(valueOf(2)) == -1) {
            System.out.println((counter++) + " " + testingNum.toString());
            testingNum = new RandomNumber(20, 20).genRandNumb();
        }
        System.out.println(testingNum.toString());

        BigInteger evenPart = candidate.subtract(valueOf(1));
        int exponent = 0;
        while (evenPart.mod(valueOf(2)).equals(ZERO)) {
            evenPart = evenPart.divide(valueOf(2));
            exponent += 1;
        }


        return true;
    }

    public static void main(String[] args) {
        BigInteger number = new RandomNumber(20, 20).genRandNumb();
        PrimeNumber primeNumber = new PrimeNumber();
        BigInteger prime = null;
        int counter = 0;
        while (prime == null) {
            System.out.println(counter++);
            if (primeNumber.lowLevelPrimeTest(number)) {
                System.out.println(number.toString());
                if (primeNumber.higherLevelPrimeTest(number)) {
                    prime = number;
                }
            } else number = new RandomNumber(20, 20).genRandNumb();
        }


    }


}
