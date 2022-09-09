/**
 * the player's factory manages the chosen players
 */
public class PlayerFactory {
    /**
     * this function chooses the right player according the command line input and returns an interface of it
     * @param playerType string that represents the type of the player to make interface of
     * @return Player interface
     */
    Player buildPlayer(String playerType){
        switch (playerType){
            case "human":
                return new HumanPlayer();

            case "whatever":
                return  new WhateverPlayer();
            case  "clever":
                return  new CleverPlayer();
            case "snartypamts":
                return new SnartypamtsPlayer();
            default:
                return null;

        }

    }
}
