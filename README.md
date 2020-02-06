# FKApplyDesign

# FINAL CODE TO BE CONSIDERED FOR ASSESSMENT IS IN THE FILE fresh.java .
NOTE : I re-wrote the entire code from scratch instead of just refactoring.

PHASE  I - In a new file  final_for_saturday.java 	(JAN 25)
PHASE II - In a new file final_for_tuesdday.java	(JAN 28)
PHASE III - In a file called reattempt_hex_on_wednesday.java	(JAN 29)


Refactoring the code  till PHASE III  - Renamed the file reattempt_hex_on_wednesday.java as fresh.java and wrote a totally new code from scratch. ( FEB 2 )






SECTION  I: First Iteration Game Project Design
	[Till Phase III or Phase IV Submitted Upto 29th January, 2020]

	PART I :
		Sequence Diagrams - Sequence Diagram Tic tac toe.png
		Class Diagrams . - Class Diagram tic tac toe.jpg
		
			
			
	
	PART III : Feature Specific Design/Choices and Conventions/Assumptions 
		GameDesign v2.0	- Requirement I
			<STATUS> - 1. Tic-Tac-Toe consists of 3x3 Square Cells
				Implemented by making a create Board function of Board class.
			<STATUS> - 2. Game Between Two Humans
				Created two objects of Human types in main function which are created from Human class which extends abstract class create Board.
			<STATUS> - 3. Game Between Human and Machine
				Created a object of Human type and Computer type which are object created from Human and Computer class which extends the Player abstract create Board.
			<STATUS> - 4. Winning Criteria - 3 Cells in Row/Column/Diagonal are in Same State.
				CheckWin function to  determine the winning condition
			<STATUS> - 5. Announce Winning Player
				CheckWin does that as well.

		GameDesign v2.0	- Requirement II
			<STATUS> - 6. Enhanced Tic-Tac-Toe Game Consist of 9x9 Squares...
				Added that feature by creating a new class called Big tic tac which extends the Board Game abstract class
			<STATUS> - 7. Enhanced Tic-Tac-Toe will continue to expand in depth levels...
				Added that as a functionality in the function name game play.
			<STATUS> - 8. Extend Game to 4x4 Board
						Managed within the Board play class itself.
					
			<STATUS> - 9. Human Player is Biased...
				Not Implemented 
			<STATUS> - 10. Storing and Retrieving Game State
				Implemented
			<STATUS> - 11. Store Players Game Statistics: Leaderboard
				Not Implemented

		GameDesign v3.0	- Requirement III
			<STATUS> - 12. Super Tic-Tac-Toe Game Extends Enhanced Tic-Tac-Toe Game...
				
			<STATUS> - 13. Design Winning and Losing Criteria On All Edges...
				Feature Specific Design Decision?
			<STATUS> - 14. Incorporate Irregular shaped Hexagonal Boards
				Feature Specific Design Decision?

		
	
SECTION II: Second Iteration[Refactoring/Redesign] Game Project Design 
	[Till Phase III or Phase IV Submitted Upto 03rd February, 2020]

	PART I : Common Design/Choices, Conventions and Assumptions
		Sequence Diagrams - Sequence Diagram Tic tac toe.png
		Class Diagrams  - Class Diagram tic tac toe.jpg
	
	
	PART II : Common Design/Choices and Conventions/Assumptions and Detailed Descriptions etc.

			Two interfaces : 
			1) game_play
			2)manage_game
			

			Extended tic tac toe and normal tic tac toe both belong to the manager class implemented from manage_game.
			Hex tic tac toe is done in the class called Hex_manager which is an implementation of the interface manage_game.


			For Human and Computer Players for normal and extended tic tac toe they are are objects of Human and Comp class which is an implementation of the game_play interface.
			For Human and computer players for hex tic tac toe, they are objects of Hex_human and Hex_Comp class which are implementation of game_play interface.

	
	PART III: Feature Specific Design/Choices, Conventions and Assumptions	
		GameDesign v2.0	- Requirement I
			<STATUS> - 1. Tic-Tac-Toe consists of 3x3 Square Cells
				Inputs taken for dimensions (n x n only ), functionalities provided in the manager class as MakeBoard().
			<STATUS> - 2. Game Between Two Humans
				Game play between two humans, done by making two objects of Human class.
			<STATUS> - 3. Game Between Human and Machine
				By default the game is Human vs Machine y making an object of Human and Comp class . 
			<STATUS> - 4. Winning Criteria - 3 Cells in Row/Column/Diagonal are in Same State.
				That is checked in the checkwin function of manager class.
			<STATUS> - 5. Announce Winning Player
				Done in the main function of the program based on the return string of checkwin function. If all boxes are filled then prompts "Draw" as a result.

		GameDesign v2.0	- Requirement II
			<STATUS> - 6. Enhanced Tic-Tac-Toe Game Consist of 9x9 Squares...
				To make a 9 x 9 game. 
				I have assumed it as  blocks of 3 x 3 game, i.e 9 x( 3 x 3)
				So the first input "Enter the dims" , will take input as 3 from user.
				The second input " Number of blocks", will take 9 as an input from user.
				Thus meaning to say that we need 9 blocks of 3 x 3 games.
				This is all managed in the same manager class as it interprets the basic normal tic tac toe game as a 3 x 3 game with just 1 block OR 9 blocks each of 1 x 1 dimensions.
			<STATUS> - 7. Enhanced Tic-Tac-Toe will continue to expand in depth levels...
				Cannot go more than 2 levels deep for now.
			<STATUS> - 8. Extend Game to 4x4 Board
				Enter the number of dimensions as 4.
			<STATUS> - 9. Human Player is Biased...
				NOT IMPLEMENTED
			<STATUS> - 10. Storing and Retrieving Game State
				Implemented within the manage game class
			<STATUS> - 11. Store Players Game Statistics: Leaderboard
				Already displayed in the output at each move.

		GameDesign v3.0	- Requirement III
			<STATUS> - 12. Super Tic-Tac-Toe Game Extends Enhanced Tic-Tac-Toe Game...
				Implemented 
			<STATUS> - 13. Design Winning and Losing Criteria On All Edges...
				Designed for a streak of 4 for now. Can be changed by just editing the variable win_streak to whatever number required, although the change cannot be made in runtime by player.
			<STATUS> - 14. Incorporate Irregular shaped Hexagonal Boards
				Not implmented. For now the Hexagonal board is supposed to be of (n x m) dimensions. Although a simple addition to the code would have easily enabled this feature.




SECTION III: How to Run/Test Your Code?
	Describe How To Run Your Code
	clone the repository or download from git.
	run command			 - pwd

	create an empty Package directory called "learnJava"
	run command 			- mkdir learnJava
			      			 - cd learnJava

	create an empty directory  within learnJava called "ClassFiles"
	run command		       - mkdir ClassFiles

	return to the directory where downloaded 	
	run command 		       - cd ..

	Compile file
	run command 		       - javac fresh.java -d ClassFiles 

	Run file 		
	run command 		       - java -cp ClassFiles/ learnJava.fresh	
	




	Can I Run Test.java to test your whole source code?
	No.

	Are you providing all Input/Output files to run Test Code using Test.java?
	No.

	
	

