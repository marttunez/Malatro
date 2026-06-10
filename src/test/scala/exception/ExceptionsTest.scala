package cl.uchile.dcc
package exception

import hand.Hand
import card.Card
import card.range.*
import card.suit.*
import card.range.numbers.*
import game.Game
import joker.*

import cl.uchile.dcc.exception.exceptions.*
import munit.FunSuite

class ExceptionsTest extends FunSuite {

  // --- Tests de Capacidad de Mano (Hand) ---

  test("Hand should throw HandFullException when attempting to exceed 8 cards") {
    val hand = new Hand()
    val card = new Card(Two, Heart)

    var i = 0
    while (i < 8) {
      hand.addCard(card)
      i += 1
    }

    intercept[HandFullException] {
      hand.addCard(card)
    }
  }

  test("Hand should throw JokerFullException when attempting to exceed 2 jokers") {
    val hand = new Hand()
    val joker = new EvenSteven()

    hand.addJoker(joker)
    hand.addJoker(joker)

    intercept[JokerFullException] {
      hand.addJoker(joker)
    }
  }

  // --- Tests de Selección de Cantidad de Cartas (Reglas de Negocio) ---

  test("Game should throw InvalidActionException if index list is empty or exceeds 5 cards") {
    val hand = new Hand()
    val card = new Card(Two, Heart)

    // Llenamos la mano con cartas suficientes para la prueba
    var i = 0
    while (i < 6) {
      hand.addCard(card)
      i += 1
    }
    val game = new Game(hand)

    // Caso: Menos de 1 carta (Lista vacía) -> InvalidActionException
    intercept[InvalidActionException] {
      game.playHand(List())
    }

    // Caso: Más de 5 cartas -> InvalidActionException
    intercept[InvalidActionException] {
      game.playHand(List(0, i, 2, 3, 4, 5))
    }
  }

  // --- Tests de Límites Geométricos de Índices ---

  test("Game should throw InvalidIndexException if an index is out of hand bounds") {
    val hand = new Hand()
    val card = new Card(Two, Heart)
    hand.addCard(card)
    val game = new Game(hand)

    // Índice superior fuera de rango
    intercept[InvalidIndexException] {
      game.playHand(List(1))
    }

    // Índice negativo fuera de rango
    intercept[InvalidIndexException] {
      game.playHand(List(-1))
    }
  }

  test("Game should safely process unordered index selections without throwing out-of-bounds errors") {
    val hand = new Hand()
    hand.addCard(new Card(Two, Heart))    // Índice 0
    hand.addCard(new Card(Three, Heart))  // Índice 1
    hand.addCard(new Card(Four, Heart))   // Índice 2
    val game = new Game(hand)

    // Al pasar índices desordenados, el sistema no debe romperse internamente por mutación de desborde
    val played = game.playHand(List(2, 0))
    assertEquals(played.length, 2)
    assertEquals(hand.getCardsLen, 1)
  }

  // --- Tests de Límites de Acciones (Cuotas Máximas) ---

  test("Game should throw ActionLimitException when attempting to play more than 3 hands") {
    val hand = new Hand()
    val card = new Card(Two, Heart)

    var i = 0
    while (i < 6) {
      hand.addCard(card)
      i += 1
    }

    val game = new Game(hand)

    game.playHand(List(0))
    game.playHand(List(0))
    game.playHand(List(0))

    intercept[ActionLimitException] {
      game.playHand(List(0))
    }
  }

  test("Game should throw ActionLimitException when attempting to discard more than 3 times") {
    val hand = new Hand()
    val card = new Card(Two, Heart)

    var i = 0
    while (i < 6) {
      hand.addCard(card)
      i += 1
    }

    val game = new Game(hand)

    game.discardHand(List(0))
    game.discardHand(List(0))
    game.discardHand(List(0))

    intercept[ActionLimitException] {
      game.discardHand(List(0))
    }
  }

  test("All domain exceptions should correctly inherit from MalatroException") {
    assert(new ActionLimitException("").isInstanceOf[MalatroException])
    assert(new HandFullException("").isInstanceOf[MalatroException])
    assert(new InvalidActionException("").isInstanceOf[MalatroException])
    assert(new InvalidIndexException("").isInstanceOf[MalatroException])
    assert(new JokerFullException("").isInstanceOf[MalatroException])
  }
}