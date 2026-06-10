package cl.uchile.dcc
package exception

/**
 * Custom runtime exception used to signal game-specific errors or violations 
 * within the engine's core rules and lifecycle transactions.
 * * @param message The detailed error description explaining the cause of the exception.
 */
class MalatroException(message: String) extends Exception {
}
