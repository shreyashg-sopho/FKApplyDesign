package learnJava;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class final_for_tuesdday {


  public static void main(String [] args){


  
    Board game = new create_board();
    game.make_board();
    Player player1 = new Human_Player();
    Player PC = new Comp_Player();
    player1.sign = "X";
    PC.sign = "O";
    System.out.println("Player1, make move");
    int count  = 0;
    while (game.checkwinner() == null)
   {
    player1.make_move(game.current(),player1.sign);
    game.status();
    game.checkwinner();
    System.out.println("PC is making it's moves");
    PC.make_move(game.current(),PC.sign);
    game.status();
    game.checkwinner();

    } 
    String winner = game.checkwinner();
    if (winner != null)
        System.out.println("We have a winner and it is the player with sign "+ winner);
}
}


abstract class Board
{
   abstract int dimensions();
   abstract void  make_board();
   abstract void status();
   abstract String [][] current();
   abstract String checkwinner();

}


class create_board extends Board 
{
  static String  board_array[][];
  int dimensions()
  {int dimensions_of_board = 3;
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


String checkwinner()

{
  /*String s = board_array [0][0];
  if (s != "_" &&board_array[0][1] == s && board_array[0][2] == s )
    return s;
  else if (s != "_" && board_array[1][0] == s  && board_array[2][0] == s)
    return s;
  else if (s != "_" &&  board_array[1][1]== s && board_array[2][2] == s)
      return s;
  s = board_array [2][2] ;
  if ( s != "_" &&  board_array[2][1] == s && board_array[2][0] == s)
      return s;
  else if ( s != "_" &&  board_array[1][2] == s && board_array[2][2] == s)
      return s;
  else if ( s != "_" &&  board_array[1][1] == s && board_array[0][0] == s)
      return s;
  else
      return null ;
      */


 int dims = dimensions();
 int dims1 = 0;
 int dims2 = 0;
 boolean flag = false;
 for (dims1 = 0; dims1 < dims ; dims1 ++)
 {
  if (board_array[dims1][0] != "_")
    {flag = true;
     for (dims2 = 0; dims2 < dims ; dims2 ++)
    {
      if (board_array[dims1][dims2] != board_array[dims1][0])
      {flag = false;
      break;}
    }
 }
 if (flag == true)
 {
  return board_array[dims1][0];
 }
}


flag = false;
for (dims1 = 0; dims1 < dims ; dims1 ++)
 {
  if (board_array[0][dims1] != "_")
    {flag = true;
     for (dims2 = 0; dims2 < dims ; dims2 ++)
    {
      if (board_array[dims2][dims1] != board_array[dims1][0])
      {flag = false;
      break;}
    }
 }
 if (flag == true)
 {
  return board_array[dims1][0];
 }
 

}

flag = false;
if (board_array[0][0] != "_")
flag = true;
  {for (dims1 = 0 ; dims1 < dims ; dims1++)
    {
      if (board_array[dims1][dims1] != board_array[0][0] )
      {
        flag = false;
        break;
      }
    }
  }
  if (flag == true)
 {
  return board_array[0][0];
 }

flag = false;
if (board_array[0][dims-1] != "_")
flag = true;
  {for (dims1 = 0 ; dims1 < dims ; dims1++)
    {
      if (board_array[dims1][dims - dims1 - 1] != board_array[0][dims - 1] )
      {
        flag = false;
        break;
      }
    }
  }
  if (flag == true)
 {
  return board_array[0][dims - 1];
 }



 return null;


}
}



class Player extends create_board
{
  String sign ;
  void make_move(String[][] board_array, String sign){};
  boolean check_valid_move(int row, int column, String sign){return true;};
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
      if (check_valid_move(row, column , sign) != true)
      {
          System.out.println("DO not try to overwrite a cell !");
          make_move(board_array, sign);
      }
      
}

boolean check_valid_move(int row, int column, String sign)
{
  if (board_array[row][column] == "_")
    {board_array [row] [column] = sign;
    return true;}
  else
    return false;
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


 



