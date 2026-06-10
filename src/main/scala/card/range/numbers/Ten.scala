package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, NotOdd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Ten is a numbered rank ([[NotOdd]] classification) with a game value
 * of 10 and a rank order of 10, placing it above the Nine,
 * within the ordering of [[Range]] instances.
 */
object Ten extends Range{
  val Order : Int = 10
  val Value : Int = 10
  val Classification : RangeClassification = NotOdd
}
