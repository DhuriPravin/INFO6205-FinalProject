package src.perfect;

import src.game.Participant;
import src.game.StatesOfAnyGame;
import src.game.TicTacToeGame;
import src.game.ValuesOfCell;

import java.util.LinkedList;

public class OptimalStrategy extends Participant {

    private LinkedList<LinkedList<Optimal_Tic_Tac_Toe>> totalPlayoffs;

    public OptimalStrategy(){
        super();
        totalPlayoffs = new LinkedList<LinkedList<Optimal_Tic_Tac_Toe>>();
        totalPlayoffs.add(new LinkedList<Optimal_Tic_Tac_Toe>());
        totalPlayoffs.get(0).add(new Optimal_Tic_Tac_Toe());

        //Concatenating to previous games.
        for(int i=1; i<= 9; i++) {
            LinkedList<Optimal_Tic_Tac_Toe> newPerfectTicTacToe;
            newPerfectTicTacToe = new LinkedList<Optimal_Tic_Tac_Toe>();
            totalPlayoffs.add(newPerfectTicTacToe);
            for(Optimal_Tic_Tac_Toe optimal_tic_tac_toe: totalPlayoffs.get(i-1)){
                if(optimal_tic_tac_toe.getStateOfGame() == StatesOfAnyGame.Playing) {
                    for(int j = 0; j < 9; j++) {
                        if(optimal_tic_tac_toe.returnValueAtParticularIndex(j) == ValuesOfCell.EMPTY) {
                            Optimal_Tic_Tac_Toe newGame = new Optimal_Tic_Tac_Toe(optimal_tic_tac_toe,j);
                            // Game not found check
                            boolean New = true;
                            for(Optimal_Tic_Tac_Toe existingGame: totalPlayoffs.get(i)){
                                if(newGame.equalsWithSymmetry(existingGame)){
                                    New = false;
                                    break;
                                }
                            }
                            if(New) {
                                newPerfectTicTacToe.add(newGame);
                            }
                        }
                    }
                }

            }
        }

        
    }
}