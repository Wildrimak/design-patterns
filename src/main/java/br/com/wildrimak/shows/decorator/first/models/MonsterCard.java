package br.com.wildrimak.shows.decorator.first.models;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Slf4j
@ToString
public class MonsterCard implements Card {

    private String description;
    private Integer attack;
    private Integer defense;
    private Mode mode;
    private Integer score;
    private List<MagicCard> magicCards;

    public void attack(MonsterCard monsterCard) {

        if (this.mode.equals(Mode.ATTACK)) {
            if (this.attack > monsterCard.getDefense()) {
                log.info("You destroy the other monster!");
                this.score += 2;
            } else {
                log.info("You can't destroy the other monster!");
                this.score -= 1;
            }
        } else {
            log.error("You can't attack in defense mode");
        }
    }

    public void equipMagicCard(MagicCard magicCard) {
        this.magicCards.add(magicCard);
        this.attack = magicCard.getEffectOnAttack();
        this.defense = magicCard.getEffectOnDefense();
    }

    public enum Mode {
        ATTACK, DEFENSE
    }
}
