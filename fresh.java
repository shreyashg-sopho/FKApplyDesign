package learnJava;

import java.util.Scanner;
import java.util.Random;
import java.lang.*; 

public class fresh{
	public static int min_dimension;
	public static int multi_blocks;
	public static manager mini_game; 
	public static String [][] score_keeper;
	public static int row_max;
	public static int column_max;
	public static int win_streak = 3;
	public static void main (String [] args)
	{
		System.out.println("Enter 1 to play normal tic tac toe or the big tic tact toe");
		System.out.println("Enter 2 to play  Hexagonal tic tac toe");
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		if (key == 1)
		{
			System.out.println("Okay so you have chosen regular tic tac toe");
			System.out.println("If you wanna play a simple game then put no. of dimensions as 3 or 4 and set the numnber of blocks as 1");
			System.out.println("Else if you wanna play the complex one, make the number of blocks a higher power of number of dimensions");
			tic_tac();

		}
		if(key == 2)
		{
			System.out.println("Initializing a game of Hexagonal tic tac toe");
			hex_tic_tac();
		}

	} 
	public static void hex_tic_tac()
	{
		int max_steps = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows in the board");
		row_max = in.nextInt(); 
		System.out.println("Enter the number of column in the board");
		column_max = in.nextInt();
		multi_blocks = 1;
		manage_game mini_game = new hex_manager();
		mini_game.MakeBoard();
		mini_game.printBoard();
		System.out.println("By default the minimum streak to be made to win is set to 4. Make 4 in a row or column or diagonal and win.");
		gameplay Human_player = new Hex_human();
		gameplay Comp_player = new Hex_comp();
		while(true)
			{
				Human_player.play(mini_game);
				mini_game.printBoard();
				Comp_player.play(mini_game);
				mini_game.printBoard();
			}
		


	}
	public static void tic_tac() 
	{
		int max_steps = 0;
		int steps = 0 ;
		String temporary_1;
		System.out.println("enter min_dimension : ");
		Scanner in = new Scanner(System.in);
		min_dimension = in.nextInt();
		row_max = min_dimension;
		column_max = min_dimension;
		System.out.println("enter number of blocks");
		multi_blocks = in.nextInt();
		manage_game  mini_game =  new manager();
		mini_game.MakeBoard();
		mini_game.printBoard();
		score_keeper =  new String [min_dimension][min_dimension];

		for(int row = 0 ; row < min_dimension; row ++)
		{
			for(int column = 0 ; column < min_dimension ; column++)
			{
				score_keeper [row][column] = "_";
				System.out.print(score_keeper [row][column]);
			}
		} 

		
		gameplay Human_player = new Human();
		gameplay Comp_player = new Comp();
		max_steps = min_dimension * min_dimension * multi_blocks;
		
		if (multi_blocks == 1 )
			{	while(true)
					{
						Human_player.play(mini_game);
						temporary_1 =  score_checker();
						if (temporary_1 != null)
						{
							System.out.println("Player with sign X is winner");
							break;
						}
						steps++;
						if(steps >= max_steps)
						{
							System.out.println("GAME DRAWN");
							break;
						}
						Comp_player.play(mini_game);
						temporary_1 =  score_checker();
						if (temporary_1 != null)
						{
							System.out.println("Player with sign O is winner");
							break;
						}
						steps++;
						if(steps >= max_steps)
						{
							System.out.println("GAME DRAWN");
							break;
						}
					}
			}
		else
			{
				while(true)
					{
						Human_player.play(mini_game);
						temporary_1 =  score_checker();
						if (temporary_1 != null)
						{
							System.out.println("Player with sign X is winner");
							break;
						}
						Comp_player.play(mini_game);
						temporary_1 =  score_checker();
						if (temporary_1 != null)
						{
							System.out.println("Player with sign X is winner");
							break;
						}
					}

			}
	}

	public static String  score_checker ()
	{
		
		
		for(int row = 0 ; row < min_dimension; row ++)
		{
			for(int column = 0 ; column < min_dimension ; column++)
			{
				
				System.out.print(score_keeper[row][column]);
			}
		} 
		int dims1 = 0;
		int dims2 = 0;
		boolean flag = false;
 		for (dims1 = 0; dims1 < min_dimension ; dims1 ++)
 		{
  			
  			if (score_keeper[dims1][0] != "_")
    		{
    			flag = true;
     			for (dims2 = 0; dims2 < min_dimension ; dims2 ++)
    				{
      					if (score_keeper[dims1][dims2] != score_keeper[dims1][0])
      					{
      						flag = false;
      						break;
      					}
    				}
 			}
 		
 			if (flag == true)
 			{
  				return score_keeper[dims1][0];
 			}
		}



		
		flag = false;
		for (dims1 = 0; dims1 < min_dimension ; dims1 ++)
 		{
  			if (score_keeper[0][dims1] != "_")
    		{
    			flag = true;
     			for (dims2 = 0; dims2 < min_dimension ; dims2 ++)
    			{
      				if (score_keeper[dims2][dims1] != score_keeper[0][dims1])
      				{
      					flag = false;
      					break;
      				}
    			}
 			}
 		if (flag == true)
 		{	
  			return score_keeper[0][dims1];
 		}
 

		}


	
		flag = false;
		if (score_keeper[0][0] != "_")
		flag = true;
  	{
  		for (dims1 = 0 ; dims1 < min_dimension ; dims1++)
    	{
      		if (score_keeper[dims1][dims1] != score_keeper[0][0] )
      		{
        		flag = false;
        		break;
      		}
    	}
  	}
  	if (flag == true) 
 	{
  		return score_keeper[0][0];
 	}

 	
 	flag = false;
	if (score_keeper[0][min_dimension-1] != "_")
	flag = true;
  	{	for (dims1 = 0 ; dims1 < min_dimension ; dims1++)
    	{
      		if (score_keeper[dims1][min_dimension - dims1 - 1] != score_keeper[0][min_dimension - 1] )
      		{
        		flag = false;
        		break;
      		}
    	}
  	}
  	if (flag == true)
 	{
  		return score_keeper[0][min_dimension - 1];
 	}

 	return null;

 	}


}


interface gameplay
{
    void play(manage_game mini_game);
}

interface manage_game
{
    static String [][][] Board  = new String [fresh.multi_blocks][fresh.row_max][fresh.column_max];
    void MakeBoard();
    void printBoard();
    String checkwin(int block_no, int row_max , int column_max);

}

class hex_manager implements manage_game{

	public void MakeBoard()
	{
		for (int row  = 0 ; row < fresh.row_max ; row++)
		{
			for(int column = 0; column < fresh.column_max; column++)
			{
				if ((row+column)%2 == 0)
					Board[0][row][column] = "*";
				else
					Board[0][row][column] = "_";
			}
		}
	}


	public void printBoard()
	{
		
		for (int row  = 0 ; row < fresh.row_max ; row++)
		{
			for(int column = 0; column < fresh.column_max ; column++)
			{
				System.out.print(Board[0][row][column] + " ");
			}
			System.out.println("");
		}
	}
    public String checkwin(int block_no, int row_max , int column_max)
    {
    	
    	
    	int row  = row_max;
    	int column = column_max;
    	int curr_streak = 0;




    	
    	String first ;
    	int x = 0;
    	if (row %2  == 0)
    		x = 1;
    	first = Board[0][row][x];
    	while(x < fresh.column_max)
    	{
    		if (Board[0][row][x] == first && first != "_")
    			curr_streak++;
    		else
    			{first = Board[0][row][x] ;
    			 curr_streak = 0;}
    		if (curr_streak == fresh.win_streak)
    			return first;
    		x +=2;

    	}

    	
    	curr_streak = 0;
    	int y = 0;
    	if(column %2 == 0)
    		y = 1;
    	first = Board[0][y][column];
    	while(y < fresh.row_max)
    	{
    		if(Board[0][y][column] == first && first != "_")
    			curr_streak++;
    		else
    			{
    				first = Board[0][y][column];
    			    curr_streak = 0;
    			}
    		if(curr_streak == fresh.win_streak)
    			return first;
    		y +=2;
    	}


    	//diagonal1
    	curr_streak = 0;
    	int temp_row;
    	int temp_column;
    	int minimum = Math.min(row,column);
    	temp_row = row - minimum;
    	temp_column = column - minimum;
    	while(temp_row < fresh.row_max && temp_column < fresh.column_max)
    	{
    		if(Board[0][temp_row][temp_column] == first && first != "_")
    		curr_streak++;
    		else
    		{
    			first = Board[0][temp_row][temp_column];
    			curr_streak = 0;
    		}
    		if (curr_streak == fresh.win_streak)
    			return first;
    		temp_row += 2;
    		temp_column +=2;
    		
    	}

    	return null;
    }
}



class manager implements manage_game{
	
	
	public void MakeBoard()
	{

		for (int block = 0 ; block < fresh.multi_blocks; block ++)
			{
				for(int row = 0; row < fresh.min_dimension ; row++)
				{
					for(int column = 0; column < fresh.min_dimension ; column++)
					{
						Board[block][row][column] = "_";
					}
				}
			}
	}


	public void printBoard()
	{
			

			if (fresh.multi_blocks != 1)
			{	for(int temp = 0 ; temp < fresh.min_dimension; temp++)

						{
							for(int row = 0; row < fresh.min_dimension ; row++)

						{
							for (int block = temp*fresh.min_dimension ; block < (temp*fresh.min_dimension) + fresh.min_dimension  ; block ++)
							{
								for(int column = 0; column < fresh.min_dimension ; column++)
								{		
									System.out.print(Board[block][row][column] + " ");
								}
								System.out.print("  ");
							}
							System.out.println();
						}
						System.out.println("");
						}

			}
			else
			{
				for (int block = 0 ; block < fresh.multi_blocks; block ++)
			{
				for(int row = 0; row < fresh.min_dimension ; row++)
				{
					for(int column = 0; column < fresh.min_dimension ; column++)
					{
						System.out.print(Board[block][row][column] + " ");
								
					}
					System.out.println("");
				}
			}
			}
				

	}



	
	public String checkwin(int block_no, int row_max, int column_max)
	{
		int min_dimension =  row_max;
		String [][] temp = new String [min_dimension][min_dimension];
		for (int row = 0 ; row < min_dimension ; row++)
		{
			for(int column = 0; column < min_dimension; column++)
			{
				temp[row][column] = Board[block_no][row][column];
			}
		}

		//checking for row

		int dims1 = 0;
		int dims2 = 0;
		boolean flag = false;
 		for (dims1 = 0; dims1 < min_dimension ; dims1 ++)
 		{
  			if (temp[dims1][0] != "_")
    		{
    			flag = true;
     			for (dims2 = 0; dims2 < min_dimension ; dims2 ++)
    				{
      					if (temp[dims1][dims2] != temp[dims1][0])
      					{
      						flag = false;
      						break;
      					}
    				}
 			}
 		
 			if (flag == true)
 			{
  				return temp[dims1][0];
 			}
		}



		
		flag = false;
		for (dims1 = 0; dims1 < min_dimension ; dims1 ++)
 		{
  			if (temp[0][dims1] != "_")
    		{
    			flag = true;
     			for (dims2 = 0; dims2 < min_dimension ; dims2 ++)
    			{
      				if (temp[dims2][dims1] != temp[0][dims1])
      				{
      					flag = false;
      					break;
      				}
    			}
 			}
 		if (flag == true)
 		{	
  			return temp[0][dims1];
 		}
 

		}



	

	
		flag = false;
		if (temp[0][0] != "_")
		flag = true;
  	{
  		for (dims1 = 0 ; dims1 < min_dimension ; dims1++)
    	{
      		if (temp[dims1][dims1] != temp[0][0] )
      		{
        		flag = false;
        		break;
      		}
    	}
  	}
  	if (flag == true) 
 	{
  		return temp[0][0];
 	}

 	
 	flag = false;
	if (temp[0][min_dimension-1] != "_")
	flag = true;
  	{	for (dims1 = 0 ; dims1 < min_dimension ; dims1++)
    	{
      		if (temp[dims1][min_dimension - dims1 - 1] != temp[0][min_dimension - 1] )
      		{
        		flag = false;
        		break;
      		}
    	}
  	}
  	if (flag == true)
 	{
  		return temp[0][min_dimension - 1];
 	}

 	return null;

 	}
			
}



class Human implements gameplay
{	
	Scanner in = new Scanner(System.in);
	public void play( manage_game mini_game)
	{
		System.out.println("in human");
		int block , row, column;
		while(true)
			{
				if (fresh.multi_blocks == 1)
		        {
		        	System.out.println("Enter x and y coordinates");
		        	row     = in.nextInt();
		        	column  = in.nextInt();
		        	block   = 0;
		        }
		        else
		        {
		        	System.out.println("Enter lock and block and x and y coordinates");
		        	block  = in.nextInt();
		        	row    = in.nextInt();
		        	column = in.nextInt();
		        }

		        if (block < fresh.multi_blocks && row < fresh.min_dimension && column < fresh.min_dimension && mini_game.Board [block][row][column] == "_")
		        	{
		        		mini_game.Board [block][row][column] = "X";
		        		if (fresh.multi_blocks == 1)
		        			fresh.score_keeper [row][column] = "X";
		        		mini_game.printBoard();
		        		break;
		        	}
		        else
		        	{
		        		System.out.println("Either the position mentioned by you is our of bounds or it is already occupied.\nPlease re enter the coordinates");
		        	}
		    }
		    String temporary = mini_game.checkwin(block,fresh.min_dimension, fresh.min_dimension);
		    if (temporary != null)
		    {
		    	if (fresh.multi_blocks == 1)
		    		fresh.score_keeper [row][column] = temporary;
		    	else 
		    		fresh.score_keeper [block/fresh.min_dimension][block%fresh.min_dimension] = temporary;
		    }

        
	}
}

class Hex_human implements gameplay
{
	Scanner in = new Scanner(System.in);
	public void play( manage_game mini_game)
	{
		int row, column;
		String temporary;
		temporary = null;
		while(true)
		{
			System.out.println("Enter the row you wanna make a move at");
			row = in.nextInt();
			System.out.println("Enter the column you wanna make a move at");
			column = in.nextInt();
			if (row < fresh.row_max && column < fresh.column_max && mini_game.Board[0][row][column] == "_")
			{
				mini_game.Board[0][row][column] = "X";
				temporary = mini_game.checkwin(0, row, column);
				if(temporary != null)
				{
					mini_game.printBoard();
					System.out.println("Yay!!  You have won");
					System.exit(0);
				}
				break;
			}
			else
			{
				System.out.println("Why are you making an invalid move     (-_-) !");
			}
		}


	}
}


class Hex_comp implements gameplay
{
	public void play( manage_game mini_game)
	{
		System.out.println("Computer is making it's move");
		Random rand = new Random();
		int   row, column;
		String temporary;
		temporary = null;
		while(true)
		{
			row     =  rand.nextInt(fresh.row_max);
		    column  =  rand.nextInt(fresh.column_max);	
		    if (mini_game.Board[0][row][column] == "_")
			{
				mini_game.Board[0][row][column] = "O";
				temporary = mini_game.checkwin(0, row, column);
				if(temporary != null)
				{
					mini_game.printBoard();
					System.out.println("Uh Oh!!!. The computer player has win.");
					System.exit(0);
				}
				break;
			}
		}


	}
}









class Comp implements gameplay
{	
	Scanner in = new Scanner(System.in);
	public void play( manage_game mini_game)
	{
		System.out.println("in comp");
		Random rand = new Random();
		int block , row, column;
		
		while(true)
			{
				if (fresh.multi_blocks == 1)
		        {
		        	
		        	row     =  rand.nextInt(fresh.min_dimension);
		        	column  =  rand.nextInt(fresh.min_dimension);
		        	block   =  0;
		        }
		        else
		        {
		        	
		        	block  =  rand.nextInt(fresh.multi_blocks);
		        	row    =  rand.nextInt(fresh.min_dimension);
		        	column =  rand.nextInt(fresh.min_dimension);
		        }

		        if (mini_game.Board [block][row][column] == "_")
		        	{
		        		System.out.println(block + " "+ column +" "+ row + " is blank and Computer am making my move here");
		        		mini_game.Board [block][row][column] = "O";
		        		if (fresh.multi_blocks == 1)
		        			fresh.score_keeper [row][column] = "O";
		        		mini_game.printBoard();
		        		break;
		        	}
		    }
		    String temporary = mini_game.checkwin(block,fresh.min_dimension, fresh.min_dimension);
		    if (temporary != null)
		    {
		    	if (fresh.multi_blocks == 1)
		    		fresh.score_keeper [row][column] = temporary;		
		    	else 
		    		fresh.score_keeper [block/fresh.min_dimension][block%fresh.min_dimension] = temporary;
		    }

        
	}
}




