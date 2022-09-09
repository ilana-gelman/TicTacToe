import  java.util.Scanner;

/**
 * this class represents the object of the human player
 */
public class HumanPlayer implements Player {
    private  final Scanner in;

    /**
     * the constructor of the human player. Initializes the scanner
     */
    public  HumanPlayer(){
        this.in= new Scanner((System.in));

    }

    /**
     * this function handles with the current player turn(human player)
     * gets legal input from the player (coordinates) and puts the mark in the board
     * @param board the current board
     * @param mark the mark to add
     */
    @Override
    public void playTurn(Board board, Mark mark){
        System.out.println("Player " + mark + ",type coordinates:");
        int num = in.nextInt();
        int row = num/10-1 ;
        int col = num%10-1 ;
        while (!board.putMark(mark, row, col)){
            System.out.println("Invalid coordinates, type again: ");
            num = in.nextInt();
            row = num/10-1 ;
            col = num%10-1 ;

        }

    }
}
