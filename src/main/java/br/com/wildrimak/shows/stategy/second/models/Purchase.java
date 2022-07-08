package br.com.wildrimak.shows.stategy.second.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.OffsetDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Purchase {

    private Long id;

    @NonNull
    private String productName;

    @NonNull
    private double originalValue;

    private OffsetDateTime when;

    @NonNull
    private Client client;

    private boolean sold;

    @NonNull
    private StateStrategy stateStrategy;

    public double getSaleValue() {
        return this.stateStrategy.execute();
    }

    public void setStateStrategy(StateStrategy stateStrategy) {
        this.stateStrategy = stateStrategy;
    }
}
