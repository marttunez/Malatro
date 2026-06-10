package cl.uchile.dcc
package hand.pokerhands

import munit.FunSuite
import card.Card
import card.suit.{Heart, Pica, Clover}
import card.range.numbers.{Two, Five, Eight}
import card.range.figures.Jay
import hand.pokerhands.ThreeOfAKind

class ThreeOfAKindTest extends FunSuite {
  var three: ThreeOfAKind = null
  override def beforeEach(context: BeforeEach): Unit =
    three = new ThreeOfAKind

  test("validate returns true when there are three cards of same rank") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Two,  Pica),
      new Card( Two,  Clover),
      new Card( Five,  Heart),
      new Card( Jay,  Heart)
    )
    assertEquals(three.validate(cards), true)
  }

  test("validate returns false when there is only one pair") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Two,  Pica),
      new Card( Five,  Clover),
      new Card( Eight,  Heart),
      new Card( Jay,  Heart)
    )
    assertEquals(three.validate(cards), false)
  }
}