package br.com.wildrimak.shows.stategy.second.models.strategy;

import br.com.wildrimak.shows.stategy.second.models.StateStrategy;

public class PernambucoState implements StateStrategy {

    private double originalValue;
    private final int percentageTax = 42;
    private final double transportValue = 150;

    public PernambucoState(double originalValue) {
        this.originalValue = originalValue;
    }

    @Override
    public double execute() {
        final double profit = percentageTax / 4;
        final double multiply = (100 + profit) / 100;
        final double valueWithProfit = (this.originalValue + transportValue) * multiply;
        return (100 * valueWithProfit) / (100 - percentageTax);
    }

}
