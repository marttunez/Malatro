package cl.uchile.dcc
package hand.pokerhands

import munit.FunSuite
import card.Card
import card.suit.{Heart, Pica, Clover, Diamond}
import card.range.numbers.{Ace, Two, Three, Four, Five, Six, Eight, Ten}
import card.range.figures.{Jay, Queen, King}
import hand.pokerhands.Straight

class StraightTest extends FunSuite{
  var straight: Straight = null
  override def beforeEach(context: BeforeEach): Unit =
    straight = new Straight

  test("validate returns true for normal straight") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Three,  Pica),
      new Card( Four,  Clover),
      new Card( Five,  Diamond),
      new Card( Six,  Heart)
    )
    assertEquals(straight.validate(cards), true)
  }

  test("validate returns true for ace low straight") {
    val cards = List(
      new Card( Ace,  Heart),
      new Card( Two,  Pica),
      new Card( Three,  Clover),
      new Card( Four,  Diamond),
      new Card( Five,  Heart)
    )
    assertEquals(straight.validate(cards), true)
  }

  test("validate returns true for ace high straight") {
    val cards = List(
      new Card( Ten,  Heart),
      new Card( Jay,  Pica),
      new Card( Queen,  Clover),
      new Card( King,  Diamond),
      new Card( Ace,  Heart)
    )
    assertEquals(straight.validate(cards), true)
  }

  test("validate returns false for non consecutive cards") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Three,  Pica),
      new Card( Five,  Clover),
      new Card( Six,  Diamond),
      new Card( Eight,  Heart)
    )
    assertEquals(straight.validate(cards), false)
  }
}
