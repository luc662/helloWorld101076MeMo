Feature: health bar actions
  adding or subtracting health to a character

  Scenario: give a character less health than his maximum
    Given a NPC with health of 1000 and a max of 2000
    When is healed 20
    Then his health should be 1020

  Scenario: give a character more health than his maximum
    Given a NPC with health of 10 and a max of 20
    When is healed 20
    Then his health should be 20

  Scenario: attack a character with less damage than his maximum
    Given a NPC with health of 1000 and a max of 2000
    When receive an attack of 20
    Then his health should be 980

  Scenario: attack a character with more damage than his maximum
    Given a NPC with health of 10 and a max of 20
    When receive an attack of 20
    Then the NPC is killed
    And his health should be 0