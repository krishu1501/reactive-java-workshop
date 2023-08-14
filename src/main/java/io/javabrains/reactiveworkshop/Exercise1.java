package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("task 1 -> ");
        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        System.out.println("task 2 -> ");
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(System.out::println);

        System.out.println("task 3 -> ");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(num -> num > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("task 4 -> ");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(StreamSources.intNumbersStream().filter(num -> num > 5).findFirst().orElse(-1));

        System.out.println("task 5 -> ");
        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("task 6 -> ");
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(num -> num == user.getId())).forEach(user -> System.out.println(user.getFirstName()));

    }

}
