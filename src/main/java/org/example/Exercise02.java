package org.example;

import java.util.concurrent.CompletableFuture;

public class Exercise02 {
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->{
            try {
                System.out.print("Hello...");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(2000);
                System.out.print("...World!");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
future2.join();
    }
}
