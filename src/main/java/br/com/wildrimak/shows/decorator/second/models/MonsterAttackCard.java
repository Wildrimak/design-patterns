package br.com.wildrimak.shows.decorator.second.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonsterAttackCard extends MonsterCardDecorator {

    public MonsterAttackCard(Monster monster) {
        super(monster);
    }

    public void attack(Monster monster) {

        if (this.getAttack() > monster.getDefense()) {
            log.info("You destroy the other monster!");
            this.setScore(this.getScore() + 2);
        } else {
            log.info("You can't destroy the other monster!");
            this.setScore(this.getScore() - 1);
        }

    }
}
