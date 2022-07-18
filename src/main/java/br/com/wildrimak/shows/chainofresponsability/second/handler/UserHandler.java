package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public interface UserHandler {

    void setNextHandler(UserHandler handler);
    boolean handler(User user);
}
