package br.com.wildrimak.shows.chainofresponsability.first.service;

import br.com.wildrimak.shows.chainofresponsability.first.exceptions.AmountOfUpdatesException;
import br.com.wildrimak.shows.chainofresponsability.first.exceptions.IllegalNameException;
import br.com.wildrimak.shows.chainofresponsability.first.exceptions.OverflowTimeException;
import br.com.wildrimak.shows.chainofresponsability.first.models.Role;
import br.com.wildrimak.shows.chainofresponsability.first.models.User;
import br.com.wildrimak.shows.chainofresponsability.first.repository.UserRepository;
import br.com.wildrimak.shows.chainofresponsability.first.repository.UserRepositoryImpl;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
    }

    public User create(String name, Role role) {
        User user = new User(name, role);
        validateName(user);
        return this.userRepository.save(user);
    }

    public User update(Long id, String name) {
        var userSaved = this.userRepository.findById(id);
        var updateUser = new User(name, userSaved.getRole());
        updateUser.setId(userSaved.getId());
        updateUser.setCreationDate(userSaved.getCreationDate());
        updateUser.setUpdateAt(OffsetDateTime.now());
        updateUser.setRole(userSaved.getRole());
        updateUser.setAmountUpdates(userSaved.getAmountUpdates() + 1);

        validateUpdateUser(updateUser);

        return this.userRepository.update(updateUser);
    }

    private void validateUpdateUser(User user) {
        validateName(user);
        validateTimeBetweenChanges(user);
        validateAmountOfChanges(user);
    }

    private void validateAmountOfChanges(User user) {
        if (user.getRole().equals(Role.NORMAL)) {
            if (user.getAmountUpdates() > 3) {
                throw new AmountOfUpdatesException("Change only" +
                        " 3 times in the first five minutes");
            }
        } else if (user.getRole().equals(Role.PREMIUM)) {
            if (user.getAmountUpdates() > 12) {
                throw new AmountOfUpdatesException("Change only" +
                        " 12 times in the first twenty minutes");
            }
        }
    }

    private void validateTimeBetweenChanges(User user) {
        var diff = ChronoUnit.MINUTES
                .between(user.getCreationDate(), user.getUpdateAt());

        if (user.getRole().equals(Role.NORMAL)) {
            if (diff >= 5) {
                throw new OverflowTimeException("Change " +
                        "only on the first five minutes!");
            }
        } else if (user.getRole().equals(Role.PREMIUM)) {
            if (diff >= 20) {
                throw new OverflowTimeException("Change " +
                        "only on the first twenty minutes!");
            }
        }
    }

    private void validateName(User user) {
        if (user.getRole().equals(Role.NORMAL)) {
            if (user.getName().length() > 10) {
                throw new IllegalNameException("Only " +
                        "users premium could have more than 10 characters");
            }
        } else if (user.getRole().equals(Role.PREMIUM)) {
            if (user.getName().length() > 40) {
                throw new IllegalNameException("Forbidden have more than " +
                        "40 characters");
            }
        }
    }

}
