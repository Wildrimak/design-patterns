package br.com.wildrimak.shows.stategy.second;

import br.com.wildrimak.shows.stategy.second.models.Address;
import br.com.wildrimak.shows.stategy.second.models.Client;
import br.com.wildrimak.shows.stategy.second.models.Purchase;
import br.com.wildrimak.shows.stategy.second.models.State;
import br.com.wildrimak.shows.stategy.second.models.strategy.AnotherState;

public class MainStrategySecond {

    public static void main(String[] args) {

        Purchase purchase1 = Purchase.builder()
                .productName("Notebook")
                .originalValue(3000)
                .client(Client.builder()
                        .name("Wildrimak")
                        .address(Address.builder()
                                .state(State.ANOTHER)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(3000))
                .build();

        Purchase purchase2 = Purchase.builder()
                .productName("Iphone 12 Max")
                .originalValue(12000)
                .client(Client.builder()
                        .name("Marcos")
                        .address(Address.builder()
                                .state(State.ANOTHER)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(12000))
                .build();

        Purchase purchase3 = Purchase.builder()
                .productName("Tablet")
                .originalValue(6000)
                .client(Client.builder()
                        .name("Jean")
                        .address(Address.builder()
                                .state(State.ANOTHER)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(6000))
                .build();

        Purchase purchase4 = Purchase.builder()
                .productName("Notebook")
                .originalValue(3000)
                .client(Client.builder()
                        .name("Wildrimak")
                        .address(Address.builder()
                                .state(State.CEARA)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(3000))
                .build();

        Purchase purchase5 = Purchase.builder()
                .productName("Iphone 12 Max")
                .originalValue(12000)
                .client(Client.builder()
                        .name("Marcos")
                        .address(Address.builder()
                                .state(State.CEARA)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(12000))
                .build();

        Purchase purchase6 = Purchase.builder()
                .productName("Tablet")
                .originalValue(6000)
                .client(Client.builder()
                        .name("Jean")
                        .address(Address.builder()
                                .state(State.CEARA)
                                .build())
                        .build())
                .stateStrategy(new AnotherState(6000))
                .build();

        System.out.println(purchase1.getSaleValue());
        System.out.println(purchase2.getSaleValue());
        System.out.println(purchase3.getSaleValue());
        System.out.println(purchase4.getSaleValue());
        System.out.println(purchase5.getSaleValue());
        System.out.println(purchase6.getSaleValue());

    }
}
