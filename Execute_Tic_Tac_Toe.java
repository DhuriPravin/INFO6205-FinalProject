import org.apache.log4j.FileAppender;
import src.game.*;
import src.human.HumanInput;
import src.menace.MenaceTrainStrategy;
import src.perfect.OptimalStrategy;
import src.ui.*;
import src.game.StatesOfAnyGame;
import src.utils.FileUtils;
import src.utils.Utils;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import src.game.ValuesOfCell;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;


public class Execute_Tic_Tac_Toe {

    public static final int NumberOfTraining = 10000;
    private static final Logger logger = LogManager.getLogger(Execute_Tic_Tac_Toe.class);

    private static void train(Participant[] participants) {

        BasicConfigurator.configure();
        flushAllLogs();

        int NumberOfTrainings = NumberOfTraining;

        for(int i=1;i<NumberOfTrainings;i++){
            TicTacToeGame ticTacToeGame = new TicTacToeGame();
            int chance = 0;
            participants[chance%2].startNewGame(ValuesOfCell.X);
            participants[(chance+1)%2].startNewGame(ValuesOfCell.O);
            while(ticTacToeGame.getStateOfGame() == StatesOfAnyGame.Playing) {
                participants[chance%2].start(ticTacToeGame);
                chance++;
            }
            String data = i + ", " + chance + ", " + participants[0].showData() + ", " + ticTacToeGame.getStateOfGame();
            FileUtils.writeResultsToFile(data, System.currentTimeMillis());
            participants[0].gameOver(ticTacToeGame.getStateOfGame());
            participants[1].gameOver(ticTacToeGame.getStateOfGame());
        }
        System.out.println("Menace: " + participants[0]) ;
        System.out.println("Player: " + participants[1]) ;

    }
}