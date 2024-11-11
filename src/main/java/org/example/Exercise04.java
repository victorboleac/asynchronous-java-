package org.example;

import java.util.concurrent.CompletableFuture;

public class Exercise04 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello...");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "...World!";
        });
        try{
            String partOne = future1.get();
            String partTwo = future2.get();
            String combined = partOne+partTwo;
            System.out.println(combined);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
