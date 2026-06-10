package cl.uchile.dcc
package card.suit

import joker.Joker
import score.Score

/**
 * Trait representing the suit of a card in a standard deck.
 *
 * Each concrete implementation is a singleton object corresponding to a
 * specific suit: [[Clover]] (Clubs), [[Diamond]], [[Heart]], and [[Pica]] (Spades).
 *
 * Implemented as an empty marker trait, meaning suit identity is determined
 * solely by class comparison in [[PokerFunctions.samePint]], rather than
 * by any shared behavior or fields.
 *
 * @see [[Card]] for the type that carries a [[Suit]] instance.
 * @see [[RangeClassification]] for the analogous marker trait used to classify ranks.
 */
trait Suit {
  def applyScore(score: Score, jokers: Joker): Score
}