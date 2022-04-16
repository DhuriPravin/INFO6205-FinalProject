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
}
