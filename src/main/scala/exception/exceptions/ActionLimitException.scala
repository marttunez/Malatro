package cl.uchile.dcc
package exception.exceptions

import cl.uchile.dcc.exception.MalatroException

/**
 * Exception thrown when a player attempts to perform an action (such as playing a hand 
 * or discarding) that has already hit its maximum allowed allocation limit for the round.
 *
 * @param message The detailed error description explaining the exceeded action threshold.
 */
class ActionLimitException(message: String) extends MalatroException(message) {
}
