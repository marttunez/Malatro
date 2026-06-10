package cl.uchile.dcc
package card.range.figures

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Figure}

/**
 * Singleton object representing the Jack rank in a standard deck of cards.
 *
 * The Jay is a face card ([[Figure]] classification) with a game value
 * of 10 and a rank order of 11, placing it above the Ten and below the
 * Queen within the ordering of [[Range]] instances.
 */
object Jay extends Range {
  val Value : Int = 10
  val Order : Int = 11
  val Classification : RangeClassification = Figure
}
