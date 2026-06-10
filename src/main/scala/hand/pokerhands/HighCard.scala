package cl.uchile.dcc
package hand.pokerhands

import card.Card

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 *
 * represents a HighCard hand, which is defined
 * as a hand that passes the validate function
 *
 */
class HighCard extends PokerHand {
  val name = "High Card"
  val chips = 5
  val mult = 1

  /**
   * 
   * Validates if a hand is nonEmpty
   * 
   * @param card List of cards
   * @return Boolean
   */
  def validate(card: List[Card]): Boolean = card.nonEmpty

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreHighCard(score, this)
}

