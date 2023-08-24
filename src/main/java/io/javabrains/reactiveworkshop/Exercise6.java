package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        String value;
//        value = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

//        the following does work
//        value = ReactiveSources.stringMono().block(Duration.ofSeconds(5));
//        System.out.println(value);

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        List<String> values = ReactiveSources.unresponsiveFlux()
                .collectList()
                .block(Duration.ofSeconds(5));

        System.out.println("Press a key to end");
//        System.in.read();
    }

}
