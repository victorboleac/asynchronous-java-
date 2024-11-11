package org.example;

import java.util.concurrent.CompletableFuture;

public class Exercise03 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(3000);
                //System.out.print("Hello...");
            }catch (Exception e){
                e.printStackTrace();
            }
            return "Hello...";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(5000);
                //System.out.print("...World!");
            }catch (Exception e){
                e.printStackTrace();
            }
            return "...World!";
        });
        CompletableFuture<String> combined = future1.thenCombine(future2, (string1, string2)-> string1+string2);
        combined.thenAccept(System.out::println);
        combined.join();
    }
}
