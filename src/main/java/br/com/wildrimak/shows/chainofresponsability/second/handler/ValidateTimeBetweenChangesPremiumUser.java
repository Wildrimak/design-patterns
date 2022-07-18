package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

import java.time.temporal.ChronoUnit;

public class ValidateTimeBetweenChangesPremiumUser implements UserHandler {

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean handler(User user) {

        var diff = ChronoUnit.MINUTES
                .between(user.getCreationDate(), user.getUpdateAt());

        if (user.getRole().equals(Role.PREMIUM) &&
                diff >= 20) {
            return false;
        }

        if (next != null) {
            return this.next.handler(user);
        }

        return true;

    }
}
