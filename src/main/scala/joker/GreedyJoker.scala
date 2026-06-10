package cl.uchile.dcc
package joker

import score.Score
import hand.pokerhands.PokerHand

/**
 * Represents a "Greedy" Joker in the game.
 *
 * This particular Joker benefits the player by modifying the score
 * when a Straight hand is played, granting a large amount of extra chips.
 */
class GreedyJoker extends Joker {
  val name = "Greedy Joker"
  override def scoreStraight(score: Score, hand: PokerHand): Score = {
    score.addChips(100)
  }
}