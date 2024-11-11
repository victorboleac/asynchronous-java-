package org.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Exercise10 {
    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
        String story = "Mary had a little lamb, its fleece was white as snow. Mary had a little lamb, its fleece was white as snow.";

        List<BigInteger> numbers = Arrays.stream(data.split(" "))
                .map(BigInteger:: new)
                .toList();
        CompletableFuture<Void> factorial =  CompletableFuture.supplyAsync(()->numbers.stream()
                        .map(Exercise10::calculateFactorial)
                        .collect(Collectors.toList()))
                .thenAccept(result -> result.forEach(System.out::println));

        CompletableFuture<Void> storyPrinter = CompletableFuture.runAsync(()->{
            String[] words = story.split(" ");
            for (String word: words){
                System.out.println(word);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                    System.err.println("Interrupted");
                }
            }
        });
        CompletableFuture.allOf(factorial, storyPrinter).join();
    }
}
