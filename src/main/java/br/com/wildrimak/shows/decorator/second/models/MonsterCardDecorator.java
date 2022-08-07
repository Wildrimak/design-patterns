package br.com.wildrimak.shows.decorator.second.models;

import java.util.List;

public abstract class MonsterCardDecorator implements Monster {

    private final Monster monster;

    protected MonsterCardDecorator(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String getDescription() {
        return monster.getDescription();
    }

    @Override
    public Integer getAttack() {
        return monster.getAttack();
    }

    @Override
    public Integer getDefense() {
        return monster.getDefense();
    }

    @Override
    public Integer getScore() {
        return monster.getScore();
    }

    @Override
    public void setScore(Integer value) {
        monster.setScore(value);
    }

    @Override
    public List<MagicCard> getMagicCards() {
        return monster.getMagicCards();
    }

    @Override
    public void equipMagicCard(MagicCard magicCard) {
        monster.equipMagicCard(magicCard);
    }
}
