package br.com.wildrimak.shows.chainofresponsability.second;

import br.com.wildrimak.shows.chainofresponsability.second.models.Role;
import br.com.wildrimak.shows.chainofresponsability.second.service.UserService;

import java.util.Arrays;

public class MainCoRSecond {

    private static final UserService userService = new UserService();


    /**
     * 1 - The normal user in the system can only change its name if it
     * was created in the last 5 minutes.
     *
     * 2 - Even if it was created in the last 5 minutes, the normal user
     * can only change the name a maximum of 3 times
     *
     * 3 - The normal user can have a name with a maximum of 10 characters
     *
     * 4 - Premium users can do four times as much of what regular users
     * can do.
     * */

    public static void main(String[] args) {

        String wildrimak = "wildrimak";
        String silvioSantos = "Silvio Santos";

        Role first = Role.NORMAL;
        Role second = Role.PREMIUM;

        var user1 = userService.create(wildrimak, first);
        var user2 = userService.create(silvioSantos, second);

        System.out.println(user1);
        System.out.println(user2);

        var user3 = userService.update(user1.getId(), "sWildrimak");
        var user4 = userService.update(user2.getId(), "12345678901");
        var user5 = userService.update(user2.getId(), "Zé");

        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5);

    }
}
