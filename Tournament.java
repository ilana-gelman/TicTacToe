import java.util.Arrays;

/**
 * this class represents the tournament object that run the tournament between the players
 */
public class Tournament {

    private int rounds;
    private Renderer renderer;
    private Player player1;
    private  Player player2;
    private  static  final  int ROUNDS_NUM =0;
    private  static  final  int RENDER_TYPE =1;
    private  static  final  int PLAYER_1 =2;
    private  static  final  int PLAYER_2 =3;


    /**
     * the constructor of the class. initializes all the fields
     * @param rounds the number of rounds to play
     * @param renderer console if the print of the board is needed , none otherwise
     * @param players array with the current players
     */
    public Tournament(int rounds, Renderer renderer , Player[] players){
        this.rounds=rounds;
        this.renderer=renderer;
        this.player1 = players[0];
        this.player2 =players[1];

    }

    /**
     * this function handles and runs the tournament between the current players
     * the tournament builds of multiple rounds, and the number of wins are saved in result array
     * (in the first index is the number of wins of the first player, the second index for the second player and
     * the third index for draw)
     */
    public  void playTournament(){
        int[] resultArray = {0, 0, 0};
        Player[] players ={this.player1 ,this.player2};
        for( int z=0;z<this.rounds;z++){
                Game game = new Game(this.renderer,players[z%2], players[(z+1)%2]);
                Mark theWinner =game.run();
                if (theWinner == Mark.BLANK){
                    resultArray[2] +=1;
                }
                 if(theWinner == Mark.X){
                     resultArray[z%2] +=1;
                 }

                if (theWinner == Mark.O){
                    resultArray[(z+1)%2] +=1;
                }

            }
        System.out.print("=== player 1: "+resultArray[0] +" | player 2: " + resultArray[1] + " | Draws: " + resultArray[2] + " ===\r");






    }


    /**
     * the main function manages the game, connects between the objects
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int rounds = Integer.parseInt(args[ROUNDS_NUM]);
        PlayerFactory playerFactory = new PlayerFactory();
        RendererFactory rendererFactory =new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(args[RENDER_TYPE]);
        Player player1 = playerFactory.buildPlayer(args[PLAYER_1]);
        Player player2 = playerFactory.buildPlayer(args[PLAYER_2]);
        Player[] players = {player1, player2};
        Tournament tournament =new Tournament(rounds,renderer, players);
        tournament.playTournament();




    }
}
