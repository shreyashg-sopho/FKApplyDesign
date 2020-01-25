package learnJava;
import java.io.*;

public class cells {


	public static void main(String [] args){
		Board game = new create_board();
		game.make_board();

	} 
}

abstract class Board
{
   abstract int dimensions();
   abstract void  make_board();

}


class create_board extends Board 
{
  
  int dimensions()
  {int dimensions_of_board = 3;

  System.out.printf("  Creating  board of dimensions %d\n" ,dimensions_of_board );
  return dimensions_of_board;
  }

  void  make_board()
  {
  	int x_y = dimensions();
  	String [][] board_array = new String [x_y][x_y];
  	for (int i = 0; i < board_array.length; i++) 
    	{for (int j = 0; j < board_array[i].length; j++) 
            {	board_array[i][j] = "_";
            	System.out.print(board_array[i][j] + " "); }
        System.out.println("");}
}

}
