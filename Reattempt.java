import java.util.Scanner;
import java.util.Objects;

public class Reattempt {
    static int size ;
    static int countP1,countP2;

    public static void main (String [] args)
    {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the hex board: ");
        size = input.nextInt();
        hex_manager new_game = new hex_manager();
        new_game.initialiseboard();
        new_game.printBoard();

        int numberOfTurns = 0 ;
        int key;
        while (true) {
            System.out.println("Press 1 for human vs human game or 2 to play with computer and 3 for exit");
            key = input.nextInt();
            if (key == 3)
                System.exit(0);
            if (key == 1 || key == 2) {
                new_game.turn="X";
                numberOfTurns=0;
                break;
            }}
            while (Objects.isNull(new_game.winner))
            {

                if (numberOfTurns == 0)
                    new_game.printBoard();
                    numberOfTurns++;
                if (numberOfTurns == ((size/2)*size) + size/2 + 1 ) {
                    new_game.printBoard();
                    System.out.println("The match is a draw");
                    break;
                }

                if (numberOfTurns == 1)
                    new_game.turn = "X";
                if (key == 1 || numberOfTurns % 2 == 0) {
                    Human h = new Human();
                    h.play();
                }
                if (key == 2 && numberOfTurns % 2 == 1) {
                    Comp m = new Comp();
                    m.play();
                }
                new_game.checkwin((new_game.x), (new_game.y) );
                new_game.printBoard();


                if (new_game.winner == "X") {
                    countP1++;
                    System.out.println("X won the match");
                    if (new_game.winner == "X" || new_game.winner == "O")
                        System.out.println("leaderboard: player X score" + countP1 + " player 2 score " + countP2);
                    break;
                } else if (new_game.winner == "O") {
                    countP2++;
                    System.out.println("O won the match");
                    if (new_game.winner == "X" || new_game.winner == "O")
                        System.out.println("leaderboard: player X score " + countP1 + " player O score " + countP2);
                    break;
                }

                if (new_game.turn == "X")
                    new_game.turn = "O";
                else
                    new_game.turn = "X";
            }
        }
    }


interface manage_game
{
    void checkwin(int row, int col);
    void initialiseboard();
    void printBoard();
}
class hex_manager implements manage_game {

    static int x,y;
    static String turn;
    static int streak;
    static String winner = null;
    static String[][] board = new String[Reattempt.size][Reattempt.size];

    public void initialiseboard() {
        for (int i = 0; i < Reattempt.size; i++) {
            for (int j = 0; j < Reattempt.size; j++) {
                if ((i + j) % 2 == 0)
                    board[i][j] = "_";
                else
                    board[i][j] = "*";


            }
        }

    }

    public void printBoard() {
        for (int i = 0; i < Reattempt.size; i++) {
            for (int j = 0; j < Reattempt.size; j++) {
                System.out.print("|" + " " + board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public void checkwin(int row, int column)
    {
     //Row check
        streak = 0;
        for (int i = 0 ; i < Reattempt.size ; i ++)
        {
         if (board[row][i] ==  turn)
             streak++;
         else
             streak = 0;
         if (streak == 4)
         {
             winner = turn;
             return ;
         }

        }
        //Column check
        streak = 0 ;
        for (int i = 0 ; i < Reattempt.size ; i ++)
        {
            if (board[i][column] ==  turn)
                streak++;
            else
                streak = 0;
            if (streak == 4)
            {
                winner = turn;
                return ;
            }

        }

        //Diagonal Check
        while(row != 0 ||  column != 0)
        {
            column--;
            row--;
        }

        if (row == 0)
        {
            streak = 0;
            while(column < Reattempt.size)
            {
                if (board [row][column] == turn )
                {
                    streak++;
                }
                else
                    streak = 0;
                if(streak == 4)
                {
                    winner = turn;
                    return ;
                }
                row++;
                column++;
            }

            if (column == 0)
            {
                streak = 0;
                while (row < Reattempt.size) {
                    if (board[row][column] == turn) {
                        streak++;
                    } else
                        streak = 0;
                    if (streak == 4) {
                        winner = turn;
                        return ;
                    }
                    row++;
                    column++;
                }
            }
        }





    }

}


interface  Gameplay
{
    void play();
}


class Human implements Gameplay{
    Scanner in = new Scanner(System.in);
    public void play()
    {
        hex_manager manobj =  new hex_manager();

        int x, y;
        while(true)
        {
            System.out.println("User input the x cor of the move you wanna implement");
            x = in.nextInt();
            System.out.println("User input the y cor of the move you wanna implement");
            y = in.nextInt();
            manobj.x = x;
            manobj.y = y;
            if (manobj.board[x ][y ] == "*") {
                System.out.println("invalid coordinates");
                continue;
            }
            else
                break;
        }
        if (manobj.turn == "X") {
            manobj.board[x][y ] = "X";
        } else {
            manobj.board[x ][y ] = "O";
        }
    }

}




class Comp implements Gameplay {
    public void play() {
        int flag = 0;

        hex_manager supmanagerObj = new hex_manager();


        System.out.println("It is computers chance  to make a move now");
        for (int i = 0; i < Reattempt.size; i++) {
            for (int j = 0; j <Reattempt.size; j++) {
                if ((supmanagerObj.board[i][j]).equals("*")) {
                    supmanagerObj.board[i][j] = "X";
                    supmanagerObj.x=i;
                    supmanagerObj.y=j;
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }

    }


}