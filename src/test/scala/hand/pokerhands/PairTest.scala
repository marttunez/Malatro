package cl.uchile.dcc
package hand.pokerhands

import card.Card
import card.suit.{Heart, Pica, Clover}
import card.range.numbers.{Two, Five, Eight}
import card.range.figures.{Jay, King}

import munit.{BeforeEach, FunSuite}

class PairTest extends FunSuite {
  var pair: Pair = null
  override def beforeEach(context: BeforeEach): Unit =
    pair = new Pair
    
  test("validate returns true when there is exactly one pair") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Two,  Pica),
      new Card( Five,  Heart),
      new Card( Eight,  Clover),
      new Card( Jay,  Heart)
    )
    assertEquals(pair.validate(cards), true)
  }

  test("validate returns false when there is no pair") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Five,  Pica),
      new Card( Eight,  Clover),
      new Card( Jay,  Heart),
      new Card( King,  Pica)
    )
    assertEquals(pair.validate(cards), false)
  }
}