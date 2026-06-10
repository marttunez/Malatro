package cl.uchile.dcc
package card.range.figures

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Figure}

/**
 * Singleton object representing the Queen rank in a standard deck of cards.
 *
 * The Queen is a face card ([[Figure]] classification) with a game value
 * of 10 and a rank order of 12, placing it above the Jay and below the Kaiser
 * within the ordering of [[Range]] instances.
 */
object Queen extends Range {
  val Value : Int = 10
  val Order : Int = 12
  val Classification : RangeClassification = Figure
}
