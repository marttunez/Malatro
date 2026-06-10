package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, NotOdd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Eight is a numbered rank ([[NotOdd]] classification) with a game value
 * of 8 and a rank order of 8, placing it above the Seven and below the Nine
 * within the ordering of [[Range]] instances.
 */
object Eight extends Range{
  val Order : Int = 8
  val Value : Int = 8
  val Classification : RangeClassification = NotOdd
}
