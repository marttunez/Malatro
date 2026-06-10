package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, NotOdd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Six is a numbered rank ([[NotOdd]] classification) with a game value
 * of 6 and a rank order of 6, placing it above the Five and below the Seven
 * within the ordering of [[Range]] instances.
 */
object Six extends Range{
  val Order : Int = 6
  val Value : Int = 6
  val Classification : RangeClassification = NotOdd
}