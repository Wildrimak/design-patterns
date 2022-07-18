package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class ValidateNormalUserNameHandler implements UserHandler {

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean handler(User user) {

        if (user.getRole() == Role.NORMAL &&
                user.getName().length() > 10) {
            return false;
        }

        if (next != null) {
            return this.next.handler(user);
        }

        return true;

    }
}
