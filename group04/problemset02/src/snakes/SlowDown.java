package snakes;

public class SlowDown extends Square {

	public SlowDown(Game game, int position) {
		super(game, position);
	}

	protected String squareLabel() {
		return Integer.toString(position) + "Slow down!";
	}

	public ISquare moveAndLand(int moves) {
		assert moves >= 0;
		return moves <= 1 ? game.findSquare(position, moves).landHereOrGoHome() : game.findSquare(position, moves/2);
	}
}
