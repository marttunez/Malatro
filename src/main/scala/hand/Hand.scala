package cl.uchile.dcc
package hand

import card.Card
import joker.Joker
import exception.exceptions.{HandFullException, InvalidIndexException, JokerFullException}

/**
 * Represents a player's hand in the game.
 *
 * It acts as a container for both the active scoring playing cards
 * and the owned Jokers that apply active modifiers during gameplay.
 */
class Hand {
  private var cards : List[Card] = List()
  private var jokers : List[Joker] = List()

  /**
   * Returns the total number of playing cards currently held in the hand.
   */
  def getCardsLen: Int = this.cards.length

  /**
   * Returns the total number of Jokers currently active in the hand.
   */
  def getJokersLen: Int = this.jokers.length

  /**
   * Retrieves a specific card from the hand based on its index position.
   *
   * @param index The zero-based position of the card to retrieve.
   * @return The Card instance located at the specified index.
   */
  def getCardIn(index: Int): Card = {
    this.cards(index)
  }
  /**
   *
   * Add a card to a List of cards in a hand
   *
   * @param card A value of class Card
   *
   */
  def addCard(card: Card): Unit = {
    if (this.cards.length == 8){
      throw new HandFullException(
        "You can not add more than 8 cards"
      )
    }
    cards = card :: cards
  }

  /**
   *
   * Add a joker to a List of jokers in a hand
   *
   * @param joker A value of class DeviousJoker, EvenSteven, (...)
   *
   */
  def addJoker(joker: Joker): Unit = {
    if (this.jokers.length == 2){
      throw new JokerFullException(
        "You can not add more than 2 jokers"
      )
    }
    jokers = joker :: jokers
  }

  /**
   *
   * remove the card corresponding
   * to the index that is given to the function
   *
   * @param index An Int who represent a position in a List
   *
   */
  def removeCard(index: Int): Unit = {
    if (index < 0 || index >= this.cards.length) {
      throw new InvalidIndexException(
        "That card doesn't exist"
      )
    }
    cards = cards.patch(index, Nil, 1)
  }

  /**
   *
   * remove the joker corresponding
   * to the index that is given to the function
   *
   * @param index An Int who represent a position in a List
   *
   */
  def removeJoker(index: Int): Unit = {
    if (index < 0 || index >= this.jokers.length){
      throw new InvalidIndexException(
        "That joker doesn't exist"
      )
    }
    jokers = jokers.patch(index, Nil, 1)
  }
}
