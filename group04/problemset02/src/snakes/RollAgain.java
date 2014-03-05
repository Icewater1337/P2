package snakes;

public class RollAgain extends Square {

	private int roll;
	Die die = new Die();

	private boolean invariant() {
		return isValidRoll(roll);
	}

	private boolean isValidRoll(int roll) {
		return roll >= 1 && roll <= 6
			&& game.isValidPosition(position + roll);
	}

	public RollAgain(Game game, int position) {
		super(game, position);
	}

	protected String squareLabel() {
		return Integer.toString(position) + "Roll again!";
	}

	public ISquare landHereOrGoHome() {
		System.out.println("Roll again!");
		return this.destination().landHereOrGoHome();
	}
	
	protected ISquare destination() {
		roll = this.roll();
		assert invariant();
		return game.getSquare(position+roll);
	}

	protected int roll() {
		return this.die.roll();
	}
}
