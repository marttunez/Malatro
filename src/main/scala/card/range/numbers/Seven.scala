package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Odd}

/**
 * Singleton object representing the Eight rank in a standard deck of cards.
 *
 * The Seven is a numbered rank ([[Odd]] classification) with a game value
 * of 7 and a rank order of 7 placing it below the Eight and above the Six
 * within the ordering of [[Range]] instances.
 */
object Seven extends Range{
  val Order : Int = 7
  val Value : Int = 7
  val Classification : RangeClassification = Odd
}
