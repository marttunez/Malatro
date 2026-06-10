package cl.uchile.dcc
package hand.pokerhands

import card.Card
import score.Score


/**
 * Evaluates a list of cards and determines the best matching poker hand,
 * returning its associated score.
 *
 * Hands are ranked from strongest to weakest in the following order:
 * [[StraightFlush]], [[Flush]], [[Straight]], [[ThreeOfAKind]], [[Pair]],
 * and [[HighCard]]. The evaluator checks each hand in that order and returns
 * the first one that matches.
 *
 * [[HighCard]] acts as the default fallback, since every non-empty hand
 * satisfies it.
 */
class PokerHandsEvaluator {

  /**
   * Ordered list of poker hands from highest to lowest rank.
   * The order determines evaluation priority.
   */
  private val hands: List[PokerHand] = List(
    new StraightFlush(),
    new Flush(),
    new Straight(),
    new ThreeOfAKind(),
    new Pair(),
    new HighCard()
  )

  /**
   * Determines the best matching [[PokerHand]] for a given list of cards.
   *
   * Iterates through [[hands]] in order and returns the first hand whose
   * `validate` method returns `true` for the given cards. If no hand matches
   * (which should not occur in practice), [[HighCard]] is returned as a fallback.
   *
   * @param cards the list of cards to evaluate.
   * @return the highest-ranking [[PokerHand]] that the cards satisfy.
   */
  private def evaluate(cards: List[Card]): PokerHand = {
    var bestHand: PokerHand = null
    val it = hands.iterator
    while (it.hasNext && bestHand == null) {
      val currentHand = it.next()
      if (currentHand.validate(cards)) {
        bestHand = currentHand
      }
    }
    if (bestHand == null) new HighCard() else bestHand
  }

  /**
   * Returns the [[Score]] associated with the best poker hand found in the
   * given list of cards.
   *
   * Delegates hand detection to [[evaluate]] and then retrieves the
   * corresponding score via [[PokerHand.phScore]].
   *
   * @param cards the list of cards to evaluate.
   * @return the [[Score]] of the highest-ranking hand matched by the cards.
   */
  def score(cards: List[Card]): Score = {
    val winningHand = this.evaluate(cards)
    winningHand.phScore
  }
}