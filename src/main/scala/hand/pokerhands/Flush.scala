package cl.uchile.dcc
package hand.pokerhands

import card.Card

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 *
 * represents a flush hand, which is defined
 * as a hand that passes the validate function
 *
 */
class Flush extends PokerHand{
  val name = "Flush"
  val chips = 35
  val mult = 4

  /**
   *
   * This function checks if there are five cards
   * in the hand and if they have the same Pint.
   *
   * @param card a List of cards who form a hand
   * @return Boolean who say if is or isn't a Flush
   *         
   */
  def validate(card : List[Card]) : Boolean = {
    card.size == 5 && PokerFunctions.samePint(card: List[Card])
  }

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreFlush(score, this)
}
