package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Exercise04 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            int randomDelay = ThreadLocalRandom.current().nextInt(6001,8001);
            try {
                Thread.sleep(randomDelay);
                //System.out.print("Hello...");
            }catch (Exception e){
                e.printStackTrace();
            }
            return "Hello...";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            int randomDelay = ThreadLocalRandom.current().nextInt(6001,8001);

            try {
                Thread.sleep(randomDelay);
                //System.out.print("...World!");
            }catch (Exception e){
                e.printStackTrace();
            }

            return "...World!";
        });
        CompletableFuture<String> combined = future1.thenCombine(future2, (string1, string2)-> string1+string2);
        combined.orTimeout(10000, TimeUnit.MILLISECONDS)
                        .thenAccept(System.out::println)
                                .exceptionally(e->{
                                    System.out.println("Operation exceeds 10 seconds");
                                    return null;
                                });
        combined.join();
    }
}
