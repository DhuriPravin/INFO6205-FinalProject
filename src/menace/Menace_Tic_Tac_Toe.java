package src.menace;

import src.game.StatesOfAnyGame;
import src.game.TicTacToeGame;
import src.utils.Utils;

public class Menace_Tic_Tac_Toe extends TicTacToeGame {

	private int[] bead;

	int alpha =8;//start

	private int totalBeads;

	private int playedCells;

	public Menace_Tic_Tac_Toe() {
		super(3,3,3);
		bead = new int[9];
		for (int indexCell = 0; indexCell < 9; indexCell++) { //Initializing 0 beads to each indexCell.
			bead[indexCell] = 0;
		}
		totalBeads = 0;
	}

	public Menace_Tic_Tac_Toe(Menace_Tic_Tac_Toe menaceTicTacToe, int next) {
		super(menaceTicTacToe, next);
		bead = new int[9];
		for (int indexCell = 0; indexCell < 9; indexCell++) {
			bead[indexCell] = 0;
		}
		totalBeads = 0;
	}

	public void AssignBeads(int indexCell) {
		if (indexCell < 0 || indexCell > 8) {
			throw new IllegalArgumentException("Incorrect Input");
		}
		if ((getTotalRounds() == 0 || getTotalRounds() == 1)) {
			bead[indexCell] += alpha;
			totalBeads += alpha;
		}
		else if ((getTotalRounds() == 2 || getTotalRounds() == 3)) {
			bead[indexCell] += alpha/2;
			totalBeads += alpha/2;
		}
		else if ((getTotalRounds() == 4 || getTotalRounds() == 5)) {
			bead[indexCell] += alpha/4;
			totalBeads += alpha/4;
		}
		else if ((getTotalRounds() == 6 || getTotalRounds() == 7 || getTotalRounds() == 8)) {
			bead[indexCell] += alpha/8;
			totalBeads += alpha/8;
		}
	}
}
