package br.com.wildrimak.shows.decorator.first.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MagicCard implements Card{

    private String description;
    private MonsterCard monsterCard;
    private Integer effectOnAttack;
    private Integer effectOnDefense;

    public MagicCard(String description, Integer effectOnAttack, Integer effectOnDefense) {
        this.description = description;
        this.effectOnAttack = effectOnAttack;
        this.effectOnDefense = effectOnDefense;
    }

    public MagicCard(String description, MonsterCard monsterCard, Integer effectOnAttack, Integer effectOnDefense) {
        this.description = description;
        this.monsterCard = monsterCard;
        this.effectOnAttack = monsterCard.getAttack() + effectOnAttack;
        this.effectOnDefense = monsterCard.getDefense() + effectOnDefense;
    }

    public void setMonsterCard(MonsterCard monsterCard) {
        this.monsterCard = monsterCard;
        this.monsterCard.equipMagicCard(this);
    }

    @Override
    public String toString() {
        return "MagicCard{" +
                "description='" + description + '\'' +
                ", monsterCardDescription=" + monsterCard.getDescription() +
                ", effectOnAttack=" + effectOnAttack +
                ", effectOnDefense=" + effectOnDefense +
                '}';
    }
}
