package br.com.wildrimak.shows.decorator.second.models;

import java.util.List;

public interface Monster extends Card {
    Integer getAttack();
    Integer getDefense();
    Integer getScore();
    void setScore(Integer value);
    List<MagicCard> getMagicCards();
    void equipMagicCard(MagicCard magicCard);
}
