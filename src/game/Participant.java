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



































}
