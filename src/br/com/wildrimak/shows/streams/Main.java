package br.com.wildrimak.shows.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<String> persons = List.of(
                "1 - Wildrimak Pereira- 24 anos - wildrimak@gmail.com",
                "5 - Lucas Souza- 24 anos - lucas@gmail.com",
                "3 - José Pedro - 19 anos - pedros@gmail.com",
                "4 - Lana Luna - 17 anos - luna@gmail.com",
                "2 - Leonardo Torre - 30 anos - torre@gmail.com");



        var result= persons.stream()
                .map(person -> person.split(" - "))
                .map(dados -> new Person(
                        Integer.valueOf(dados[0]),
                        dados[1],
                        Integer.valueOf(dados[2].split(" ")[0]),
                        dados[3]))
                .sorted(Comparator.comparingInt(Main.Person::getIdade).reversed())
                .collect(Collectors.toList());

        result.stream().forEach(person -> System.out.println(person));

    }

    public static class Person {

        private Integer id;
        private String nome;
        private Integer idade;
        private String email;

        public Person(Integer id, String nome, Integer idade, String email) {
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            this.email = email;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

}
