package snakes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class RollAgainTest {
	private Player jack;
	private Player jill;

	@Test
	public Game newGame() {
		jack = new Player("Jack");
		jill = new Player("Jill");
		Player[] args = { jack, jill };
		Game game = new Game(12, args);
		game.setSquareToLadder(2, 2);
		game.setSquareToLadder(7, -5);
		game.setSquareToRollAgain(4);
		
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jack.position());
		assertEquals(1, jill.position());
		assertEquals(jack, game.currentPlayer());
		return game;
	}

	@Given("newGame")
	public Game initialStrings(Game game) {
		assertEquals("Jack", jack.toString());
		assertEquals("Jill", jill.toString());
		assertEquals("[1<Jack><Jill>]", game.firstSquare().toString());
		assertEquals("[4Roll again!]", game.getSquare(4).toString());
		return game;
	}
	
	@Given("newGame")
	public Game move1jack (Game game) {
		assertTrue(!(game.getSquare(4).isOccupied()));
		game.movePlayer(3);
		assertTrue(!(game.getSquare(4).isOccupied()));
		assertEquals("[4Roll again!]", game.getSquare(4).toString());
		assertTrue(game.getSquare(5).isOccupied() ||
				game.getSquare(6).isOccupied() ||
				game.getSquare(7).isOccupied() ||
				game.getSquare(8).isOccupied() ||
				game.getSquare(9).isOccupied() ||
				game.getSquare(10).isOccupied());
		return game;
	}
}
