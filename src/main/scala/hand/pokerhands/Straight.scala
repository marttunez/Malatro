package cl.uchile.dcc
package hand.pokerhands

import card.Card
import hand.pokerhands.PokerFunctions

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 * Represents the Straight poker hand combination.
 *
 * A Straight is formed when exactly 5 cards have consecutive rank values
 * with no duplicate ranks. Aces may be used as both low (A-2-3-4-5) and
 * high (10-J-Q-K-A).
 *
 * Base scoring: [[chips]] = 30, [[mult]] = 4.
 */
class Straight extends PokerHand {
  val name = "Straight"
  val chips = 30
  val mult = 4

  /**
   * Determines whether the given list of cards forms a valid Straight.
   *
   * Requires exactly 5 cards with consecutive rank values and no repeated
   * ranks. Delegates consecutive rank checking to [[PokerFunctions.consecutive]].
   *
   * @param card the list of cards to evaluate.
   * @return `true` if the cards form a Straight, `false` otherwise.
   */
  def validate(card: List[Card]): Boolean = {
    card.size == 5 && PokerFunctions.consecutive(card: List[Card])
  }

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreStraight(score, this)
}
