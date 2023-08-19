package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class practice {
    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("Started");
        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        integerFlux.subscribe(num -> {
            int funNum = 1;
            System.out.println(num);
        });

        TimeUnit.SECONDS.sleep(5);
        integerFlux.subscribe(num -> {
            int funNum = 2;
            System.out.println(num);
        });
        TimeUnit.SECONDS.sleep(3);
//        TimeUnit.SECONDS.sleep(14);
//        integerFlux.toStream().forEach(System.out::println);
        System.out.println("Enter any character to end");
        for (long i = 0; i < 10000000000L; i++) ;
        for (long i = 0; i < 30000000000L; i++) ;
//        System.in.read();

    }
}
