package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class ValidateAmountOfChangesNormalUser implements UserHandler {

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public boolean handler(User user) {

        if (user.getRole().equals(Role.NORMAL) &&
                user.getAmountUpdates() > 3) {
            return false;
        }

        if (next != null) {
            return this.next.handler(user);
        }

        return true;
    }
}
