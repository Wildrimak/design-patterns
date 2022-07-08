package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.OverflowTimeException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

import java.time.temporal.ChronoUnit;

public class ValidateTimeBetweenChangesPremiumUser implements UserHandler{

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public void handler(User user) {

        var diff = ChronoUnit.MINUTES
                .between(user.getCreationDate(), user.getUpdateAt());

        if (user.getRole().equals(Role.PREMIUM)) {
            if (diff >= 20) {
                throw new OverflowTimeException("Change " +
                        "only on the first twenty minutes!");
            }
        }

    }
}
