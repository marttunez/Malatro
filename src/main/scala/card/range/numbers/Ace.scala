package cl.uchile.dcc
package card.range.numbers

import card.range.Range
import card.range.rangeclassification.{RangeClassification, Odd}

/**
 * Singleton object representing the Ace rank in a standard deck of cards.
 *
 * The Ace is a special rank ([[Odd]] classification) with a game value of 11,
 * the highest among all ranks. Its order of 1 places it at the bottom of the
 * natural rank sequence, but it is also treated as high (14) during straight
 * detection, allowing both A-2-3-4-5 and 10-J-Q-K-A combinations.
 *
 * @see [[PokerFunctions.consecutive]] for the high Ace handling logic.
 */
object Ace extends Range {
  val Value : Int = 11
  val Order : Int = 1
  val Classification : RangeClassification = Odd
}
