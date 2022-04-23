package src.game;

public abstract class Participant {

	private int LoseCounts;
	private int WinCounts;
	private int DrawCounts;
	private int GamesCount;
	private char[] sWindow;
	private int currSIdx;
	protected ValuesOfCell currMov;

	public static final char Winn = 'w';
	public static final char conditionLose = 'l';
	public static final char DDraw = 'd';

	public Participant(){
		LoseCounts = 0;
		WinCounts = 0;
		DrawCounts = 0;
		GamesCount = 0;
		sWindow = new char[200];
		currSIdx= 0;
	}

	public abstract void start(TicTacToeGame ticTacToeGame);

	public void startNewGame(ValuesOfCell currMov){
		this.currMov = currMov;
	}

	public void gameOver(StatesOfAnyGame outcome){
		if(outcome == StatesOfAnyGame.conditionDraw) {
			DrawCounts++;
			sWindow[currSIdx] = DDraw;
		} else if (outcome == StatesOfAnyGame.MenaceWins) {
			if(currMov == ValuesOfCell.X) {
				LoseCounts++;
				sWindow[currSIdx] = Winn;
			} else {
				WinCounts++;
				sWindow[currSIdx] = conditionLose;
			}
		} else if (outcome == StatesOfAnyGame.HumanWins) {
			if(currMov == ValuesOfCell.O) {
				LoseCounts++;
				sWindow[currSIdx] = Winn;
			} else {
				WinCounts++;
				sWindow[currSIdx] = conditionLose;
			}
		} else {
			throw new IllegalArgumentException("Final Result can't be " + outcome);
		}
		GamesCount++;
		currSIdx = (currSIdx+1)% 200;
	}


	public String toString(){
		String outcome;

		outcome = "Player won: " + WinCounts + ", Lost: "
				+ LoseCounts + ", and Draw: " + DrawCounts + ".";

		if(GamesCount >= 200) {
			int wins = 0;
			int loses = 0;
			int draws = 0;
			for(char s: sWindow) {
				switch(s){
					case Winn:
						wins++;
						break;
					case conditionLose:
						loses++;
						break;
					case DDraw:
						draws++;
						break;
					default:
						System.out.println("Value not known: " + s);
				}
			}
			outcome += " In latest 200 rounds, player won: " + wins + " rounds, lost: "
				+ loses + " rounds, and draws: " + draws + " rounds.";
		}
		return outcome;
	}

	public String showData() {
		String outcome;

		outcome = LoseCounts + "," + WinCounts + "," + DrawCounts;

		if(GamesCount >= 2000) {
			int wins = 0;
			int loses = 0;
			int draws = 0;
			for(char s: sWindow) {
				switch(s){
					case Winn:
						wins++;
						break;
					case conditionLose:
						loses++;
						break;
					case DDraw:
						draws++;
						break;
					default:
						System.out.println("Value not known: " + s);
				}
			}
//			outocme += " In latest 200 rounds, player won: " + wins + " rounds, lost: "
//					+ loses + " rounds, and draws: " + draws + " rounds.";
		}
		return outcome;
	}
	 
}