package cl.uchile.dcc
package score

/**
 * Represents the scoring state for a hand or round in the game.
 * * It encapsulates the cumulative chips and multiplier values, providing
 * immutable operation methods to progress the scoring state dynamically.
 * * @param chips The base point value accumulated.
 * @param mult The multiplier value applied to the chips.
 */
class Score(chips: Int, mult: Int){

  /**
   * Calculates the final total score by multiplying the accumulated chips by the multiplier.
   * * @return The final score calculation as an Integer.
   */
  def calc: Int = mult * chips

  /**
   * Creates a new Score instance with an increased amount of chips.
   * * @param amount The number of chips to add to the current total.
   *
   * @return A new Score instance with the updated chips value.
   */
  def addChips(amount: Int): Score = new Score(this.chips + amount, this.mult)

  /**
   * Creates a new Score instance with an increased multiplier value.
   * * @param amount The value to add to the current multiplier total.
   *
   * @return A new Score instance with the updated multiplier value.
   */
  def addMult(amount: Int): Score = new Score(this.chips, this.mult + amount)
}
