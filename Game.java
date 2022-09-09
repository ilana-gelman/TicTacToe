/**
 * this class represents the game object of one single game
 */
public class Game {
    private final Renderer renderer;
    private final Player playerX;
    private final  Player playerO;

    /**
     * the constructor of the game. initializes the class fields
     * @param renderer the Renderer object
     * @param playerX the x mark player
     * @param playerO the o mark player
     */
    public Game(Renderer renderer, Player playerX, Player playerO){
        this.renderer =renderer;
        this.playerX = playerX;
        this.playerO = playerO;

    }

    /**
     * this function handles the run proses of the game
     * @return returns the winner of the game
     */
    public Mark run() {
        Board board = new Board();
        int counter = 0;
        while (!board.gameEnded()) {
            if (counter % 2 == 0) {
                this.renderer.renderBoard(board);
                this.playerX.playTurn(board, Mark.X);
                counter++;
            } else {
                this.renderer.renderBoard(board);
                this.playerO.playTurn(board, Mark.O);
                counter++;
            }
        }
        this.renderer.renderBoard(board);
        return  board.getWinner();
    }




}
