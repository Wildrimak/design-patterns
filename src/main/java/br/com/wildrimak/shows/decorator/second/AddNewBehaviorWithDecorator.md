#### Example of adding a behavior at runtime

In this example I have a card game, that contains monsters and magic cards, 
each card can will get a new ability in combination with others  

MonsterCard
  - description
  - attackMode()
  - defenseMode()
  - equip(MagicCard)
  
MonsterCardInAttack
  - attack()

MonsterCardEquipped
  - destroyCard()