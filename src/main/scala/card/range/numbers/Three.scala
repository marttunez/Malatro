package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Odd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Three is a numbered rank ([[Odd]] classification) with a game value
 * of 3 and a rank order of 3 placing it below the Four and above the Two
 * within the ordering of [[Range]] instances.
 */
object Three extends Range{
  val Order : Int = 3
  val Value : Int = 3
  val Classification : RangeClassification = Odd
}
