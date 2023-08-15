package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.userMono().subscribe(
//                user -> System.out.println(user),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("UserMono complete")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {


    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value);
        request(1);
    }

//    private boolean flag = true;

//    @Override
//    protected void hookOnNext(T value) {
//        System.out.println(value);
//        if (flag) {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            flag = false;
//        }
//        request(5);
//    }
}