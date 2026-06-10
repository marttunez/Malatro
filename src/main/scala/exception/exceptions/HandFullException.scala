package cl.uchile.dcc
package exception.exceptions

import exception.MalatroException

/**
 * Exception thrown when an attempt is made to draw or add a new playing card 
 * to the player's hand, but the hand's maximum capacity has already been reached.
 *
 * @param message The detailed error description explaining the card capacity limit violation.
 */
class HandFullException(message: String) extends MalatroException(message) {
}
