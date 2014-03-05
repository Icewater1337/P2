package snakes;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

@RunWith(JExample.class)
public class SlowDownTest {
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
		game.setSquareToSlowDown(4);
		
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
		assertEquals("[4Slow down!]", game.getSquare(4).toString());
		return game;
	}
	
	@Given("newGame")
	public Game move1jack (Game game) {
		game.movePlayer(3);
		assertTrue(game.getSquare(4).isOccupied());
		assertEquals("[4Slow down!<Jack>]", game.getSquare(4).toString());
		return game;
	}
	
	@Given("move1jack")
	public Game move2jill (Game game) {
		game.movePlayer(3);
		assertEquals("[4Slow down!<Jack>]", game.getSquare(4).toString());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals("[1<Jill>]", game.firstSquare().toString());
		return game;
	}
	
	@Given("move2jill")
	public Game move3jackSlowDownFour (Game game) {
		game.movePlayer(4);
		assertTrue(!(game.getSquare(4).isOccupied()));
		assertTrue(game.getSquare(6).isOccupied());
		assertEquals("[6<Jack>]", game.getSquare(6).toString());
		assertEquals("[4Slow down!]", game.getSquare(4).toString());
		return game;
	}
	
	@Given("move2jill")
	public Game move3jackSlowDownFive (Game game) {
		game.movePlayer(5);
		assertTrue(!(game.getSquare(4).isOccupied()));
		assertTrue(game.getSquare(6).isOccupied());
		assertEquals("[6<Jack>]", game.getSquare(6).toString());
		assertEquals("[4Slow down!]", game.getSquare(4).toString());
		return game;
	}

	@Given("move2jill")
	public Game move3jackSlowDownOne (Game game) {
		game.movePlayer(1);
		assertTrue(!(game.getSquare(4).isOccupied()));
		assertTrue(game.getSquare(5).isOccupied());
		assertEquals("[5<Jack>]", game.getSquare(5).toString());
		assertEquals("[4Slow down!]", game.getSquare(4).toString());
		return game;
	}
}