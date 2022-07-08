package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.AmountOfUpdatesException;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class ValidateAmountOfChangesPremiumUser implements UserHandler{

    private UserHandler next;

    @Override
    public void setNextHandler(UserHandler handler) {
        this.next = handler;
    }

    @Override
    public void handler(User user) {

        if (user.getRole().equals(Role.PREMIUM)) {
            if (user.getAmountUpdates() > 12) {
                throw new AmountOfUpdatesException("Change only" +
                        " 12 times in the first twenty minutes");
            }
        }

        this.next.handler(user);
    }
}
