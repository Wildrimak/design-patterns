package br.com.wildrimak.shows.streams.lamba;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * SAM -> Single Abstract Method
 * */

public class MainLambda {

    public static void main(String[] args) {

        var numbers = Arrays.asList(1, 2, 3, 4);
        numbers.forEach(e -> System.out.println(e));

        Consumer<Integer> consumer = new ImplConsumer();
        numbers.forEach(consumer);

        var newNumbers = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        newNumbers.forEach(n -> System.out.println(n));

        Predicate<Integer> predicate = new ImplPredicate();

        var newNewNumbers = numbers.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        newNewNumbers.forEach(n -> System.out.println(n));

    }

}
