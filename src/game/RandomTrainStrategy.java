package src.game;

import src.utils.Utils;

public class RandomTrainStrategy extends Participant {

	public  void start(TicTacToeGame ticTacToeGame) {

		if(ticTacToeGame.getTotalRounds() == ticTacToeGame.rows*ticTacToeGame.columns){
			throw new IllegalArgumentException("Game does not exists or already finished!");
		}
	
		int option;
		do {
			option = Utils.RandomGenerator.nextInt(ticTacToeGame.rows*ticTacToeGame.columns);
		} while (ticTacToeGame.returnValueAtParticularIndex(option) != ValuesOfCell.EMPTY);

		ticTacToeGame.start(option);
	}

}
