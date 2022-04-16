package src.menace;

import src.game.Participant;
import src.game.StatesOfAnyGame;
import src.game.TicTacToeGame;
import src.game.ValuesOfCell;

import java.util.LinkedList;

public class MenaceTrainStrategy extends Participant {

	int beta =3;//conditionWin
	int gamma=-1;//loss
	int delta=1;//conditionDraw

	// Storing the list of all similar games
	private LinkedList<LinkedList<Menace_Tic_Tac_Toe>> totalPlayoffs;

	// Storing the list of all matches for Menace
	private LinkedList<LinkedList<Menace_Tic_Tac_Toe>> menaceMatchboxes;

	// Storing the list of all matches for Human
	private LinkedList<LinkedList<Menace_Tic_Tac_Toe>> humanMatchboxes;

	// Storing the list of all variables depending on the player
	private LinkedList<LinkedList<Menace_Tic_Tac_Toe>> possibleCasesOrMatchboxes;

	// Storing the list of gamesPlayed
	private LinkedList<Menace_Tic_Tac_Toe> gamesPlayed;

	public MenaceTrainStrategy(){
		super();
		totalPlayoffs = new LinkedList<LinkedList<Menace_Tic_Tac_Toe>>();
		totalPlayoffs.add(new LinkedList<Menace_Tic_Tac_Toe>());
		Menace_Tic_Tac_Toe initialGame = new Menace_Tic_Tac_Toe();
		totalPlayoffs.get(0).add(initialGame);
		for(int i=1; i<= 9; i++) {
			LinkedList<Menace_Tic_Tac_Toe> menace_tic_tac_toes = new LinkedList<Menace_Tic_Tac_Toe>();
			totalPlayoffs.add(menace_tic_tac_toes);
			for(Menace_Tic_Tac_Toe MenaceGame: totalPlayoffs.get(i-1)){
				if(MenaceGame.getStateOfGame() == StatesOfAnyGame.Playing) {
					for(int j = 0; j < 9; j++) {
						if(MenaceGame.returnValueAtParticularIndex(j) == ValuesOfCell.EMPTY) {
							Menace_Tic_Tac_Toe newMenaceGame = new Menace_Tic_Tac_Toe(MenaceGame,j);
							boolean New = true;
							for(Menace_Tic_Tac_Toe existingMenaceGame: totalPlayoffs.get(i)) {
								if(newMenaceGame.equalsWithSymmetry(existingMenaceGame)) {
									New = false;
									break;
								}
							}
							if(New) {
								menace_tic_tac_toes.add(newMenaceGame);
							}		
						}
					}
				}
			}
		}
		menaceMatchboxes = new LinkedList<LinkedList<Menace_Tic_Tac_Toe>>();
		humanMatchboxes = new LinkedList<LinkedList<Menace_Tic_Tac_Toe>>();

		for (LinkedList<Menace_Tic_Tac_Toe> menaceTicTacToe: totalPlayoffs) {
			LinkedList<Menace_Tic_Tac_Toe> menace_tic_tac_toes = new LinkedList<Menace_Tic_Tac_Toe>();
			for (Menace_Tic_Tac_Toe matchbox: menaceTicTacToe) {
				if (matchbox.getTotalRounds() % 2 == 0  && matchbox.getStateOfGame() == StatesOfAnyGame.Playing && matchbox.getTotalRounds() < 8) {
					menace_tic_tac_toes.add(matchbox);
				}
			}
			if (!menace_tic_tac_toes.isEmpty()) {
				menaceMatchboxes.add(menace_tic_tac_toes);
			}
		}


		for (LinkedList<Menace_Tic_Tac_Toe> list: menaceMatchboxes) {
			for (Menace_Tic_Tac_Toe gameMatchBox: list) {
				LinkedList<Menace_Tic_Tac_Toe> potentiallySymmetricalGames = new LinkedList<Menace_Tic_Tac_Toe>();
				for (int indexCell = 0; indexCell < 9; indexCell++) {
					if (gameMatchBox.returnValueAtParticularIndex(indexCell) == ValuesOfCell.EMPTY) {
						Menace_Tic_Tac_Toe nextGame = new Menace_Tic_Tac_Toe(gameMatchBox, indexCell);
						boolean exists = false;
						int i = 0;
						while (!exists && i < potentiallySymmetricalGames.size()) {
							if (potentiallySymmetricalGames.get(i++).equalsWithSymmetry(nextGame)) {
								exists = true;
							}
						}
						if (!exists) {
							gameMatchBox.AssignBeads(indexCell);
						}
						potentiallySymmetricalGames.add(nextGame);
					}
				}
			}
		}

		for (LinkedList<Menace_Tic_Tac_Toe> menace_tic_tac_toes: totalPlayoffs) {
			LinkedList<Menace_Tic_Tac_Toe> newMenance = new LinkedList<Menace_Tic_Tac_Toe>();
			for (Menace_Tic_Tac_Toe gameMatchBox: menace_tic_tac_toes) {
				if (gameMatchBox.getTotalRounds() % 2 == 1  && gameMatchBox.getStateOfGame() == StatesOfAnyGame.Playing && gameMatchBox.getTotalRounds() < 8) {
					newMenance.add(gameMatchBox);
				}
			}
			if (!newMenance.isEmpty()) {
				humanMatchboxes.add(newMenance);
			}
		}

		for (LinkedList<Menace_Tic_Tac_Toe> menace_tic_tac_toes: humanMatchboxes) {
			for (Menace_Tic_Tac_Toe gameMatchBox: menace_tic_tac_toes) {
				LinkedList<Menace_Tic_Tac_Toe> potentiallySymmetricalGames = new LinkedList<Menace_Tic_Tac_Toe>();
				for (int indexCell = 0; indexCell < 9; indexCell++) {
					if (gameMatchBox.returnValueAtParticularIndex(indexCell) == ValuesOfCell.EMPTY) {
						Menace_Tic_Tac_Toe nextGame = new Menace_Tic_Tac_Toe(gameMatchBox, indexCell);
						boolean exists = false;
						int i = 0;
						while (!exists && i < potentiallySymmetricalGames.size()) {
							if (potentiallySymmetricalGames.get(i++).equalsWithSymmetry(nextGame)) {
								exists = true;
							}
						}
						if (!exists) {
							gameMatchBox.AssignBeads(indexCell);
						}
						potentiallySymmetricalGames.add(nextGame);
					}
				}
			}
		}
	}

	@Override
	public void startNewGame(ValuesOfCell currMov) {
		super.startNewGame(currMov);
	    if (currMov == ValuesOfCell.X) {
	    	possibleCasesOrMatchboxes = menaceMatchboxes;
		}
		else if (currMov == ValuesOfCell.O) {
	    	possibleCasesOrMatchboxes = humanMatchboxes;
		}
		gamesPlayed = new LinkedList<Menace_Tic_Tac_Toe>();
	}
}
