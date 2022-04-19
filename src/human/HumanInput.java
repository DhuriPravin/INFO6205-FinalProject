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
	}
	}

}
