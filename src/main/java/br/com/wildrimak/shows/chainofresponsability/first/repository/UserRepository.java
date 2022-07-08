package br.com.wildrimak.shows.chainofresponsability.first.repository;

import br.com.wildrimak.shows.chainofresponsability.first.models.User;

public interface UserRepository {

    User save(User user);
    User update(User user);
    User findById(Long id);

}
