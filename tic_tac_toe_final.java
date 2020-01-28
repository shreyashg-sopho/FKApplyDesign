package learnJava;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class tic_tac_toe_task6 {


    public static String simulate_one_game (Player player1, Player PC,  Board game, int game_size, Board [][] Big_tic_tac)
    {
    //Board game = new create_board();
    //game.make_board();
    String winner = null;
    int count  = 0;
    while (true)
    {
    System.out.println("Player1, make move");  
    player1.make_move(game.current(),player1.sign);
    show_current_grid(Big_tic_tac, game_size);
    winner = game.checkwinner();
    if (winner != null)
        {
          System.out.println("We have a winner and it is the player with sign "+ winner);
          break;
        }
    count++;
    if (count == 9 && winner == "null")
    {
      System.out.println("Game drawn");
      break;
    }

    System.out.println("PC is making it's moves");
    PC.make_move(game.current(),PC.sign);
    //game.status();
    show_current_grid(Big_tic_tac, game_size);
    winner = game.checkwinner();
    if (winner != null)
        {
          System.out.println("We have a winner and it is the player with sign "+ winner);
          break;
        }
    count++;
    if (count == 9 && winner == "null")
    {
      System.out.println("Game drawn");
      break;
    }
    }  
    return winner;  
}



 /* public static void show_current_grid (Board Big_tic_tac[][], int game_size)
  {
      for (int x_cor =0 ; x_cor < game_size; x_cor++)

      {

        for (int y_cor = 0 ; y_cor < game_size ;  y_cor++)
        { 
          System.out.println("x_cor = " + x_cor + " y_cor = " + y_cor);
          Big_tic_tac[x_cor][y_cor].status();
        }
      }
  }
*/

  public static void show_current_grid (Board Big_tic_tac[][], int game_size)
  {
    String [][] temp;
    for (int k = 0 ; k < 3; k++)
    {
        for (int l = 0 ; l < 3; l++)
        {
          for (int m = 0 ; m < 3; m++)
          { 
            for (int n = 0 ; n < 3; n ++)
            {
              
              System.out.print(Big_tic_tac[k][m].current() [l][n] + " ");
              //System.out.println( k + "" + m + "" +l + "" + n);
            }
          }
          System.out.println("");

        }
    }  
  }









  public static void choose_grid(Player player1 , Player PC ,Board Big_tic_tac [][], int game_size, String ultimate_winner_array[][])
  {
    System.out.println("Choose what the grid you wana play");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the x_cor of the grid you wanna play with ");
    int x_cor = input.nextInt();
    System.out.print("Enter the y_cor of the grid you wanna play with ");
    int y_cor = input.nextInt();
    String win = simulate_one_game (player1,  PC  ,Big_tic_tac[x_cor][y_cor], game_size, Big_tic_tac );
    if (win != null)
    {ultimate_winner_array[x_cor][y_cor] = "This grid now belongs to  " + win;}
    else
      {ultimate_winner_array[x_cor][y_cor] = "This grid resulted in a draw";}


  }

  public static void show_ultimate_win_status (String ultimate_winner_array[][], int game_size)
  {
    for (int i = 0 ;i < game_size ; i++ )
    {
      for(int j = 0 ; j < game_size ; j++)
      {
        System.out.print(ultimate_winner_array[i][j]+ "     ");
      }
      System.out.println("");

    }
  }



  public static void main(String [] args){

    //Board game = new create_board();
    //game.make_board();
    Player player1 = new Human_Player();
    Player PC = new Comp_Player();
    player1.sign = "X";
    PC.sign = "O";
    String final_winner;
    int game_size = 3;
    String ultimate_winner_array [][] ;
    ultimate_winner_array = new String [game_size][game_size];
    Board Big_tic_tac [] [] = new create_board[game_size][game_size];
    for (int i = 0 ; i < game_size; i ++)
    {
      for(int j = 0;  j <game_size ; j++)
      {

      Board game = new create_board();
      game.make_board();
      System.out.println(game);
      Big_tic_tac[i][j] = game;
      ultimate_winner_array[i][j] = "not played in this grid yet";
      }
    }
    show_current_grid (Big_tic_tac,  game_size);
    choose_grid(player1 , PC , Big_tic_tac , game_size, ultimate_winner_array);
    show_ultimate_win_status(ultimate_winner_array , game_size);

   
   /*final_winner = simulate_one_game(player1, PC, Big_tic_tac[0][0]);
   System.out.println("The winner is"+ final_winner);
   final_winner = simulate_one_game(player1, PC, Big_tic_tac[0][1]);
   System.out.println("The winner is"+ final_winner);
   */ 

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



for (dims1 = 0; dims1 < dims ; dims1 ++)
 {
  if (board_array[0][dims1] != "_")
    {flag = true;
     for (dims2 = 0; dims2 < dims ; dims2 ++)
    {
      if (board_array[dims2][dims1] != board_array[0][dims1])
      {flag = false;
      break;}
    }
 }
 if (flag == true)
 {
  return board_array[0][dims1];
 }
 

}


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


 



