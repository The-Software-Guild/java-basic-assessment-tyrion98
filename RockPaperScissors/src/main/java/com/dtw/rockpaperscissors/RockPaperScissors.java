/**
 *@author DeJone' Williamson
 *email: tyrionw@gmail..com
 *date: 7/26/2021
 *purpose: My first Hello World program in an IDE
 */
package com.dtw.rockpaperscissors;

// import scanner and random
import java.util.Scanner;
import java.util.Random;
// class
public class RockPaperScissors {
    
    // main function
    public static void main(String[] args){
    
        // call game loop function
        gameLoop();

    }
    
    // game loop
    public static void gameLoop(){
    
        // variable declarations
        int roundNum, i = 0, winner = 0;
        int playerChoice, tie = 0, playerWin = 0, compWin = 0;
        String playAgain = "";
        Scanner sc = new Scanner(System.in);
        
        
        // ask the user how many rounds they want to play
        System.out.println("How many rounds do you want to play? (max = 10, min = 1)");
        // input
        roundNum = sc.nextInt();
        
        // error check
        if(roundNum <= 0 || roundNum > 10){
        
            // error msg & exit out of program
            System.out.println("ERROR! OUT OF RANGE!");
            System.exit(0);
        
        }
        
        // call the game function, round number of times
        while(i < roundNum){
            // ask for user choice
            System.out.println("Choose one! 1 = Rock, 2 = Paper or 3 = Scissors? (Please enter a number from 1-3) ");
            playerChoice = sc.nextInt();

            // call main game function
            winner = game(playerChoice);
            // add to win counter
            switch(winner){
                
                // comp win
                case -1:
                    compWin++;
                    break;
                // tie
                case 0:
                    tie++;
                    break;
                // player win
                case 1:
                    playerWin++;
                    break;
                
            }
            
            i++;
        }
        // print out number of ties, player wins and comp wins
        System.out.println("\nNumber of Player wins: " + playerWin);
        System.out.println("Number of Computer wins: " + compWin);
        System.out.println("Number of ties: " + tie);
        
        // call winner print
        winnerPrint(playerWin, compWin);

        // ask player if they want to play again
        System.out.println("Game over. Do you want to play again? (yes/no) ");
        playAgain = sc.next();
        
        //convert to lower case
        playAgain = playAgain.toLowerCase();
        
        // check if user wants to play again
        if(playAgain.equals("yes")){
        
            // call function
            System.out.println("Restarting game...");
            gameLoop();
            
        } else if (playAgain.equals("no")){
        
            // print exit msg and then exit
            System.out.println("Thanks for playing!");
            System.exit(0);
            
        } else{
        
            System.out.println("Wrong input, exiting program.");
            System.exit(0);
        }
        
        // close scanner 
        sc.close();
        
    }
     
    // winner print
    public static void winnerPrint(int playerWin, int compWin){
    
        // declare the overall winner
        if(playerWin > compWin){
        
            System.out.println("Overall winner: PLAYER!!");
            
        }else if(compWin > playerWin){
        
            System.out.println("Overall winner: COMPUTER!");
            
        }else{
        
            System.out.println("Overall winner: NONE!");
        }
        
        System.out.println();
    
    }
    
    // main game function
    public static int game(int playerChoice){
    
        // variables
        Random rand = new Random();
        int compChoice;
        // player win = 1, comp win = -1, tie = 0
        int winner;
        // make the computer choose a random number from 1-3
        compChoice = rand.nextInt(3) + 1;
        
        System.out.println("Computer choice: "+ compChoice);
        // print who wins 
        if(compChoice-1 == playerChoice){
        
            System.out.println("Computer win!");
            winner = -1;
            
        } else if(playerChoice-1 == compChoice){
        
            System.out.println("Player win!");
            winner = 1;
         
        }else if(compChoice-2 == playerChoice){
        
            System.out.println("Player win!");
            winner = 1;
            
        }else if(playerChoice-2 == compChoice){
        
            System.out.println("Computer win!");
            winner = -1;
        }  
        
        else{
        
            System.out.println("Tie!");
            winner = 0;
        }
        
        
        // return who won
        return winner;
    
    }
}
