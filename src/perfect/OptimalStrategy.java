package src.perfect;

import src.game.StatesOfAnyGame;
import src.game.TicTacToeGame;
import src.utils.Utils;

public class Optimal_Tic_Tac_Toe extends TicTacToeGame {
    public static final int noSetting = 0;
    public static final int conditionWin  = 1;
    public static final int conditionLose = 2;
    public static final int conditionDraw = 3;
    private int[] possibleOutcomes;
    private int outcomeOfGame;
    
}