package cl.uchile.dcc
package card.range.figures

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Figure}

/**
 * Singleton object representing the King rank in a standard deck of cards.
 *
 * The Kaiser is a face card ([[Figure]] classification) with a game value
 * of 10 and a rank order of 13, placing it above the Queen and below the
 * Ace (when used as high) within the ordering of [[Range]] instances.
 */
object King extends Range {
  val Value : Int = 10
  val Order : Int = 13
  val Classification : RangeClassification = Figure
}
