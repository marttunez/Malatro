package cl.uchile.dcc
package hand

import card.Card
import card.suit.{Clover, Diamond, Heart, Pica}
import card.range.figures.{Jay, King, Queen}
import card.range.numbers.*
import hand.Hand
import joker.{EvenSteven, GreedyJoker}
import hand.pokerhands.PokerFunctions.samePint

import munit.FunSuite
import game.Game

/**
 * Test suite for the [[Hand]] class, covering card and joker management
 * as well as hand playing behavior.
 *
 * Each test instantiates a fresh [[Hand]] to ensure full isolation
 * between test cases.
 */
class HandTest extends FunSuite {

  /**
   * Verifies that cards are correctly added to the hand,
   * incrementing the card count with each addition.
   */
  test("Add card test") {
    val hand = new Hand()
    assertEquals(hand.getCardsLen, 0)
    val card1 = new Card(Two, Heart)
    val card2 = new Card(Five, Heart)
    hand.addCard(card1)
    assertEquals(hand.getCardsLen, 1)
    hand.addCard(card2)
    assertEquals(hand.getCardsLen, 2)
  }

  /**
   * Verifies that jokers are correctly added to the hand,
   * incrementing the joker count with each addition.
   */
  test("Add joker test") {
    val hand = new Hand()
    assertEquals(hand.getJokersLen, 0)
    val joker1 = new GreedyJoker()
    hand.addJoker(joker1)
    assertEquals(hand.getJokersLen, 1)
  }

  /**
   * Verifies that removing a card at a given index correctly reduces
   * the card count and leaves the remaining cards intact.
   *
   * After removing the card at index 1 (Five of Spades) from a three-card
   * hand, the two remaining cards (Two of Hearts and Seven of Hearts)
   * should share the same suit.
   */
  test("Remove card test") {
    val hand = new Hand()
    assertEquals(hand.getCardsLen, 0)
    val card1 = new Card(Two, Heart)
    val card2 = new Card(Five, Pica)
    val card3 = new Card(Seven, Heart)
    hand.addCard(card1)
    hand.addCard(card2)
    hand.addCard(card3)
    assertEquals(hand.getCardsLen, 3)
    hand.removeCard(1)
    assertEquals(hand.getCardsLen, 2)
    val remainingCards = List(hand.getCardIn(0), hand.getCardIn(1))
    assertEquals(samePint(remainingCards), true)
  }

  /**
   * Verifies that removing a joker at a given index correctly reduces
   * the joker count to zero.
   */
  test("Remove joker test") {
    val hand = new Hand()
    assertEquals(hand.getJokersLen, 0)
    val joker1 = new EvenSteven
    hand.addJoker(joker1)
    assertEquals(hand.getJokersLen, 1)
    hand.removeJoker(0)
    assertEquals(hand.getJokersLen, 0)
  }

  /**
   * Verifies that [[Hand.playHand]] returns the correct cards for a given
   * set of indices and removes them from the hand.
   *
   * Playing indices 0 and 2 from a three-card hand should return those two
   * cards, leaving only the card at index 1 remaining in the hand.
   */
  test("playHand should return the correct cards and remove them from the hand") {
    val hand = new Hand()
    val c0 = new Card(Two, Heart)
    val c1 = new Card(Five, Pica)
    val c2 = new Card(Seven, Clover)
    val c3 = new Card(Ace, Diamond)
    hand.addCard(c3) // idx 0
    hand.addCard(c2) // idx 1
    hand.addCard(c1) // idx 2
    val game = new Game(hand)
    val played = game.playHand(List(0, 2))
    assertEquals(played.size, 2)
    assert(played.contains(c1))
    assert(played.contains(c3))
    assertEquals(hand.getCardsLen, 1)
    assertEquals(hand.getCardIn(0), c2)
  }

  /**
   * Verifies that [[Hand.playHand]] handles unsorted index lists correctly,
   * returning the expected cards regardless of the order indices are provided.
   *
   * Playing indices in descending order (2, 0) should produce the same
   * result as ascending order, leaving only the middle card in the hand.
   */
  test("playHand should handle unsorted indices correctly") {
    val hand = new Hand()
    val c0 = new Card(Ten, Pica)
    val c1 = new Card(Queen, Heart)
    val c2 = new Card(King, Clover)
    hand.addCard(c2) // idx 0
    hand.addCard(c1) // idx 1
    hand.addCard(c0) // idx 2
    val game = new Game(hand)
    val played = game.playHand(List(2, 0))
    assertEquals(played.size, 2)
    assert(played.contains(c0))
    assert(played.contains(c2))
    assertEquals(hand.getCardIn(0), c1)
  }
}
