package cl.uchile.dcc
package joker

import joker.GreedyJoker

import munit.FunSuite

class GreedyJokerTest extends FunSuite() {
  test("GreedyJoker should have the correct name") {
    val joker = new GreedyJoker()
    assertEquals(joker.name, "Greedy Joker")
  }

  /**
   * IT'S A TEST SO I USE isInstanceOf()
   */
  test("GreedyJoker should be an instance of Joker") {
    val joker = new GreedyJoker()
    assert(joker.isInstanceOf[Joker])
  }
}
