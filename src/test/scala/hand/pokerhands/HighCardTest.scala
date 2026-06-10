package cl.uchile.dcc
package hand.pokerhands

import munit.FunSuite
import card.Card
import card.suit.{Heart, Pica, Clover, Diamond}
import card.range.numbers.{Ace, Two, Three, Four, Five, Six,Seven, Eight, Ten}
import card.range.figures.{Jay, Queen, King}
import hand.pokerhands.HighCard

class HighCardTest extends FunSuite {
  val hand = new HighCard
  test("High Card") {
    val cards = List(
      new Card( Ace,  Pica),
      new Card( Four,  Pica)
    )
    assert(hand.validate(cards))
  }
}
