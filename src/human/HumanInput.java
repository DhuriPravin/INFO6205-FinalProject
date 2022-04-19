package src.human;

public class HumanInput extends Participant {

	public  void start(TicTacToeGame ticTacToeGame) {

		if(ticTacToeGame.getTotalRounds() == ticTacToeGame.rows*ticTacToeGame.columns){
			throw new IllegalArgumentException("Game doesn't exist!");
		}

	boolean won = false;

	while(!won) {
        	System.out.println(ticTacToeGame);
        	System.out.print("Enter input: ");
			String InputResponse = null;
			try {
				InputResponse = Utils.console.readLine();
			} catch (IOException e) {
				System.out.println("Please enter a correct number from the above list.");
			}
			int InputValue;
        	try {
                InputValue = Integer.parseInt(InputResponse)-1;
            } catch (NumberFormatException e) {
            	InputValue = -1;
            }
		if(InputValue < 0 || InputValue >= (ticTacToeGame.rows*ticTacToeGame.columns)){
            	System.out.println("Input should be between 1 and " + (ticTacToeGame.rows*ticTacToeGame.columns));
            } else if(ticTacToeGame.returnValueAtParticularIndex(InputValue) != ValuesOfCell.EMPTY) {
            	System.out.println("Incorrect indexCell input. Enter indexCell which has not been played.");
            }
	}
	}

}
