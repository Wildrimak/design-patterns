package br.com.wildrimak.shows.chainofresponsability.first.exceptions;

public class IllegalNameException extends RuntimeException {

    public IllegalNameException(String s) {
        super(s);
    }
}
