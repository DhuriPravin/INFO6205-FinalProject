package src.human;

public class HumanInput extends Participant {

	public  void start(TicTacToeGame ticTacToeGame) {

		if(ticTacToeGame.getTotalRounds() == ticTacToeGame.rows*ticTacToeGame.columns){
			throw new IllegalArgumentException("Game doesn't exist!");
		}
	}

}
