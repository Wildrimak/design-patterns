package br.com.wildrimak.shows.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainStreams {

    private static final List<String> persons = List.of(
            "1 - Wildrimak Pereira - 24 years - wildrimak@gmail.com",
            "5 - Lucas Souza - 24 years - lucas@gmail.com",
            "3 - José Pedro - 19 years - pedros@gmail.com",
            "4 - Lana Luna - 17 years - luna@gmail.com",
            "2 - Leonardo Torre - 30 years - torre@gmail.com");

    public static void firstCase() {

        var result = mapToPerson();

        result.forEach(System.out::println);

    }

    private static List<Person> mapToPerson() {
        return persons.stream()
                .map(person -> person.split(" - "))
                .map(data -> new Person(
                        Integer.valueOf(data[0]),
                        data[1],
                        Integer.valueOf(data[2].split(" ")[0]),
                        data[3]))
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }

    public static class Person {

        private final Integer id;
        private String name;
        private final Integer age;
        private final String email;

        public Person(Integer id, String name, Integer age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        firstCase();

        var result = mapToPerson();

        var strings = result.stream()
                .map(Person::getId)
                .map(MainStreams::tryValidate)
                .map(optional -> optional
                        .map(string -> switch (string) {
                            case "Well done!" -> string;
                            case "Failed with IllegalArgumentException" -> "IAE";
                            case "Failed with IllegalStateException" -> "ISE";
                            case "Failed with IllegalCallerException" -> "ICE";
                            default -> "None case";
                        })
                        .orElseThrow()
                ).collect(Collectors.toList());

        System.out.println(strings);
    }

    static Optional<String> tryValidate(int value) {

        Optional<String> result = Optional.of("Well done!");

        try {
            validateAnything(value);
        } catch (IllegalArgumentException a) {
            result = Optional.of("Failed with IllegalArgumentException");
        } catch (IllegalStateException s) {
            result = Optional.of("Failed with IllegalStateException");
        } catch (IllegalCallerException c) {
            result = Optional.of("Failed with IllegalCallerException");
        }

        return result;

    }

    static void validateAnything(int value) {
        System.out.println("validate value: " + value);
        if (value == 1) {
            throw new IllegalArgumentException("1 is not valid");
        } else if (value == 2) {
            throw new IllegalStateException("2 is not valid");
        } else if (value == 3) {
            throw new IllegalCallerException("3 is not valid");
        }
    }

}
