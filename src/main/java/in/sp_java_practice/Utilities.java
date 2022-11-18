package in.sp_java_practice;

import java.util.stream.IntStream;

public class Utilities {
    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static String intToBinaryString(int number){
        return Integer.toBinaryString(number);
    }
}
