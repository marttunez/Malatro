package cl.uchile.dcc
package hand.pokerhands

import card.Card
import hand.pokerhands.PokerFunctions

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 * Represents the Straight Flush poker hand combination.
 *
 * A Straight Flush is formed when exactly 5 cards share the same suit and
 * have consecutive rank values with no duplicate ranks. Aces may be used
 * as both low (A-2-3-4-5) and high (10-J-Q-K-A).
 *
 * This is the highest-ranking hand recognized by [[PokerHandsEvaluator]].
 *
 * Base scoring: [[chips]] = 100, [[mult]] = 8.
 */
class StraightFlush extends PokerHand {
  val name = "Straight Flush"
  val chips = 100
  val mult = 8
  
  /**
   * Determines whether the given list of cards forms a valid Straight Flush.
   *
   * Requires exactly 5 cards that simultaneously satisfy both a shared suit
   * and consecutive rank values with no duplicates. Delegates suit checking
   * to [[PokerFunctions.samePint]] and consecutive rank checking to
   * [[PokerFunctions.consecutive]].
   *
   * @param card the list of cards to evaluate.
   * @return `true` if the cards form a Straight Flush, `false` otherwise.
   */
  def validate(card : List[Card]) : Boolean = {
    card.size == 5 && PokerFunctions.samePint(card: List[Card])
      && PokerFunctions.consecutive(card: List[Card])
  }

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreStraightFlush(score, this)
}
