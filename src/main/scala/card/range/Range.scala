package cl.uchile.dcc
package card.range

import card.range.rangeclassification.RangeClassification

/**
 * Trait representing the rank of a card in a standard deck.
 *
 * Each concrete implementation is a singleton object corresponding to a
 * specific rank (e.g. [[Ace]], [[Jay]], [[Queen]], [[Kaiser]]), and provides
 * its own [[Order]], [[Value]], and [[Classification]].
 *
 * Ranks are grouped into three classifications via [[RangeClassification]]:
 * [[Figures]] for face cards, [[NotOdd]] for numbered ranks, and [[Odd]]
 * for special ranks.
 *
 * @see [[Card]] for the type that carries a [[Range]] instance.
 */
trait Range {
  /**
   * The rank order of this card within the deck, used for comparisons
   * and straight detection in [[PokerFunctions.consecutive]].
   * Values range from 1 ([[Ace]]) to 13 ([[Kaiser]]).
   */
  def Order : Int

  /**
   * The chip score value contributed by this rank when scored.
   * Numbered ranks share the same value as their order, face cards
   * are all worth 10, and [[Ace]] is worth 11.
   */
  def Value: Int

  /**
   * The classification group this rank belongs to, as defined
   * by [[RangeClassification]].
   */
  def Classification: RangeClassification
}



