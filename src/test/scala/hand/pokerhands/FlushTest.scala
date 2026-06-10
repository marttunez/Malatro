package cl.uchile.dcc
package hand.pokerhands

import card.Card
import card.suit.{Heart, Pica}
import card.range.numbers.{Two, Five, Eight}
import card.range.figures.{Jay, King}

import munit.{BeforeEach, FunSuite}

class FlushTest extends FunSuite {
  var flush: Flush = null
  override def beforeEach(context: BeforeEach): Unit =
    flush = new Flush

  test("validate returns true when all 5 cards have the same pint") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Five,  Heart),
      new Card( Eight,  Heart),
      new Card( Jay,  Heart),
      new Card( King, Heart)
    )
    assertEquals(flush.validate(cards), true)
  }

  test("validate returns false when one card has a different pint") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Five,  Heart),
      new Card( Eight,  Heart),
      new Card( Jay,  Heart),
      new Card( King,  Pica)
    )
    assertEquals(flush.validate(cards), false)
  }

  test("validate returns false when there are less than 5 cards") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Five,  Heart)
    )
    assertEquals(flush.validate(cards), false)
  }

  test("validate returns false when there are more than 5 cards") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Five,  Heart),
      new Card( Eight,  Heart),
      new Card( Jay,  Heart),
      new Card( King,  Heart),
      new Card( Two,  Heart)
    )
    assertEquals(flush.validate(cards), false)
  }

  test("validate returns false for an empty list") {
    val cards = List()
    assertEquals(flush.validate(cards), false)
  }
}