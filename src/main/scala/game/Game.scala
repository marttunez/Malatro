package cl.uchile.dcc
package game

import card.Card
import hand.Hand
import exception.exceptions.{ActionLimitException, InvalidIndexException, InvalidActionException}

/**
 * Coordinates and manages the core loop of a poker game round.
 *
 * This class tracks gameplay resource limits (such as active hands played and discards),
 * validates input card selections, modifies the state of the player's hand, and resets
 * the match states between rounds.
 *
 * @param hand The active hand instance holding the player's current cards and Jokers.
 */
class Game(private val hand: Hand) {

  private var handsPlayed: Int = 0
  private var discardsCount: Int = 0

  /**
   * Helper method to validate common card selection constraints (index boundaries and selection sizes).
   */
  private def validateCardSelection(index: List[Int]): Unit = {
    // Rule: Cannot play/discard less than 1 or more than 5 cards -> InvalidActionException
    if (index.length < 1 || index.length > 5) {
      throw new InvalidActionException(
        "You must select between 1 and 5 cards"
      )
    }

    // Rule: Cannot play/discard out-of-bounds indices -> InvalidIndexException
    val handSize = this.hand.getCardsLen
    var i = 0
    while (i < index.length) {
      val idx = index(i)
      if (idx < 0 || idx >= handSize) {
        throw new InvalidIndexException(
          "The provided index is out of bounds for the current hand"
        )
      }
      i = i + 1
    }
  }

  /**
   * Evaluates, executes, and plays a specific collection of cards from the current hand.
   *
   * @param index A list of index integers targeting cards chosen to be played.
   * @return A list containing the Card instances successfully played, sorted in their original order.
   */
  def playHand(index: List[Int]): List[Card] = {
    // Rule: Cannot play more than 3 times -> ActionLimitException
    if (this.handsPlayed >= 3) {
      throw new ActionLimitException(
        "No more than 3 hands played"
      )
    }

    validateCardSelection(index)

    var cardsPlayed: List[Card] = List()
    val sortedIndex = index.sorted.reverse
    for (idx <- sortedIndex) {
      val cardToPlay = this.hand.getCardIn(idx)
      cardsPlayed = cardToPlay :: cardsPlayed
      this.hand.removeCard(idx)
    }
    this.handsPlayed += 1
    cardsPlayed
  }

  /**
   * Discards a chosen selection of cards from the current hand without triggering scores.
   *
   * @param index A list of index integers targeting cards chosen to be permanently discarded.
   */
  def discardHand(index: List[Int]): Unit = {
    // Rule: Cannot discard more than 3 times -> ActionLimitException
    if (this.discardsCount >= 3) {
      throw new ActionLimitException(
        "No more than 3 discards allowed"
      )
    }

    validateCardSelection(index)

    val sortedIndex = index.sorted.reverse
    for (idx <- sortedIndex) {
      this.hand.removeCard(idx)
    }
    this.discardsCount += 1
  }

  /**
   * Resets execution limits and counter states back to factory baselines.
   */
  def resetRound(): Unit = {
    this.handsPlayed = 0
    this.discardsCount = 0
  }
}