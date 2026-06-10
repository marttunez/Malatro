package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, NotOdd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Four is a numbered rank ([[NotOdd]] classification) with a game value
 * of 4 and a rank order of 4, placing it above the Three and below the Six
 * within the ordering of [[Range]] instances.
 */
object Four extends Range{
  val Order : Int = 4
  val Value : Int = 4
  val Classification : RangeClassification = NotOdd
}
