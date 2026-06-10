package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, NotOdd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Two is a numbered rank ([[NotOdd]] classification) with a game value
 * of 2 and a rank order of 2 placing it below the Three
 * within the ordering of [[Range]] instances.
 */
object Two extends Range {
  val Order : Int = 2
  val Value : Int = 2
  val Classification : RangeClassification  = NotOdd
}
