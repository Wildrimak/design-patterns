package br.com.wildrimak.shows.decorator.second.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Slf4j
@ToString
public class MonsterCard implements Monster {

    private String description;
    private Integer attack;
    private Integer defense;
    private Integer score;
    private List<MagicCard> magicCards;

    public void equipMagicCard(MagicCard magicCard) {
        this.magicCards.add(magicCard);
        this.attack = magicCard.getEffectOnAttack();
        this.defense = magicCard.getEffectOnDefense();
    }

}
