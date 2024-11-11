package org.example;
import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class Exercise08 {
    public static Function<String, String> editMessage = combinedResult -> {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Exception occurred during async operation");
        }
        return combinedResult.replaceAll("\\.", "") + " 👋🌍👋";
    };
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
        combined.thenCompose(output->CompletableFuture.supplyAsync(()-> editMessage.apply(output)))
                .exceptionally(e->{
                    System.out.println(e.getMessage().toUpperCase()+"\n");
                    return "Hello World!";
                })
                .thenAccept(System.out::println)
                .join();
    }
}
