package org.example;

import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(2000);
                System.out.println("Hello World!");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        future.join();
    }
}