package RSA;

import java.math.BigInteger;
import java.util.Random;

public class RandomNumber {

    private int minBitSize;
    private int maxBitSize;


    public RandomNumber(int maxBitSize) {
        this.minBitSize = maxBitSize;
        this.maxBitSize = maxBitSize;
    }

    public RandomNumber(int minBitSize, int maxBitSize) {
        this.minBitSize = minBitSize;
        this.maxBitSize = maxBitSize;
    }

    public BigInteger genRandNumb() throws IllegalArgumentException {
        if (maxBitSize >= minBitSize) {
            int bitSize = minBitSize;
            if (minBitSize != maxBitSize) {
                bitSize = new Random().nextInt(maxBitSize - minBitSize) + minBitSize;
            }
            return new BigInteger(bitSize, new Random());
        }
        throw new IllegalArgumentException("maxBitSize need to be greater than or equal minBitSize");
    }

    public static void main(String[] args) {
        RandomNumber generator = new RandomNumber(1024, 2048);
        BigInteger a = generator.genRandNumb();
        BigInteger b = generator.genRandNumb();
        System.out.println(a.bitLength());
        System.out.println(b.bitLength());
    }


}
