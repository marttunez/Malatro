package cl.uchile.dcc
package card

import card.range.rangeclassification.RangeClassification
import suit.Suit
import range.Range

import score.Score
import joker.Joker

/**
 * Represents a single playing card, defined by its rank and suit.
 *
 * A card is composed of a [[Range]] instance, which determines its scoring
 * value, rank order, and classification, and a [[Suit]] instance, which
 * determines its suit. These two properties together uniquely identify a
 * card within a standard deck.
 *
 * The [[value]], [[order]], and [[classification]] methods delegate directly
 * to the underlying [[Range]], providing a flat interface for the most
 * commonly accessed rank properties without exposing [[Range]] directly.
 *
 * @param rango the rank of this card (e.g. [[Ace]], [[Queen]], [[Kaiser]]).
 * @param pint  the suit of this card, used for flush detection in [[PokerFunctions.samePint]].
 * @see [[PokerFunctions]] for the functions that consume [[Card]] instances during hand evaluation.
 */
class Card(val rango: Range, val pint: Suit) {

  /**
   * The chip score value of this card's rank, delegated to [[Range.Value]].
   *
   * @return the score value of this card's rank.
   */
  def value : Int = rango.Value

  /**
   * The rank order of this card, delegated to [[Range.Order]].
   * Used for comparisons and straight detection in [[PokerFunctions.consecutive]].
   *
   * @return the rank order of this card, ranging from 1 ([[Ace]]) to 13 ([[Kaiser]]).
   */
  def order : Int = rango.Order

  /**
   * The classification group of this card's rank, delegated to [[Range.Classification]].
   * Indicates whether this card is a face card ([[Figures]]), a numbered rank ([[NotOdd]]),
   * or a special rank ([[Odd]]).
   *
   * @return the [[RangeClassification]] of this card's rank.
   */
  private def classification : RangeClassification = rango.Classification

  /**
   * Processes and updates the score by applying base card values and iterating
   * through a list of active Jokers to trigger their respective scoring modifiers.
   * * The function first integrates the base value of the card into the score,
   * then delegates scoring interventions to the card's suit (pint) and rank
   * (classification) logic for each Joker provided in the list.
   * * @param score The initial Score instance before applying modifications.
   *
   * @param jokers A list of active Joker instances that may provide bonuses or multipliers.
   *
   * @return A new Score instance containing the final calculated values after all
   *         Joker modifiers have been applied.
   */
  def applyScore(score: Score, jokers: List[Joker]): Score = {
    var scoreNow = score
    scoreNow = scoreNow.addChips(this.value)
    var i = 0
    val len = jokers.length
    while (i < len) {
      val joker = jokers(i)
      scoreNow = this.pint.applyScore(scoreNow, joker)
      scoreNow = this.classification.applyScore(scoreNow, joker)
      i = i +1
    }
    scoreNow
  }
}
