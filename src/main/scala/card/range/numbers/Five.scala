package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Odd}

/**
 * Singleton object representing the Five rank in a standard deck of cards.
 *
 * The Five is a numbered rank ([[Odd]] classification) with a game value
 * of 5 and a rank order of 5 placing it below the Six and above the Four
 * within the ordering of [[Range]] instances.
 */
object Five extends Range{
  val Order : Int = 5
  val Value : Int = 5
  val Classification : RangeClassification = Odd
}
