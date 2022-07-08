package br.com.wildrimak.shows.chainofresponsability.first.exceptions;

public class OverflowTimeException extends RuntimeException {

    public OverflowTimeException(String s) {
        super(s);
    }
}
