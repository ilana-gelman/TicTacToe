 import java.util.Random;

 /**
  * this class represents the object of the whatever player
  */
 public class WhateverPlayer implements  Player {
    /**
     * this function handles with the current player turn(mr.whatever)
     * chooses random coordinates and places them in the board(with putMark function) if the cell was empty
     * @param board the current board
     * @param mark the mark to add

     */

    @Override
    public void playTurn(Board board, Mark mark) {
        Random rand = new Random();
        int row= rand.nextInt(Board.SIZE);
        int col= rand.nextInt(Board.SIZE);
        while (!board.putMark(mark,row,col)){
            row= rand.nextInt(Board.SIZE);
            col= rand.nextInt(Board.SIZE);

        }
    }
}
