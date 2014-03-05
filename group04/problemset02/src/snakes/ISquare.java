package snakes;

/**
 * This Interface promulgates Square. It allows to connect multiple Squares.
 *  <p>
 *  It contains the following headers
 * <p>
 * @author Peter Allemann & Mathias Fuchs
 */


public interface ISquare {
	/**
     * Return the position of the Player object
     * @return Position of Player object
     */
	public int position();
	/**
	 * finds the square where the player object should be moved to. 
	 * invokes landHereOrGoHome().
	 * @param moves the moves which a player object moves.
	 * @return ISquare ISquare of the destination 
	 */
	
	public ISquare moveAndLand(int moves);
	/**
     * Determine whether the actual Square is the first Square
     * @return <CODE>true</CODE> if the container is the first Square. 
     * <CODE>count == 0</CODE>, <CODE>false</CODE> 
     * otherwise
     */
	public boolean isFirstSquare();
	/**
     * Determine whether the actual Square is the last Square
     * @return <CODE>true</CODE> if the container is the last Square. 
     * <CODE>count == 0</CODE>, <CODE>false</CODE> 
     * otherwise
     */
	public boolean isLastSquare();
	/** 
	 * Accepts a player object on the container.
	 * @param player the player object to be accepted on the field
	 */
	public void enter(Player player);
	/** 
	 * Removes the current player object from the container.
	 * @param player the player object to be removed from the container
	 */
	public void leave(Player player);
	/**
     * Determine whether this container is occupied or not.
     * @return <CODE>true</CODE> if the container is occupied: 
     * <CODE>count == 0</CODE>, <CODE>false</CODE> 
     * otherwise
     */
	public boolean isOccupied();
	/**
	 * invokes isOccupied(), if isOccupied() <CODE> true <CODE> then 
	 * returns the player object to the first square. If the container is empty </CODE> count == 0 </CODE>, <CODE> false </CODE> 
	 * then it returns the current square.
	 * @return ISquare object
	 */
	public ISquare landHereOrGoHome();
}
