package br.com.wildrimak.shows.decorator.second;

import br.com.wildrimak.shows.decorator.second.models.MagicCard;
import br.com.wildrimak.shows.decorator.second.models.Monster;
import br.com.wildrimak.shows.decorator.second.models.MonsterAttackCard;
import br.com.wildrimak.shows.decorator.second.models.MonsterCard;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class MainSecondDecorator {

    public static void main(String[] args) {
        final Monster dragonCard = MonsterCard
                .builder()
                .description("Green Eyes Ultimate Dragon")
                .attack(3000)
                .defense(3000)
                .score(0)
                .magicCards(new ArrayList<>())
                .build();

        final Monster wizardCard = MonsterCard
                .builder()
                .description("Lighting Magician")
                .attack(3500)
                .defense(5000)
                .score(0)
                .magicCards(new ArrayList<>())
                .build();

        final var magicCard = new MagicCard(
                "Book of Dragons",
                5500,
                100);

        magicCard.setMonster(dragonCard);

        final MonsterAttackCard dragonCardAttack = new MonsterAttackCard(dragonCard);
        dragonCardAttack.attack(wizardCard);

        if (dragonCard.getScore() > wizardCard.getScore()) {
            log.info("Dragon Card wins!");
            log.info(dragonCard.toString());
            log.info(wizardCard.toString());
        } else if (dragonCard.getScore() < wizardCard.getScore()) {
            log.info("Wizard Card wins!");
            log.info(dragonCard.toString());
            log.info(wizardCard.toString());
        } else {
            log.info("The game is draw");
            log.info(dragonCard.toString());
            log.info(wizardCard.toString());

        }
    }
}
