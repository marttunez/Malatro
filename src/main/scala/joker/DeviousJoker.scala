package cl.uchile.dcc
package joker

import score.Score
import hand.pokerhands.PokerHand

/**
 * Represents the "Devious Joker" in the game.
 *
 * This Joker aids the player by augmenting the score specifically when a 
 * Straight hand is triggered, adding a set number of bonus chips.
 */
class DeviousJoker extends Joker {
  val name = "Devious Joker"

  override def scoreStraight(score: Score, hand: PokerHand): Score = {
    score.addChips(100)
  }
}
