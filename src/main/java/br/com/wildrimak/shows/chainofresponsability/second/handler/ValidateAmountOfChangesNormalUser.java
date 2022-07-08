package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.AmountOfUpdatesException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class ValidateAmountOfChangesNormalUser implements UserHandler{

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public void handler(User user) {

        if (user.getRole().equals(Role.NORMAL)) {
            if (user.getAmountUpdates() > 3) {
                throw new AmountOfUpdatesException("Change only" +
                        " 3 times in the first five minutes");
            }
        }

        this.next.handler(user);
    }
}
