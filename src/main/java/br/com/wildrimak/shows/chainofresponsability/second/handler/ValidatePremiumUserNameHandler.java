package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.IllegalNameException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;


public class ValidatePremiumUserNameHandler implements UserHandler {

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public void handler(User user) {
        if (user.getRole() == Role.PREMIUM) {
            if (user.getName().length() > 40) {
                throw new IllegalNameException("Only " +
                        "users premium could have more than 40 characters");
            }
        }

        next.handler(user);

    }
}
