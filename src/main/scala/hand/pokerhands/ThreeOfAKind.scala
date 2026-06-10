package cl.uchile.dcc
package hand.pokerhands

import card.Card

import cl.uchile.dcc.joker.Joker
import cl.uchile.dcc.score.Score

/**
 * Represents the Three of a Kind poker hand combination.
 *
 * A Three of a Kind is formed when at least 3 cards in the hand share
 * the same rank. Unlike [[Straight]] or [[StraightFlush]], this hand
 * imposes no restriction on the total number of cards.
 *
 * Base scoring: [[chips]] = 30, [[mult]] = 3.
 */
class ThreeOfAKind extends PokerHand {
  val name = "Three Of A Kind"
  val chips = 30
  val mult = 3

  /**
   * Determines whether the given list of cards forms a valid Three of a Kind.
   *
   * Delegates rank grouping to [[PokerFunctions.groupSizes]], which returns
   * group sizes sorted in descending order. The hand is valid if the largest
   * group contains at least 3 cards of the same rank.
   *
   * @param card the list of cards to evaluate.
   * @return `true` if the largest rank group has 3 or more cards, `false` otherwise.
   */
  def validate(card: List[Card]): Boolean = PokerFunctions.groupSizes(card: List[Card]).headOption.exists(_ >= 3)

  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreThreeOfAKind(score, this)
}
