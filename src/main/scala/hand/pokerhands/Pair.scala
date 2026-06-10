package cl.uchile.dcc
package hand.pokerhands

import card.Card

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 *
 * represents a Pair hand, which is defined
 * as a hand that passes the validate function
 *
 */
class Pair extends PokerHand {
  val name = "Pair"
  val chips = 10
  val mult = 2
  def validate(card: List[Card]): Boolean =
    PokerFunctions.groupSizes(card: List[Card]).headOption.exists(_ >= 2)

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scorePair(score, this)
}
