package br.com.wildrimak.shows.observer.first;

import br.com.wildrimak.shows.observer.first.models.Group;
import br.com.wildrimak.shows.observer.first.models.Post;
import br.com.wildrimak.shows.observer.first.models.Profile;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Profile wildrimak = new Profile("Wildrimak");
        Profile mario = new Profile("Mario");
        Profile marcela = new Profile("Marcela");
        Profile gerson = new Profile("Gerson");
        Profile junior = new Profile("Junior");

        Group wildrimakGroup = new Group("party", wildrimak,
                List.of(
                        marcela, gerson, junior
        ));

        wildrimakGroup.addProfile(mario);

        Post post1 = new Post(wildrimakGroup, wildrimak,
                "guys this is my new group, what do you think about!?");

        Post post2 = new Post(wildrimakGroup, junior,
                "why I'm here");

        Post post3 = new Post(wildrimakGroup, wildrimak,
                "oh sorry i got confused here");

        Post post4 = new Post(wildrimakGroup, mario,
                "Não consegue né moises?");

        wildrimakGroup.addPost(post1);
        wildrimakGroup.addPost(post2);
        wildrimakGroup.addPost(post3);
        wildrimakGroup.addPost(post4);
        wildrimakGroup.removeProfile(junior);

        System.out.println("Messages from the group: ");
        wildrimakGroup.getPosts().forEach(System.out::println);
        System.out.println("Notifications from Wildrimak: ");
        wildrimak.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from Mario: ");
        mario.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from Junior: ");
        junior.getNotifications().forEach(System.out::println);


    }
}
