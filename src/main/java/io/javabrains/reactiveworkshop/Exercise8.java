package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens

        //following are two ways to achieve this
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(
//                        val -> System.out.println(val),
//                        err -> System.err.println(err.getMessage())
//                );

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(System.err::println)
//                .subscribe(
//                        val -> System.out.println(val),
//                        err -> System.out.println(err.getMessage())
//                );

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, errCausedBy) -> System.err.println(err.getMessage()))
                // errCausedBy argument will have the element that caused the error
                .onErrorContinue((err, errCausedBy) -> System.err.println("item: " + errCausedBy + " -> " + err.getMessage()))
                .log()
                .subscribe(
                        val -> System.out.println(val),
                        err -> System.out.println(err.getMessage())
                );

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(System.err::println)
//                .onErrorResume(err -> Flux.just(-1, -2))
//                .log()
//                .subscribe(
//                        val -> System.out.println(val),
//                        err -> System.out.println(err.getMessage())
//                );

        System.out.println("Press a key to end");
        System.in.read();
    }

}
