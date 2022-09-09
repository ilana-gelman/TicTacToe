/**
 * this class represents the object of the clever player
 */
public class CleverPlayer implements Player {
    /**
     * this function handles with the current player turn(mrs.clever)
     * goes over the board row by row and searches for empty place to put the mark
     * @param board the current board
     * @param mark the mark to add
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        for(int i=0 ; i<Board.SIZE ;i++){
            for(int j=0; j< Board.SIZE ;j++){
                if(board.putMark(mark, i, j)){
                    return;
                }
            }
        }

    }
}
