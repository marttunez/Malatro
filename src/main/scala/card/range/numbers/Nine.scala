package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Odd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Nine is a numbered rank ([[Odd]] classification) with a game value
 * of 9 and a rank order of 9 placing it below the Ten and above the Eight
 * within the ordering of [[Range]] instances.
 */
object Nine extends Range{
  val Order : Int = 9
  val Value : Int = 9
  val Classification : RangeClassification = Odd
}
