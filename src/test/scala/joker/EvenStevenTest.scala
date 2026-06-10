package cl.uchile.dcc
package joker

import joker.EvenSteven
import munit.FunSuite

class EvenStevenTest extends FunSuite() {
  test("EvenSteven should have the correct name") {
    val joker = new EvenSteven()
    assertEquals(joker.name, "Even Steven")
  }

  /**
   * IT'S A TEST SO I USE isInstanceOf()
   */
  test("EvenSteven should be an instance of Joker") {
    val joker = new EvenSteven()
    assert(joker.isInstanceOf[Joker])
  }
}
