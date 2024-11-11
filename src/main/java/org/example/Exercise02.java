package org.example;

import java.util.concurrent.CompletableFuture;

public class Exercise02 {
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(3000);
                System.out.print("Hello...");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(5000);
                System.out.print("...World!");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture.allOf(future1, future2).join();
    }
}
