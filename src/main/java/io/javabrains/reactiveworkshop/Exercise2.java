package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(num -> System.out.println(num));

        // Print all users in the ReactiveSources.userFlux stream
//        ReactiveSources.userFlux()
//                .subscribe(user -> System.out.println(user));

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
//        Flux<Integer> flux = ReactiveSources.intNumbersFlux();
//        flux.subscribe(System.out::println);
//        TimeUnit.SECONDS.sleep(4);
//        flux.subscribe(num -> System.out.println("another print " + num));


        System.out.println("Press a key to end");
        //the following read operaiton is to wait the code from exiting and provide time for flux data to complete processing
        //this blocking statement is for this demo purpose only.
        System.in.read();
    }

}
