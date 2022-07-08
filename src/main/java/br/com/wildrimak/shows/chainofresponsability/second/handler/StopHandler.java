package br.com.wildrimak.shows.chainofresponsability.second.handler;

import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public class StopHandler implements UserHandler{

    @Override
    public void setNextHandler(UserHandler handler) {
    }

    @Override
    public void handler(User user) {
    }
}
