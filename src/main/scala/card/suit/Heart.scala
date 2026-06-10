package cl.uchile.dcc
package card.suit

import joker.Joker
import score.Score

/**
 * Singleton object representing the Heart suit in a standard deck of cards.
 *
 * Serves as a concrete implementation of [[Suit]], used alongside [[Clover]],
 * [[Diamond]], and [[Pica]] to form the four suits of a standard deck. Suit
 * identity is determined by class comparison in [[PokerFunctions.samePint]],
 * so no additional fields or behavior are required.
 *
 * @see [[Suit]] for the common suit base type.
 */
object Heart extends Suit {
  override def applyScore(score: Score, jokers: Joker): Score = jokers.scoreHeart(score, this)
}
