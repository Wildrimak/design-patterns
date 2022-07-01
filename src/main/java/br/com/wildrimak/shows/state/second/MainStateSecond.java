package br.com.wildrimak.shows.state.second;

import br.com.wildrimak.shows.state.second.models.Player;
import br.com.wildrimak.shows.state.second.models.Position;

import java.util.Scanner;

public class MainStateSecond {
    public static void main(String[] args) {

        Player mario = new Player("mario", new Position(0, 0, 0));

        System.out.println(mario);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("press one key: ");
            String key = scanner.nextLine();

            if (key.equals("w")) {
                mario.front();
            }

            if (key.equals("s")) {
                mario.back();
            }

            if (key.equals("a")) {
                mario.left();
            }

            if (key.equals("d")) {
                mario.right();
            }

            if (key.equals("8")) {
                mario.up();
            }

            if (key.equals("2")) {
                mario.down();
            }

            if (key.equals("j")) {
                mario.jump();
            }

            if (key.equals("f")) {
                mario.fly();
            }

            if (key.equals("r")) {
                mario.run();
            }

            if (key.equals("i")) {
                mario.idle();
            }

            if (key.equals("exit")) {
                System.out.println("end");
                break;
            }

            System.out.println(mario);

        }


    }
}
