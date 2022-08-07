package br.com.wildrimak.shows.decorator.first;

import br.com.wildrimak.shows.decorator.first.models.MagicCard;
import br.com.wildrimak.shows.decorator.first.models.MonsterCard;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class MainFirstDecorator {

    public static void main(String[] args) {

        final var dragonCard = MonsterCard
                .builder()
                .description("Green Eyes Ultimate Dragon")
                .attack(3000)
                .defense(3000)
                .mode(MonsterCard.Mode.DEFENSE)
                .score(0)
                .magicCards(new ArrayList<>())
                .build();

        final var wizardCard = MonsterCard
                .builder()
                .description("Lighting Magician")
                .attack(3500)
                .defense(5000)
                .mode(MonsterCard.Mode.ATTACK)
                .score(0)
                .magicCards(new ArrayList<>())
                .build();

        final var magicCard = new MagicCard(
                "Book of Dragons",
                5500,
                100);

        magicCard.setMonsterCard(dragonCard);

        dragonCard.setMode(MonsterCard.Mode.DEFENSE);
        dragonCard.attack(wizardCard);

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
