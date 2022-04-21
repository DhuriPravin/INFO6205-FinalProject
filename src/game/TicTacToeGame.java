package src.game;

import src.utils.Utils;

public class TicTacToeGame {

	private final ValuesOfCell[] board;

	private int totalRounds; // records total rounds

	private StatesOfAnyGame statesOfAnyGame; //records the current state of the game.

	public final int rows;

	public final int columns;

	public final int totalsCellsRequiredToWin; // number of indexCell of the same type * that must be aligned to conditionWin the game

	// list of all possible symmetries
    private  static final Symmetry[] allPossibleSymmetries = {Symmetry.ID, Symmetry.Rotation, Symmetry.Rotation,Symmetry.Rotation, Symmetry.HorizontalSymmetry, Symmetry.Rotation,Symmetry.Rotation, Symmetry.Rotation};

    private  static final Symmetry[] ALL_TRANSFORMATIONS_NON_SQUARE ={Symmetry.ID, Symmetry.HorizontalSymmetry,Symmetry.VerticalSymmetry, Symmetry.HorizontalSymmetry};

    private final Symmetry[] allSymmetries; // instance to record symmetry

    private int currentTransformation; // number of transformations so far

	public int[] boardTransformation;

	public TicTacToeGame(){ // constructor
		this(3,3,3);
	}

	public TicTacToeGame(int rows, int columns){
		this(rows, columns, 3);
	}

	public TicTacToeGame(int rows, int columns, int totalsCellsRequiredToWin){
		this.rows = rows;
		this.columns = columns;
		this.totalsCellsRequiredToWin = totalsCellsRequiredToWin;
		board = new ValuesOfCell[rows*columns];
		for(int i = 0; i < rows*columns ; i ++) {
			board[i] = ValuesOfCell.EMPTY;
		}
		totalRounds = 0;
		statesOfAnyGame = StatesOfAnyGame.Playing;
		if(rows == columns) {
			allSymmetries = allPossibleSymmetries;
		} else {
			allSymmetries = ALL_TRANSFORMATIONS_NON_SQUARE;
		}
		boardTransformation = new int[rows*columns];
		SymmetryReset();

	}

	public TicTacToeGame(TicTacToeGame base, int following){

		rows = base.rows;
		columns = base.columns;
		totalsCellsRequiredToWin = base.totalsCellsRequiredToWin;

		if(following < 0 || following >= rows*columns){
			throw new IllegalArgumentException("Wrong position: " + following);
		}

		if(base == null){
			throw new IllegalArgumentException("Wrong base: Null");
		}

		if(base.board[following] != ValuesOfCell.EMPTY) {
			throw new IllegalArgumentException("ValueInCell is not empty: " + following + " game " + base);
		}

		board = new ValuesOfCell[rows*columns];
		for(int i = 0; i < rows*columns ; i ++) {
			board[i] = base.board[i];
		}

		allSymmetries = base.allSymmetries;
		
		totalRounds = base.totalRounds+1;

		board[following] = base.nextValueInCell();

		if(base.statesOfAnyGame != StatesOfAnyGame.Playing) {
			statesOfAnyGame = base.statesOfAnyGame;
		} else {
			GameStateSetter(following);
		}

		SymmetryReset();
	}

	public boolean equals(Object o) {
		if(o == null) {
    		return false;
    	}
    	if(getClass() != o.getClass()){
    		return false;
    	}

    	TicTacToeGame ticTacToeGame = (TicTacToeGame)o;

    	if((totalRounds != ticTacToeGame.totalRounds) 	|| (rows != ticTacToeGame.rows) 	|| (columns != ticTacToeGame.columns)||	(totalsCellsRequiredToWin != ticTacToeGame.totalsCellsRequiredToWin)){
    		return false;
    	}
    	for(int i = 0; i < board.length ; i++ ) {
			if(board[i]!= ticTacToeGame.board[i]) {
				return false;
			}
		}
		return true;
    }

	public int getTotalRounds(){
		return totalRounds;
	}

	public StatesOfAnyGame getStateOfGame(){
		return statesOfAnyGame;
	}

	public ValuesOfCell nextValueInCell(){
		return (totalRounds%2 == 0) ? ValuesOfCell.X : ValuesOfCell.O;
	}

	public ValuesOfCell returnValueAtParticularIndex(int i) {

		if(i < 0 || i >= rows*columns){
			throw new IllegalArgumentException("Illegal position: " + i);
		}

		return board[i];
	}

	public void start(int i) {

		if(i < 0 || i >= rows*columns){
			throw new IllegalArgumentException("Wrong position: " + i);
		}
		if(board[i] != ValuesOfCell.EMPTY) {
			throw new IllegalArgumentException("ValueInCell is not empty: " + i + " game " + this);
		}

		board[i] = nextValueInCell();
		totalRounds++;
		if(statesOfAnyGame != StatesOfAnyGame.Playing) {
			System.out.println(" ");
		} else {
			GameStateSetter(i);
		}

	}

	int who = 0;

	private void GameStateSetter(int cellIndex){
		if (who == 0) {
			Utils.addDefaults();
			Utils.addText(cellIndex);
			who = 1;
		} else if (who == 1) {
			Utils.addDefaults();
			Utils.getText(cellIndex, "O");
			who = 0;
		}

		int left = Math.min(totalsCellsRequiredToWin-1,cellIndex%columns);
		int right= Math.min(totalsCellsRequiredToWin-1,columns - (cellIndex%columns +1));
		if( (ConsecutiveCounts(cellIndex-1, left,-1,board[cellIndex]) + ConsecutiveCounts(cellIndex+1, right,1,board[cellIndex])) >= totalsCellsRequiredToWin-1 ) {GameStateSetter(board[cellIndex]);
			return;
		}

		int up 	= Math.min(totalsCellsRequiredToWin-1,cellIndex/columns);
		int down= Math.min(totalsCellsRequiredToWin-1, rows - (cellIndex/columns +1));
		if( (ConsecutiveCounts(cellIndex-columns, up,-columns,board[cellIndex]) +
		   	 ConsecutiveCounts(cellIndex+columns, down,columns,board[cellIndex]))
			>= totalsCellsRequiredToWin-1 ) {
			GameStateSetter(board[cellIndex]);
			return;
		}

		int upLeft = Math.min(up, left);
		int downRight= Math.min(down, right);
		if( (ConsecutiveCounts(cellIndex-(columns+1), upLeft,-(columns+1),board[cellIndex]) +
		   	 ConsecutiveCounts(cellIndex+(columns+1), downRight,columns+1,board[cellIndex]))
			>= totalsCellsRequiredToWin-1 ) {
			GameStateSetter(board[cellIndex]);
			return;
		}

		int upRight= Math.min(up, right);
		int downLeft = Math.min(down, left);
		if( (ConsecutiveCounts(cellIndex-(columns-1), upRight,-(columns-1),board[cellIndex]) +
		   	 ConsecutiveCounts(cellIndex+(columns-1), downLeft,columns-1,board[cellIndex]))
			>= totalsCellsRequiredToWin-1 ) {
			GameStateSetter(board[cellIndex]);
			return;
		}


		if (totalRounds == rows*columns) {
			statesOfAnyGame = StatesOfAnyGame.conditionDraw;
		} else {
			statesOfAnyGame = StatesOfAnyGame.Playing;
		}

	}


	private int ConsecutiveCounts(int StartPosition, int StepsCount,
		int Gap, ValuesOfCell valueOfCell){

		int result= 0;
		for(int i = 0; i < StepsCount;i++){
			if(board[StartPosition + i*Gap] != valueOfCell)
				break;
			result++;
		}
		return result;
	}


	private void GameStateSetter(ValuesOfCell ValuesOfCell){
		switch(ValuesOfCell){
			case X:
				statesOfAnyGame = StatesOfAnyGame.MenaceWins;
				break;
			case O:
				statesOfAnyGame = StatesOfAnyGame.HumanWins;
				break;
			default:
				throw new IllegalArgumentException("Game State cannot " + ValuesOfCell);
		}
	}

	public String toString(){
		String result = "";
		for(int i = 0; i < rows ; i++){
			if(i>0) {
				for(int j = 0; j < 4*columns - 1; j++){
					result+="-";
				}
				result+= Utils.NEW_LINE;
			}
			for(int j = 0; j < columns ; j++){
				switch(board[i*columns + j]){
					case X:
						result+= " X ";
						break;
					case O:
						result+= " O ";
						break;
					default:
						result+=  "   ";
				}
				if(j<columns - 1){
					result += "|";
				} else{
					result += Utils.NEW_LINE;
				}
			}
		}
		return result ;

	}

    public void SymmetryReset(){
        currentTransformation = -1;
        boardTransformation = new int[rows*columns];
    }
	
    public boolean NextSymmetry(){
        return currentTransformation < (allSymmetries.length-1);
    }
    public void following(){
		
        if(!NextSymmetry()){
            throw new IllegalStateException("No following src.game.Symmetry");
        }
        currentTransformation++;
        NextTransform(allSymmetries[currentTransformation]);
    }

    private void NextTransform(Symmetry type){

        switch(type) {
            case ID :
	            for(int i =0 ; i < board.length; i++) {
	                boardTransformation[i]=i;
	            }
	            break;
            case Rotation :
	            Utils.rotateElementsWhenRowEqualsColumns(rows, columns,boardTransformation);
    	        break;
            case VerticalSymmetry :
	            Utils.flipElementsVertical(rows, columns,boardTransformation);
	            break;
            case HorizontalSymmetry :
	            Utils.flipElementsHorizontal(rows, columns,boardTransformation);
	            break;
            default:
            System.out.println("Type not known: " + type);
        }
    }

  	public boolean equalsWithSymmetry(TicTacToeGame other){

    	if(other == null) {
    		return false;
    	}

    	if((totalRounds != other.totalRounds) 	||
    		(rows != other.rows) 	||
    		(columns != other.columns)||
    		(totalsCellsRequiredToWin != other.totalsCellsRequiredToWin)){
    		return false;
    	}

    	SymmetryReset();
    	while(NextSymmetry()){
    		following();
    		boolean different = false;
    		for(int i = 0; i < boardTransformation.length ; i++ ) {
    			if(board[boardTransformation[i]]!= other.board[i]) {
    				different = true;
    				break;
    			}
    		}
    		if(!different)
    			return true;
    	}
    	return false;
    }
}
