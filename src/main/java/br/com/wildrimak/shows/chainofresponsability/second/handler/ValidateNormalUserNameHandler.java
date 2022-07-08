package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.IllegalNameException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class ValidateNormalUserNameHandler implements UserHandler {

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public void handler(User user) {
        if (user.getRole() == Role.NORMAL) {
            if (user.getName().length() > 10) {
                throw new IllegalNameException("Only " +
                        "users premium could have more than 10 characters");
            }
        }
        next.handler(user);

    }
}
