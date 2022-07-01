package br.com.wildrimak.shows.stategy.first.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Client {

    private String name;
    private String cpf;

    @NonNull
    private Address address;

}
