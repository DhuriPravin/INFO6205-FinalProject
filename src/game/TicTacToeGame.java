package src.game;

import src.utils.Utils;

public class TicTacToeGame {

	private ValuesOfCell[] board;

	private int totalRounds; // records total rounds

	private StatesOfAnyGame statesOfAnyGame; //records the current state of the game.

	public final int rows;

	public final int columns;

	public final int totalsCellsRequiredToWin; // number of indexCell of the same type * that must be aligned to conditionWin the game

	// list of all possible symmetries
    private  static final Symmetry[] allPossibleSymmetries = {Symmetry.ID, Symmetry.Rotation, Symmetry.Rotation,Symmetry.Rotation, Symmetry.HorizontalSymmetry, Symmetry.Rotation,Symmetry.Rotation, Symmetry.Rotation};

    private  static final Symmetry[] ALL_TRANSFORMATIONS_NON_SQUARE ={Symmetry.ID, Symmetry.HorizontalSymmetry,Symmetry.VerticalSymmetry, Symmetry.HorizontalSymmetry};

    private  Symmetry[] allSymmetries; // instance to record symmetry

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

    	if((totalRounds != ticTacToeGame.totalRounds) 	|| (rows != ticTacToeGame.rows) 	|| (columns != ticTacToeGame.columns)||	(totalsCellsRequiredToWin != 
ticTacToeGame.totalsCellsRequiredToWin)){
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
			throw new IllegalArgumentException("ValueInCell is not empty: " + i + " game " + toString());
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

