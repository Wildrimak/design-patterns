package br.com.wildrimak.shows.observer.second;

import br.com.wildrimak.shows.observer.second.models.Group;
import br.com.wildrimak.shows.observer.second.models.Post;
import br.com.wildrimak.shows.observer.second.models.Profile;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Profile wildrimak = new Profile("Wildrimak");
        Profile mario = new Profile("Mario");
        Profile marcela = new Profile("Marcela");
        Profile boris = new Profile("Boris");
        Profile junior = new Profile("Junior");
        Profile david = new Profile("David");

        Group wildrimakGroup = new Group("party", wildrimak,
                List.of(
                        marcela, boris, junior, david
        ));
        wildrimak.createGroup(wildrimakGroup);
        wildrimakGroup.addProfile(mario);

        Post post1 = new Post(wildrimakGroup, wildrimak,
                "guys this is my new group, what do you think about!?");

        Post post2 = new Post(wildrimakGroup, junior,
                "why I'm here?");

        Post post3 = new Post(wildrimakGroup, wildrimak,
                "oh sorry i got confused here");

        Post post4 = new Post(wildrimakGroup, mario,
                "Não consegue né moises?");

        wildrimakGroup.addPost(post1);
        wildrimakGroup.addPost(post2);
        wildrimakGroup.addPost(post3);
        wildrimakGroup.addPost(post4);
        wildrimakGroup.removeProfile(junior, wildrimak);

        Post post5 = new Post(wildrimakGroup, david,
                "I will need to go");
        wildrimakGroup.addPost(post5);
        wildrimakGroup.setName("Armario");
        david.removeGroup(wildrimakGroup);
        Post post6 = new Post(wildrimakGroup, mario,
                "KKKKKKKKKKKKKKKKKKKKKKKKKK");
        wildrimakGroup.addPost(post6);

        System.out.println("Notifications from Wildrimak: ");
        wildrimak.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from Mario: ");
        mario.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from Junior: ");
        junior.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from Marcela: ");
        marcela.getNotifications().forEach(System.out::println);
        System.out.println("Notifications from David: ");
        david.getNotifications().forEach(System.out::println);
        System.out.println("Messages from the group: ");
        wildrimakGroup.getPosts().forEach(System.out::println);

    }
}
