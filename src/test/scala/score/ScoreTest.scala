package cl.uchile.dcc
package score

import munit.FunSuite

class ScoreTest extends FunSuite {

  test("test1") {
    val score = new Score(100, 4)
    assertEquals(score.calc, 400)
  }

  test("test2") {
    val scoreWithZeroChips = new Score(0, 10)
    val scoreWithZeroMult = new Score(50, 0)

    assertEquals(scoreWithZeroChips.calc, 0)
    assertEquals(scoreWithZeroMult.calc, 0)
  }

  test("test3") {
    val score = new Score(1000, 100)
    assertEquals(score.calc, 100000)
  }
}
