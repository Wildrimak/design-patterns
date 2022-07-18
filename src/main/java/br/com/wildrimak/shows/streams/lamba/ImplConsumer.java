package br.com.wildrimak.shows.streams.lamba;

import java.util.function.Consumer;

public class ImplConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }

    @Override
    public Consumer<Integer> andThen(Consumer<? super Integer> after) {
        return Consumer.super.andThen(after);
    }
}
