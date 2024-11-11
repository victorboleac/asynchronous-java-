package org.example;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Exercise07 {
    public static Function<String, String> composition = editMessage -> editMessage.replaceAll("\\.", "") + " 👋🌍👋";

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello...");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "... World!";
        });
        CompletableFuture<String> combined = future1.thenCombine(future2,(s1, s2)->s1+s2);
        combined.thenCompose(output->CompletableFuture.supplyAsync(()-> composition.apply(output)))
                .thenAccept(System.out::println)
                .join();
    }
}
