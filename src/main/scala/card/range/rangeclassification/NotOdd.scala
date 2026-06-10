package cl.uchile.dcc
package card.range.rangeclassification

import joker.Joker
import score.Score

/**
 * Singleton object representing the numbered card classification within [[RangeClassification]].
 *
 * This classification groups all numbered ranks that are neither face cards
 * nor special ranks, spanning from Two through Ten. Each rank in this group
 * shares the same numeric game value as its rank order.
 *
 * @see [[Figures]] for the face card classification and [[Odd]] for the special rank classification.
 */
object NotOdd extends RangeClassification {
  override def applyScore(score: Score, jokers: Joker): Score = jokers.scorePairCard(score, this)
}

