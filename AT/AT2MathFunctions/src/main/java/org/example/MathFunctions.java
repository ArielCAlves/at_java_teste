package org.example;

import java.util.Arrays;

public class MathFunctions {

    private final MathLogger logger;

    public MathFunctions(MathLogger logger) {
        this.logger = logger;
    }

    // se fosse usar o logger (faria o mesmo para os outros métodos)
//    public int MultiplyByTwo(int number) {
//        logger.log("MultiplyByTwo", new int[]{number});
//        return number * 2;
//    }

    public static int MultiplyByTwo(int number) {
        return number * 2;
    }

    public static int[] GenerateMultiplicationTable(int number, int limit) {
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = number * (i + 1);
        }
        return result;
    }

    public static boolean IsPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static double CalculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("Array cannot be null or empty.");
        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
