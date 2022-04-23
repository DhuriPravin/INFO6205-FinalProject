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

    public static void flushAllLogs()
    {
        try
        {
            Set<FileAppender> flushedFileAppenders = new HashSet<FileAppender>();
            Enumeration currentLoggers = LogManager.getLoggerRepository().getCurrentLoggers();
            while(currentLoggers.hasMoreElements())
            {
                Object nextLogger = currentLoggers.nextElement();
                if(nextLogger instanceof Logger)
                {
                    Logger currentLogger = (Logger) nextLogger;
                    Enumeration allAppenders = currentLogger.getAllAppenders();
                    while(allAppenders.hasMoreElements())
                    {
                        Object nextElement = allAppenders.nextElement();
                        if(nextElement instanceof FileAppender)
                        {
                            FileAppender fileAppender = (FileAppender) nextElement;
                            if(!flushedFileAppenders.contains(fileAppender) && !fileAppender.getImmediateFlush())
                            {
                                flushedFileAppenders.add(fileAppender);
                                //log.info("Appender "+fileAppender.getName()+" is not doing immediateFlush ");
                                fileAppender.setImmediateFlush(true);
                                currentLogger.info("FLUSH");
                                fileAppender.setImmediateFlush(false);
                            }
                            else
                            {
                                //log.info("fileAppender"+fileAppender.getName()+" is doing immediateFlush");
                            }
                        }
                    }
                }
            }
        }
        catch(RuntimeException e)
        {
            logger.error("Failed flushing logs",e);
        }
    }

    public static void main(String[] args) {
         BasicConfigurator.configure();
         flushAllLogs();

         Welcome.welcome();

         System.out.println(" " +
                 " ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                 "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                 " ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ \n" +
                 "     ▐░▌          ▐░▌     ▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░▌          \n" +
                 "     ▐░▌          ▐░▌     ▐░▌                    ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ \n" +
                 "     ▐░▌          ▐░▌     ▐░▌                    ▐░▌     ▐░░░░░░░░░░░▌▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░░░░░░░░░░░▌\n" +
                 "     ▐░▌          ▐░▌     ▐░▌                    ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀ \n" +
                 "     ▐░▌          ▐░▌     ▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░▌                    ▐░▌     ▐░▌       ▐░▌▐░▌          \n" +
                 "     ▐░▌      ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄           ▐░▌     ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄           ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ \n" +
                 "     ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌          ▐░▌     ▐░▌       ▐░▌▐░░░░░░░░░░░▌          ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                 "      ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀            ▀       ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀            ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" +
                 "                                                                                                                               ");

         System.out.println("Made by: ");
         System.out.println("- Prathamesh Sahasrabuddhe 002117703");
         System.out.println("- Vivek Sharma 002105272");
         System.out.println("- Pravin Dhuri 002138314");
         System.out.println("\n");

        MenaceTrainStrategy menace = new MenaceTrainStrategy();
        RandomTrainStrategy random = new RandomTrainStrategy();
        OptimalStrategy perfect = new OptimalStrategy();
        HumanInput human = new HumanInput();

        Participant[] participants = new Participant[2];

        participants[0] = new MenaceTrainStrategy();
        boolean stop = false;
        while(!stop) {
            System.out.println("(1) Play with Menace");
            System.out.println("(2) Train Menace with Optimal Strategy");
            System.out.println("(3) Train Menace Randomly");
            System.out.println("(4) Train Menace Vs. Menace");
            System.out.println("(5) Reset Training");
            System.out.println("(E) Exit");
            String userInput = null;
            try {
                userInput = Utils.console.readLine().toLowerCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(userInput.equals("e")) {
                stop = true;
            } else if (userInput.equals("4")) {
                participants[1] = menace;
                train(participants);
            } else if (userInput.equals("3")) {
                participants[1] = random;
                train(participants);
            } else if (userInput.equals("5")) {
                menace = new MenaceTrainStrategy();
                participants[0] = menace;
                menace = new MenaceTrainStrategy();
            } else if (userInput.equals("2")) {
                participants[1] = perfect;
                train(participants);
            } else if (userInput.equals("1")) {
                Utils.removeAll();
                TicTacToeUI.addAllButtons();
                participants[1] = human;
                TicTacToeGame ticTacTieGame;
                ticTacTieGame = new TicTacToeGame();
                int chance = 0;
                participants[chance%2].startNewGame(ValuesOfCell.X);
                participants[(chance+1)%2].startNewGame(ValuesOfCell.O);
                while(ticTacTieGame.getStateOfGame() == StatesOfAnyGame.Playing) {
                    participants[chance%2].start(ticTacTieGame);
                    TicTacToeUI.dispatchWindows();
                    TicTacToeUI.showUI();
                    chance++;
                }
                if (ticTacTieGame.getStateOfGame() == StatesOfAnyGame.HumanWins) {
                    WinnerGif.winner();
                } else if (ticTacTieGame.getStateOfGame() == StatesOfAnyGame.MenaceWins) {
                    LostGif.lost();
                } else if (ticTacTieGame.getStateOfGame() == StatesOfAnyGame.conditionDraw) {
                    GameDrawGif.draw();
                }
                participants[0].gameOver(ticTacTieGame.getStateOfGame());
                participants[1].gameOver(ticTacTieGame.getStateOfGame());

                System.out.println(ticTacTieGame);
                System.out.println("Result: " + ticTacTieGame.getStateOfGame());
                System.out.println(participants[0]);
            }
        }
    }
}

