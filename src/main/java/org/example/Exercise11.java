package org.example;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise11 {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {

            for (int i = 0; i < 3; i++)
                executorService.submit(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Hello World!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        }

    }
}
