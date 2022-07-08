package br.com.wildrimak.shows.stategy.first.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum State {

    ALAGOAS(25, 250),
    ANOTHER(40, 450),
    BAHIA(85, 350),
    CEARA(12, 250),
    NATAL(27, 150),
    PARAIBA(33, 50),
    PERNAMBUCO(42, 150),
    SERGIPE(44, 350);

    private int percentageTax;
    private double transportValue;

}
