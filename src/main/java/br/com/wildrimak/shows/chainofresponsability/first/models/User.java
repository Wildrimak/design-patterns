package br.com.wildrimak.shows.chainofresponsability.first.models;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private OffsetDateTime creationDate;
    private OffsetDateTime updateAt;
    private int amountUpdates;
    private Role role;

    public User(String name, Role role){
        this.name = name;
        this.creationDate = OffsetDateTime.now();
        this.updateAt = creationDate;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", updateAt=" + updateAt +
                ", amountUpdates=" + amountUpdates +
                ", role=" + role +
                '}';
    }
}
