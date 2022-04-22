PSA Final Project - Tic Tac Toe
===============================

- Prathamesh Sahasrabuddhe (002117703)
- Pravin Dhuri (002138314)
- Vivek Sharma (002105272)

OBJECTIVE
---------
The objective of this project is to design a Machine Educable Noughts and Crosses Engine (MENACE) that can play tic-tac-toe against a human player and return the move for any strategy that it has been trained on, as well as to enhance the tactic by learning from each game play.
Initially we have created an array with 9 position 1 position for each square. The ideal strategy or the states has been created in the different class file to train Menace. Also, we are training the Menace by placing the moves at the random position i.e., random state. All the trained sets have been stored for that instance. The traverse function is written to check each position and then comparing with the ideal state to decide the winning or losing factor. The trained Menace is then actioned to play against the human inputted symbol i.e., 0. Based on the result the state is saved. In case the Menace loses while playing with human, the state is saved for training the Menace. Finally, the Menace uses the state to refine the strategy and improve the result.

DATA STRUCTURE & CLASSES
------------------------
We have used LinkedList since Menace uses the statistics of adding and deleting the beads as on when required according to the strategy, moreover the insertion and deletion operations are efficient and easily implemented using the LinkedList. The below are the classes used in our implementation:

•	OptimalStrategy - Trains the Menace with the optimal strategies
•	RandomTrainStrategy – Trains the Menace with the random state strategy
•	Perfect_Tic_Tac_Toe – Created a strategy used in the class OptimalStrategy
•	Player – Store the playoff stat result of wins, looses & draws
•	StatesOfAnyGame - Initialize the state such as Draw, Menacewins etc.
•	Symmetry – Used for matrix rotation
•	TicTacToeGame – Used for matrix creation and contains rule for each playoff
•	ValuesOfCell – Initialize values needed for playing e.g., X, 0
•	HumanInput – Class to handle input from human player
•	Menace_Tic_Tac_Toe - Class to handle input from Menace
•	Execute_Tic_Tac_Toe – Main execution class to run the whole game

OBSERVATION AND GRAPHICAL ANALYSIS
----------------------------------
Firstly, when we train the Menace with the strategies the probability losing is on higher side. But more the number of states we input to the Menace the better the probability of winning and draws has been observed. When training the Menace against the program we observed that it ran out of beads number of times and have lost so many times because of removal of all the beads.

INSTRUCTIONS
------------

1) Clean the project
2) Build the project
3) Sync Maven (if required)
4) Run Execute_Tic_Tac_Toe.java
5) Enter cell number in console to play

SCREENSHOTS
-----------

Dashboard
---------
<p align="center">
   <img src="https://i.imgur.com/bsczjWt.png">
</p>

UI
----------
<p align="center">
   <img src="https://i.imgur.com/RmX23Nl.png">
</p>

CONCLUSION
----------
We can conclude that before training the Menace the chances of Menace winning was very low, but after reinforcement learning with the various stages such as with perfect player, random state and using optimal strategy the performance of the Menace became far better. Menace was able to win or draw the games.
