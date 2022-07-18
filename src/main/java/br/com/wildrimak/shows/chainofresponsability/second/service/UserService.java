package br.com.wildrimak.shows.chainofresponsability.second.service;

import br.com.wildrimak.shows.chainofresponsability.second.handler.*;
import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.models.User;
import br.com.wildrimak.shows.chainofresponsability.second.repository.UserRepository;
import br.com.wildrimak.shows.chainofresponsability.second.repository.UserRepositoryImpl;

import java.time.OffsetDateTime;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
    }

    public User create(String name, Role role) {

        User user = new User(name, role);

        UserHandler first = new ValidateNormalUserNameHandler();
        UserHandler second = new ValidatePremiumUserNameHandler();

        first.setNextHandler(second);
        var itsOk = first.handler(user);

        if(itsOk){
            return this.userRepository.save(user);
        }

        throw new IllegalStateException("Your user is invalid! " +
                "And for security reasons I can't tell you " +
                "what's invalid.");

    }

    public User update(Long id, String name) {
        var userSaved = this.userRepository.findById(id);
        var updateUser = new User(name, userSaved.getRole());
        updateUser.setId(userSaved.getId());
        updateUser.setCreationDate(userSaved.getCreationDate());
        updateUser.setUpdateAt(OffsetDateTime.now());
        updateUser.setRole(userSaved.getRole());
        updateUser.setAmountUpdates(userSaved.getAmountUpdates() + 1);

        var itsOk = validateUpdateUser(updateUser);

        if(itsOk){
            return this.userRepository.update(updateUser);
        }

        throw new IllegalStateException("Your user is invalid! " +
                "And for security reasons I can't tell you " +
                "what's invalid.");

    }

    private boolean validateUpdateUser(User user) {
        var first = new ValidateNormalUserNameHandler();
        var second = new ValidatePremiumUserNameHandler();
        var third = new ValidateTimeBetweenChangesNormalUser();
        var fourth = new ValidateTimeBetweenChangesPremiumUser();
        var fifth = new ValidateAmountOfChangesNormalUser();
        var sixth = new ValidateAmountOfChangesPremiumUser();

        first.setNextHandler(second);
        second.setNextHandler(third);
        third.setNextHandler(fourth);
        fourth.setNextHandler(fifth);
        fifth.setNextHandler(sixth);

        return first.handler(user);

    }

}
