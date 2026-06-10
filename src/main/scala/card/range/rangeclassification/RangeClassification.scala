package cl.uchile.dcc
package card.range.rangeclassification

import score.Score
import joker.Joker

/**
 * Trait representing the classification category of a card rank within the game.
 *
 * Serves as the common base type for the three rank classification groups:
 * [[Figures]] (face cards), [[NotOdd]] (numbered ranks Two through Ten),
 * and [[Odd]] (special ranks, currently only [[Ace]]).
 *
 * Implemented as an empty marker trait, meaning classification membership
 * is determined solely by which singleton object extends it, rather than
 * by any shared behavior or fields.
 *
 * @see [[Rango]] for the rank type that carries a [[RangeClassification]] instance.
 */
trait RangeClassification {
  def applyScore(score: Score, jokers: Joker): Score
}

