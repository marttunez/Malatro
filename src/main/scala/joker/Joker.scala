package cl.uchile.dcc
package joker

import score.Score
import card.suit.Suit
import hand.pokerhands.PokerHand

import cl.uchile.dcc.card.range.rangeclassification.RangeClassification

/**
 * Base trait for all Joker cards within the game system.
 *
 * Defines the core life-cycle hooks for scoring interventions. Concrete sub-classes 
 * implement specific hooks to inject chips, multipliers, or custom behavior 
 * when individual poker hands, card suits, or card ranks trigger.
 */
trait Joker {

  /**
   * The identifying display name of this Joker.
   */
  def name : String

  /** Modifies the score when a Flush hand is evaluated. */
  def scoreFlush(score: Score, hand: PokerHand): Score = score

  /** Modifies the score when a Three of a Kind hand is evaluated. */
  def scoreThreeOfAKind(score: Score, hand: PokerHand): Score = score

  /** Modifies the score when a High Card hand is evaluated. */
  def scoreHighCard(score: Score, hand: PokerHand): Score = score

  /** Modifies the score when a Pair hand is evaluated. */
  def scorePair(score: Score, hand: PokerHand): Score = score

  /** Modifies the score when a Straight hand is evaluated. */
  def scoreStraight(score: Score, hand: PokerHand): Score = score

  /** Modifies the score when a Straight Flush hand is evaluated. */
  def scoreStraightFlush(score: Score, hand: PokerHand): Score = score

  /** Modifies the score based on a scored Clover (Clubs) suit card. */
  def scoreClover(score: Score, pint: Suit): Score = score

  /** Modifies the score based on a scored Diamond suit card. */
  def scoreDiamond(score: Score, pint: Suit): Score = score

  /** Modifies the score based on a scored Heart suit card. */
  def scoreHeart(score: Score, pint: Suit): Score = score

  /** Modifies the score based on a scored Pica (Spades) suit card. */
  def scorePica(score: Score, pint: Suit): Score = score

  /** Modifies the score based on a scored Figure (Face) card rank. */
  def scoreFigures(score: Score, rank: RangeClassification): Score = score

  /** Modifies the score based on a scored Even card rank. */
  def scorePairCard(score: Score, rank: RangeClassification): Score = score

  /** Modifies the score based on a scored Odd card rank. */
  def scoreOddCard(score: Score, rank: RangeClassification): Score = score

}