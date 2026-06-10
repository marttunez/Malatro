package cl.uchile.dcc
package hand.pokerhands

import card.Card
import card.suit.{Clover, Diamond, Heart, Pica}
import card.range.numbers.{Ace, Eight, Five, Four, Nine, Seven, Six, Ten, Three, Two}
import card.range.figures.{Jay, King, Queen}
import hand.pokerhands.{Flush, HighCard, Pair, PokerHandsEvaluator, Straight, StraightFlush, ThreeOfAKind}
import munit.FunSuite

class PokerHandsEvaluatorTest extends FunSuite {
  val straightFlushCards = List(
    new Card( Ace,  Pica),
    new Card( Two,  Pica),
    new Card( Three,  Pica),
    new Card( Four,  Pica),
    new Card( Five,  Pica)
  )

  val flushCards = List(
    new Card( Two,  Heart),
    new Card( Five,  Heart),
    new Card( Eight,  Heart),
    new Card( Jay,  Heart),
    new Card( King,  Heart)
  )

  val straightCards = List(
    new Card( Seven,  Pica),
    new Card( Eight,  Heart),
    new Card( Nine,  Diamond),
    new Card( Ten,  Clover),
    new Card( Jay,  Pica)
  )

  val threeOfAKindCards = List(
    new Card( Nine,  Pica),
    new Card( Nine,  Heart),
    new Card( Nine,  Diamond),
    new Card( Three,  Clover),
    new Card( King,  Pica)
  )

  val pairCards = List(
    new Card( Five,  Pica),
    new Card( Five,  Heart),
    new Card( Two,  Diamond),
    new Card( Eight,  Clover),
    new Card( Nine,  Pica)
  )

  val highCardCards = List(
    new Card( Two,  Pica),
    new Card( Four,  Heart),
    new Card( Seven,  Diamond),
    new Card( Nine,  Clover),
    new Card( King,  Pica)
  )

  test("StraightFlush : correct score (800)") {
    assert(PokerHandsEvaluator().score(straightFlushCards).calc == 800)
  }

  test("StraightFlush : doesnt have score of (140)") {
    assert(PokerHandsEvaluator().score(straightFlushCards).calc != 140)
  }

  test("Flush : correct score (140)") {
    assert(PokerHandsEvaluator().score(flushCards).calc == 140)
  }

  test("Flush : doesnt have score of (800)") {
    assert(PokerHandsEvaluator().score(flushCards).calc != 800)
  }

  test("Straight : correct score  (120)") {
    assert(PokerHandsEvaluator().score(straightCards).calc == 120)
  }

  test("Straight : doesnt have score of (140)") {
    assert(PokerHandsEvaluator().score(straightCards).calc != 140)
  }

  test("ThreeOfAKind : correct score  (90)") {
    assert(PokerHandsEvaluator().score(threeOfAKindCards).calc == 90)
  }

  test("ThreeOfAKind : doesnt have score of (20)") {
    assert(PokerHandsEvaluator().score(threeOfAKindCards).calc != 20)
  }

  test("Pair : correct score (20)") {
    assert(PokerHandsEvaluator().score(pairCards).calc == 20)
  }

  test("Pair : doesnt have score of Three of a Kind (90)") {
    assert(PokerHandsEvaluator().score(pairCards).calc != 90)
  }

  test("HighCard : correct score (5)") {
    assert(PokerHandsEvaluator().score(highCardCards).calc == 5)
  }

  test("HighCard : doesnt have score of Pair (20)") {
    assert(PokerHandsEvaluator().score(highCardCards).calc != 20)
  }
}