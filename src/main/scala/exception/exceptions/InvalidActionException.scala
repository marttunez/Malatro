package cl.uchile.dcc
package exception.exceptions

import exception.MalatroException

/**
 * Exception thrown when a player attempts an illegal action or move that breaks 
 * the game's core state machine rules (e.g., executing a command at the wrong phase).
 * * @param message The detailed error description explaining the illegal gameplay action.
 */
class InvalidActionException(message: String) extends MalatroException(message: String){
}
