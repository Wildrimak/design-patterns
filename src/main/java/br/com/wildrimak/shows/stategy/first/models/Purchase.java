package br.com.wildrimak.shows.stategy.first.models;

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

    public double getSaleValue() {

        final var state = client.getAddress().getState();
        final double tax = state.getPercentageTax();

        if (state.equals(State.ALAGOAS)) {

            final double profit = tax / 2;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.ANOTHER)) {

            final double profit = tax / 3;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.BAHIA)) {

            final double profit = tax / 4;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.CEARA)) {

            final double profit = tax / 1.5;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.NATAL)) {

            final double profit = tax / 4;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.PARAIBA)) {

            final double profit = tax / 5;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else if (state.equals(State.PERNAMBUCO)) {

            final double profit = tax / 4;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        } else {

            final double profit = tax / 2.5;
            final double multiply = (100 + profit) / 100;
            final double valueWithProfit = this.originalValue * multiply;
            return (100 * valueWithProfit) / (100 - tax);

        }

    }
}
