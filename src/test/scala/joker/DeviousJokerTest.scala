package cl.uchile.dcc
package joker

import joker.DeviousJoker
import munit.FunSuite

class DeviousJokerTest extends FunSuite {
  test("DeviousJoker should have the correct name") {
    val joker = new DeviousJoker()
    assertEquals(joker.name, "Devious Joker")
  }

  /**
   * IT'S A TEST SO I USE isInstanceOf()
   */
  test("DeviousJoker should be an instance of Joker") {
    val joker = new DeviousJoker()
    assert(joker.isInstanceOf[Joker])
  }
}