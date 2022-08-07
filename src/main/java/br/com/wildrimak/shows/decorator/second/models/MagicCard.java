package br.com.wildrimak.shows.decorator.second.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MagicCard implements Card {

    private String description;
    private Monster monster;
    private Integer effectOnAttack;
    private Integer effectOnDefense;

    public MagicCard(String description, Integer effectOnAttack, Integer effectOnDefense) {
        this.description = description;
        this.effectOnAttack = effectOnAttack;
        this.effectOnDefense = effectOnDefense;
    }

    public MagicCard(String description, MonsterCard monster, Integer effectOnAttack, Integer effectOnDefense) {
        this.description = description;
        this.monster = monster;
        this.effectOnAttack = monster.getAttack() + effectOnAttack;
        this.effectOnDefense = monster.getDefense() + effectOnDefense;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
        this.monster.equipMagicCard(this);
    }

    @Override
    public String toString() {
        return "MagicCard{" +
                "description='" + description + '\'' +
                ", monsterDescription=" + monster.getDescription() +
                ", effectOnAttack=" + effectOnAttack +
                ", effectOnDefense=" + effectOnDefense +
                '}';
    }
}
