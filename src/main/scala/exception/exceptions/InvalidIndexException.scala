package cl.uchile.dcc
package exception.exceptions

import cl.uchile.dcc.exception.MalatroException

/**
 * Exception thrown when a requested card index falls outside the valid structural
 * boundaries of the player's current hand list.
 * * @param message The detailed error description explaining the illegal index placement.
 */
class InvalidIndexException(message: String) extends MalatroException(message) {
}
