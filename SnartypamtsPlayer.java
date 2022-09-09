/**
 * this class represents the snartypamts player object
 */
public class SnartypamtsPlayer  implements  Player{
    /**
     * this function handles with the current player turn(mr.Snartypamts)
     * goes over the board column by  column  begins with the second column and searches for empty place to put the mark
     * @param board the current board
     * @param mark the mark to add
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        for(int i=1 ; i<Board.SIZE ;i++){
            for(int j=0; j< Board.SIZE ;j++){
                if(board.putMark(mark, j, i)){
                    return;
                }
            }
        }
    }
}
