package cl.uchile.dcc
package hand.pokerhands

import card.Card
import score.Score
import joker.Joker

/**
 * Trait representing a poker hand type in the game.
 *
 * Each concrete subclass defines a specific hand combination (e.g. Flush, Straight,
 * Full House), providing its own display name, base scoring values, and validation
 * logic against a list of cards.
 *
 * The base score of a hand is computed from [[chips]] and [[mult]] via [[phScore]],
 * which returns a [[Score]] instance that can be used during scoring calculations.
 */
trait PokerHand {
  val name : String
  val chips : Int
  val mult : Int

  /**
   * Computes the base [[Score]] for this hand using its [[chips]] and [[mult]] values.
   *
   * @return a new [[Score]] instance constructed from this hand's chips and multiplier.
   */
  def phScore: Score = new Score(chips, mult)

  /**
   * Determines whether the given list of cards satisfies the conditions
   * for this poker hand combination.
   *
   * @param cards the list of cards to evaluate.
   * @return `true` if the cards form a valid instance of this hand, `false` otherwise.
   */
  def validate(cards: List[Card]): Boolean

  /**
   * Applies a joker's scoring modifiers to an existing score instance.
   *
   * @param score  The current scoring state before applying the modifications.
   * @param jokers The joker instance whose scoring rules should be triggered.
   * @return A new or modified Score instance containing the updated values.
   */
  def applyScore(score: Score, jokers: Joker): Score
}
