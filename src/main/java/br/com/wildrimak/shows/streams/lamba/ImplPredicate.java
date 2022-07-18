package br.com.wildrimak.shows.streams.lamba;

import java.util.function.Predicate;

public class ImplPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }

}
