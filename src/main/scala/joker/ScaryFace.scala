package cl.uchile.dcc
package joker

import score.Score

import card.range.rangeclassification.RangeClassification

/**
 * Represents the "Scary Face" Joker in the game.
 *
 * This Joker benefits the player by granting a flat bonus of extra chips
 * (+30 Chips) whenever a figure card (face card) is scored during a hand.
 */
class ScaryFace extends Joker {
  val name = "Scary Face"
  override def scoreFigures(score: Score, rank: RangeClassification): Score = {
    score.addChips(30)
  }
}
