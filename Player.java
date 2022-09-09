/**
 * the interface of general player.
 */
public interface Player{
    /**
     * all the classes that implements this interface uses the playTurn function,that handles with the current player turn
     * and puts the given mark in the correct place in the board according to the player strategy
     * @param board the current board
     * @param mark the mark to place in the board
     */
    void playTurn(Board board, Mark mark);

}
