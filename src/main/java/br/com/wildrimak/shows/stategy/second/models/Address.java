package br.com.wildrimak.shows.stategy.second.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Address {

    @NonNull
    private State state;
    private String city;
    private String cep;
    private String publicArea;
    private String number;
    private String complement;

}
