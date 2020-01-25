package learnJava;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class MachineHuman {


  public static void main(String [] args){


  
    Board game = new create_board();
    game.make_board();
    Player player1 = new Human_Player();
    Player player2 = new Human_Player();
    player1.sign = "H";
    System.out.println("Player1, make move");
    player1.make_move(game.current(),player1.sign);
    game.status();

    Player PC = new Comp_Player();
    PC.sign = "P";
    PC.make_move(game.current(),PC.sign);
    game.status();



    

  } 
}

abstract class Board
{
   abstract int dimensions();
   abstract void  make_board();
   abstract void status();
   abstract String [][] current();

}


class create_board extends Board 
{
  static String  board_array[][];
  int dimensions()
  {int dimensions_of_board = 3;

  System.out.printf("  Creating  board of dimensions %d\n" ,dimensions_of_board );
  return dimensions_of_board;
  }

  void  make_board()
  {
    int x_y = dimensions();
    board_array = new String [x_y][x_y];
    for (int i = 0; i < board_array.length; i++) 
      {for (int j = 0; j < board_array[i].length; j++) 
            { board_array[i][j] = "_";
              System.out.print(board_array[i][j] + " "); }
        System.out.println("");}
}
 void status()
 {
  for (int i = 0; i < board_array.length; i++) 
      {for (int j = 0; j < board_array[i].length; j++) 
            { 
              System.out.print(board_array[i][j] + " "); }
        System.out.println("");}
  }

String [][] current()
{
  return board_array;
}

}



class Player extends create_board
{
  String sign ;
  void make_move(String[][] board_array, String sign){};
  }



class Human_Player extends Player
{String sign;
 int row;
 int column;
void make_move(String [][] board_array, String sign)
{
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the row: ");
      int row = input.nextInt();
      System.out.print("Enter the column: ");
      int column = input.nextInt();
      board_array [row][column] = sign;
}
}



class Comp_Player extends Player
{String sign;
 int row;
 int column;
void make_move(String [][] board_array, String sign)
{
     int flag = 0;
     while (flag != 1)
   { Random rand = new Random();
     int random_row = rand.nextInt(3);
     int random_column =  rand.nextInt(3);
     if (board_array [random_row][random_column] == "_")
     {
         board_array[random_row][random_column] = sign;
         flag = 1;
     }
   }

}
}


 



