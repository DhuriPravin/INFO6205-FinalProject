package src.perfect;

import src.game.StatesOfAnyGame;
import src.game.TicTacToeGame;

public class Optimal_Tic_Tac_Toe extends TicTacToeGame {
    public static final int noSetting = 0;
    public static final int conditionWin  = 1;
    public static final int conditionLose = 2;
    public static final int conditionDraw = 3;
    private int[] possibleOutcomes;
    private int outcomeOfGame;

    public Optimal_Tic_Tac_Toe(){
        super(3,3,3);
        possibleOutcomes = new int[9];
        outcomeOfGame = noSetting;
    }

    public Optimal_Tic_Tac_Toe(Optimal_Tic_Tac_Toe base, int following){
        super(base,following);
        possibleOutcomes = new int[9];
        outcomeOfGame = noSetting;
    }

    public void setOutcomeOfMove(int playTurn, int result){
        if(playTurn < 0 || playTurn >= possibleOutcomes.length ||
                result < conditionWin || result > conditionDraw || possibleOutcomes[playTurn] != 0 ) {
            throw new IllegalArgumentException();
        }
        possibleOutcomes[playTurn] = result;
        if(result == conditionWin) {
            outcomeOfGame = conditionWin;
        } else if (result == conditionDraw && outcomeOfGame != conditionWin ) {
            outcomeOfGame = conditionDraw;
        } else if (result == conditionLose && outcomeOfGame == noSetting) {
            outcomeOfGame = conditionLose;
        }
    }

    public int getOutcomeOfGame() {
        if(getStateOfGame() == StatesOfAnyGame.MenaceWins || getStateOfGame() == StatesOfAnyGame.HumanWins ){
            // from the viewpoint of a player who would have to start following, a
            // game that has just been won is losing
            return conditionLose;
        } else if(getStateOfGame() == StatesOfAnyGame.conditionDraw ){
            return conditionDraw;
        } else {
            return outcomeOfGame;
        }
    }

    public int selectOptimalMove(){
        if(getStateOfGame() != StatesOfAnyGame.Playing){
            throw new IllegalStateException("Game does not exist or already finished");
        }
        int choices = 0;
        for(int i : possibleOutcomes) {
            if(i == outcomeOfGame)
                choices++;
        }
        int selectRandomChoice = Utils.RandomGenerator.nextInt(choices);
        int currentChoice = 0;
        boolean find = true;
        while(find) {
            if(possibleOutcomes[boardTransformation[currentChoice]] == outcomeOfGame){
                if(selectRandomChoice == 0) {
                    find = false;
                } else {
                    selectRandomChoice--;
                    currentChoice++;
                }
            } else {
                currentChoice++;
            }
        }
        return currentChoice;
    }

}
