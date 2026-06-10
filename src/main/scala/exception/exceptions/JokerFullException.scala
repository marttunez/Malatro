package cl.uchile.dcc
package exception.exceptions

import cl.uchile.dcc.exception.MalatroException

/**
 * Exception thrown when an attempt is made to add a new Joker to a player's hand,
 * but the maximum capacity for active Jokers has already been reached.
 * * @param message The detailed error description explaining the hand capacity limit violation.
 */
class JokerFullException(message: String) extends MalatroException(message) {
}
