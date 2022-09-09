/**
 * this class represents the board object of the current play
 */
public class Board {

    public static final int SIZE=3;
    public static final int WIN_STREAK = 3;

    private final Mark[][] board = new Mark[SIZE][SIZE];
    private  int filledPlaces;
    private Mark theWinner;

    /**
     * the constructor of the board . initializes the fields
     */
    public Board(){
        for (int row =0; row< board.length; row++){
            for (int col = 0;  col < board[row].length; col++){
                board[row][col] = Mark.BLANK;
            }
        }
        this.filledPlaces = 0;
        this.theWinner = Mark.BLANK;


    }

    /**
     * this function puts the given mark in the board in the given coordinates
     * in case of winning situation it updates the winner field . add one to the filledplaces field
     * @param mark the mark to put in
     * @param row the number of row
     * @param col the number of col
     * @return returns false in the given coordinates are illegal, true in successes
     */

    public boolean putMark(Mark mark, int row, int col){
        if(row< 0 || row >= SIZE || col <0 || col >= SIZE)
            return false;
        if(board[row][col] != Mark.BLANK){
            return false;
        }
        else{
            board[row][col] = mark;
            if(alldirectionsequense(mark,row,col,0,1)>=WIN_STREAK ||
                    alldirectionsequense(mark,row,col,-1,0)>=WIN_STREAK ||
                    alldirectionsequense(mark,row,col,-1,-1)>=WIN_STREAK ||
                    alldirectionsequense(mark,row,col,-1,1) >= WIN_STREAK){
                    this.theWinner = mark;
            }
            this.filledPlaces++;

            return  true;
        }

    }


    /**
     * this function checks  matched sequences in all directions of the given mark
     * @param mark the to search sequence of
     * @param row the number of row coordinate
     * @param col the number of col coordinate
     * @param rowDelta to add to the row number
     * @param colDelta to add to the col number
     * @return the length of the sequence
     */
    private int alldirectionsequense( Mark mark, int row, int col, int rowDelta, int colDelta){
        return countMarkInDirection(row,col,rowDelta,-colDelta,mark) +
                countMarkInDirection(row,col,-rowDelta,colDelta,mark) -1  ;

    }

    /**
     * this functions returns the mark that appears in the given coordinates
     * @param row the number of row coordinate
     * @param col the number of col coordinate
     * @return returns the mark that appears in the given coordinates
     */
    public  Mark getMark(int row, int col){
        if(row< 0 || row >= SIZE || col <0 || col >= SIZE){
            return Mark.BLANK;}
        else{
            return board[row][col];

        }

    }

    /**
     *
     * @return returns true if the game  ended, false otherwise
     */
    public  boolean gameEnded(){
        if(this.filledPlaces == (SIZE*SIZE)){
            return  true;
        }
        if(this.theWinner != Mark.BLANK){
            return true;
        }
        return false;



    }

    /**
     *
     * @return returns the winner of the game
     */
    public Mark getWinner(){
        return this.theWinner;

    }

    /**
     * this function counts the length of found sequence(of the same mark)
     * @param row the number of row coordinate
     * @param col the number of col coordinate
     * @param rowDelta the number to add to the row
     * @param colDelta the number to add to the col
     * @param mark this function counts the sequence of this mark
     * @return the length of the found sequence from the given coordinate to the end of the board in given direction
     */
    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }


}
