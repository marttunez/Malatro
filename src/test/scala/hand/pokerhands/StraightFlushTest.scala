package cl.uchile.dcc
package hand.pokerhands

import munit.FunSuite
import card.Card
import card.suit.{Heart, Pica}
import card.range.numbers.{Two, Three, Four, Five, Six}
import hand.pokerhands.StraightFlush

class StraightFlushTest extends FunSuite{
  var straightFlush: StraightFlush = null
  override def beforeEach(context: BeforeEach): Unit =
    straightFlush = new StraightFlush

  test("validate returns true for straight flush") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Three,  Heart),
      new Card( Four,  Heart),
      new Card( Five,  Heart),
      new Card( Six,  Heart)
    )
    assertEquals(straightFlush.validate(cards), true)
  }

  test("validate returns false when cards are consecutive but different pint") {
    val cards = List(
      new Card( Two,  Heart),
      new Card( Three,  Heart),
      new Card( Four,  Heart),
      new Card( Five,  Heart),
      new Card( Six,  Pica)
    )
    assertEquals(straightFlush.validate(cards), false)
  }
}