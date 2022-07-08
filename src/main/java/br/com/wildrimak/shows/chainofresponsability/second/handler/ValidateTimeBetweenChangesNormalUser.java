package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.OverflowTimeException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

import java.time.temporal.ChronoUnit;

public class ValidateTimeBetweenChangesNormalUser implements UserHandler{

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
            this.next = handler;
    }

    @Override
    public void handler(User user) {
        var diff = ChronoUnit.MINUTES
                .between(user.getCreationDate(), user.getUpdateAt());

        if (user.getRole().equals(Role.NORMAL)) {
            if (diff >= 5) {
                throw new OverflowTimeException("Change " +
                        "only on the first five minutes!");
            }
        }

        this.next.handler(user);

    }
}
