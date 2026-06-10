package cl.uchile.dcc
package card

import score.Score
import hand.pokerhands.*
import card.range.rangeclassification.*
import card.suit.*
import joker.*
import card.range.*
import munit.FunSuite

class MockJoker extends Joker {
  val name = "Mock Joker"

  override def scoreStraightFlush(score: Score, hand: PokerHand): Score = score.addChips(50)

  override def scoreHeart(score: Score, pint: Suit): Score = score.addMult(2)

  override def scorePairCard(score: Score, classification: RangeClassification): Score = score.addChips(10)
}

class ApplyScoreTest extends FunSuite{
  test("PokerHand (StraightFlush) should correctly dispatch score evaluation to Joker") {
    val initialScore = new Score(100, 2)
    val straightFlush = new StraightFlush()
    val joker = new MockJoker()

    val finalScore = straightFlush.applyScore(initialScore, joker)
    // Formula expected: (100 + 50) * 2 = 300
    assertEquals(finalScore.calc, 300)
  }

  test("Pint (Heart) should correctly dispatch score evaluation to Joker") {
    val initialScore = new Score(10, 2)
    val pintHeart = Heart
    val joker = new MockJoker()

    val finalScore = pintHeart.applyScore(initialScore, joker)
    // Formula expected: 10 * (2 + 2) = 40
    assertEquals(finalScore.calc, 40)
  }

  // --- Part 2: Card Scoring Loop Test ---

  test("Card.applyScore should sequentially compound card chips and its Joker modifiers list") {
    // Isolated anonymous stub representing a 'Two of Hearts' matching numeric pairs
    object StubTwo extends Range {
      def Order: Int = 2

      def Value: Int = 2

      def Classification: RangeClassification = new RangeClassification {
        def applyScore(score: Score, j: Joker): Score = j.scorePairCard(score, this)
      }
    }

    val card = new Card(StubTwo, Heart)
    val initialScore = new Score(10, 3)

    val jokers: List[Joker] = List(new EvenSteven(), new MockJoker())

    val finalScore = card.applyScore(initialScore, jokers)

    /*
     * Computation Breakdown:
     * 1. Initial state: (Chips: 10, Mult: 3)
     * 2. Card Base Value (+2 Chips): (Chips: 12, Mult: 3)
     * 3. Joker 1 (EvenSteven processing):
     * - Rank classification matched (scorePairCard) -> .addMult(4) -> (Chips: 12, Mult: 7)
     * 4. Joker 2 (MockJoker processing):
     * - Suit matched (scoreHeart) -> .addMult(2) -> (Chips: 12, Mult: 9)
     * - Rank classification matched (scorePairCard) -> .addChips(10) -> (Chips: 22, Mult: 9)
     * Final validation: 22 * 9 = 198
     */
    assertEquals(finalScore.calc, 198)
  }
}
