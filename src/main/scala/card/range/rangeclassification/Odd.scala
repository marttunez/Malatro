package cl.uchile.dcc
package card.range.rangeclassification

import joker.Joker
import score.Score

/**
 * Singleton object representing the special rank classification within [[RangeClassification]].
 *
 * This classification groups ranks that do not fit the numbered ([[NotOdd]])
 * or face card ([[Figures]]) categories. Currently, its only member is [[Ace]],
 * which has a game value of 11 and a dual role in straight detection
 * (low as 1, high as 14).
 *
 * @see [[Figures]] for the face card classification and [[NotOdd]] for the numbered rank classification.
 */
object Odd extends RangeClassification {
  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreOddCard(score, this)
}
