package cl.uchile.dcc
package card.range.rangeclassification

import joker.Joker
import score.Score

/**
 * Singleton object representing the face card classification within [[RangeClassification]].
 *
 * This classification groups the three face card ranks: [[Jay]] (Jack),
 * [[Queen]], and [[Kaiser]] (King). Face cards share a game value of 10
 * regardless of their individual rank order.
 *
 * @see [[Odd]] and [[NotOdd]] for the other rank classifications.
 */
object Figure extends RangeClassification {
  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreFigures(score, this)
}
