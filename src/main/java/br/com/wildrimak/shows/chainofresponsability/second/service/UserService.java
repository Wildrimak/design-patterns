package br.com.wildrimak.shows.chainofresponsability.second.service;

import br.com.wildrimak.shows.chainofresponsability.second.exceptions.AmountOfUpdatesException;
import br.com.wildrimak.shows.chainofresponsability.second.exceptions.OverflowTimeException;
import br.com.wildrimak.shows.chainofresponsability.second.handler.*;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;
import br.com.wildrimak.shows.chainofresponsability.second.repository.UserRepository;
import br.com.wildrimak.shows.chainofresponsability.second.repository.UserRepositoryImpl;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
    }

    public User create(String name, Role role) {

        User user = new User(name, role);

        UserHandler first = new ValidateNormalUserNameHandler();
        UserHandler second = new ValidatePremiumUserNameHandler();
        UserHandler last = new StopHandler();

        first.setNextHandler(second);
        second.setNextHandler(last);

        first.handler(user);
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
        var first = new ValidateNormalUserNameHandler();
        var second = new ValidatePremiumUserNameHandler();
        var third = new ValidateTimeBetweenChangesNormalUser();
        var fourth = new ValidateTimeBetweenChangesPremiumUser();
        var fifth = new ValidateAmountOfChangesNormalUser();
        var sixth = new ValidateAmountOfChangesPremiumUser();
        var last = new StopHandler();

        first.setNextHandler(second);
        second.setNextHandler(third);
        third.setNextHandler(fourth);
        fourth.setNextHandler(fifth);
        fifth.setNextHandler(sixth);
        sixth.setNextHandler(last);

        first.handler(user);

    }


}
