package org.example;

import java.util.concurrent.CompletableFuture;

public class Exercise03 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello...");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "...World";
        });
        CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1+s2);
        combined.thenAccept(System.out::println);
        combined.join();
    }
}
