package br.com.wildrimak.shows.chainofresponsability.second.repository;

import br.com.wildrimak.shows.chainofresponsability.second.models.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static final Set<User> users = new HashSet<>();
    private static long amount = 0L;

    @Override
    public User save(User user) {
        amount++;
        user.setId(amount);
        users.add(user);
        return user;
    }

    @Override
    public User update(User updateUser) {
        var savedUser = findById(updateUser.getId());
        users.remove(savedUser);
        users.add(updateUser);
        return updateUser;
    }

    @Override
    public User findById(Long id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id not found"))
                ;
    }
}
