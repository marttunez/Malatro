package cl.uchile.dcc
package hand.pokerhands

import card.Card
import scala.collection.mutable

/**
 * Utility object containing shared helper functions for evaluating poker hand combinations.
 *
 * These functions operate on a list of [[card.Card]] instances and are used
 * to determine properties such as flush, straight, and grouping of ranks.
 */
object PokerFunctions {

  /**
   * Determines whether all cards in the list share the same suit (pint).
   *
   * Suit equality is determined by direct comparison of each card's `pint`
   * field, rather than by class comparison as in the original [[PokerFunctions.samePint]].
   * Uses an explicit iterator to traverse the list, returning `false` as soon
   * as a mismatching suit is found.
   *
   * @param cards the list of cards to evaluate; may be empty.
   * @return `true` if all cards share the same suit, `false` if the list is
   *         empty or contains cards of differing suits.
   */
  def samePint(cards: List[Card]): Boolean = {
    if (cards.isEmpty) return false
    val firstPint = cards.head.pint
    val it = cards.iterator
    while (it.hasNext) {
      val currentCard = it.next()
      if (currentCard.pint != firstPint) {
        return false
      }
    }
    true
  }

  /**
   * Determines whether a list of exactly five cards forms a valid straight
   * (five cards with consecutive rank values, no duplicate ranks).
   *
   * Two straight patterns are recognized:
   *  - Normal straight: five cards with strictly consecutive rank orders
   *    (e.g. 3-4-5-6-7).
   *  - Royal straight: the specific combination A-10-J-Q-K (order values
   *    `List(1, 10, 11, 12, 13)`), treated as a high Ace straight.
   *
   * Note that this implementation differs from the original [[PokerFunctions.consecutive]]
   * in that the high Ace is recognized only for the Royal straight pattern,
   * rather than by remapping Ace order to 14 and checking full consecutiveness.
   *
   * @param cards the list of cards to evaluate; must contain exactly 5 cards.
   * @return `true` if the five cards form a normal or Royal straight,
   *         `false` otherwise (including when the list does not have exactly
   *         5 cards or when duplicate rank values are present).
   */
  def consecutive(cards: List[Card]): Boolean = {
    if (cards.size != 5) return false
    val values = cards.map(c => c.order).sorted
    for (i <- 0 until 4) {
      if (values(i) == values(i + 1)) return false
    }
    var isNormal = true
    for (i <- 0 until 4) {
      if (values(i + 1) != values(i) + 1) isNormal = false
    }
    if (isNormal) return true
    val royalValues = List(1, 10, 11, 12, 13)
    if (values == royalValues) return true

    false
  }

  /**
   * Returns the sizes of each group of cards that share the same rank,
   * sorted in descending order.
   *
   * Rank equality is determined by direct comparison of each card's `rango`
   * field, rather than by class comparison as in the original [[PokerFunctions.groupSizes]].
   * Cards are first sorted by [[Card.order]] so that equal ranks are guaranteed
   * to be adjacent, enabling a single sequential scan to count groups.
   *
   * For example, a hand with three Kings and two Jacks returns `List(3, 2)`,
   * and a hand with four Aces and one other card returns `List(4, 1)`.
   *
   * @param cards the list of cards to group by rank; may be of any size.
   * @return a list of integers representing the count of each distinct rank
   *         found in the hand, sorted from largest to smallest group,
   *         or [[Nil]] if the list is empty.
   */
  def groupSizes(cards: List[Card]): List[Int] = {
    if (cards.isEmpty) return Nil
    val sortedCards = cards.sortBy(_.order)
    val counts = mutable.ListBuffer[Int]()

    var currentCount = 0
    var currentRank = sortedCards.head.rango

    for (card <- sortedCards) {
      if (card.rango == currentRank) {
        currentCount += 1
      } else {
        counts += currentCount
        currentCount = 1
        currentRank = card.rango
      }
    }
    counts += currentCount
    counts.toList.sorted.reverse
  }
}