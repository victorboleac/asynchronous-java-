package org.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Exercise09 {
    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";

        List<BigInteger> numbers = Arrays.stream(data.split(" "))
                .map(BigInteger:: new)
                .toList();
        CompletableFuture.supplyAsync(()->numbers.stream()
                .map(Exercise09::calculateFactorial)
                .collect(Collectors.toList()))
                .thenAccept(result -> result.forEach(System.out::println))
                .join();
    }
}
