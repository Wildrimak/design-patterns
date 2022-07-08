package br.com.wildrimak.shows.chainofresponsability.second.repository;

import br.com.wildrimak.shows.chainofresponsability.second.models.User;

public interface UserRepository {

    User save(User user);
    User update(User user);
    User findById(Long id);

}
