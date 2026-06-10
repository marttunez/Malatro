package cl.uchile.dcc
package joker

import score.Score

import cl.uchile.dcc.card.range.rangeclassification.RangeClassification

/**
 * Represents the "Even Steven" Joker in the game.
 *
 * This Joker enhances the player's score by granting a multiplier bonus
 * (+4 Mult) whenever an even-ranked card (or pair card) is scored during a hand.
 */
class EvenSteven extends Joker {
  val name = "Even Steven"

  override def scorePairCard(score: Score, rank: RangeClassification): Score = {
    score.addMult(4)
  }
}
