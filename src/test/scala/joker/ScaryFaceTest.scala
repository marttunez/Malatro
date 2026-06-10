package cl.uchile.dcc
package joker

import joker.ScaryFace

import munit.FunSuite

class ScaryFaceTest extends FunSuite() {
  test("ScaryFace should have the correct name") {
    val joker = new ScaryFace()
    assertEquals(joker.name, "Scary Face")
  }

  /**
   * IT'S A TEST SO I USE isInstanceOf()
   */
  test("ScaryFace should be an instance of Joker") {
    val joker = new ScaryFace()
    assert(joker.isInstanceOf[Joker])
  }
}
