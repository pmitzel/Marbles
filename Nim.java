/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab1;

//imports necessary libraries
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Del Peter
 */
//public class as well as global variables
public class Nim {
    private int marbles;
    private int turn;
    private int intel;
    
//Method to determine who goes first, how many marbles, and how smart the computer is
public void setup(){
    Random ran = new Random();
    marbles = ran.nextInt(91) + 10;
    turn = ran.nextInt(2);
    intel = ran.nextInt(2);
    }

//After the setup is determined, this method will print the three factors that determine how the game will go.
//This includes the intel of the computer, the initial marble count, and who goes first.
public void print_setup(){ 
    //System.out.println(marbles);
    System.out.println("There are " + marbles + " marbles.");
    //System.out.println(turn);
    if(turn == 1){
        System.out.println("Human goes first.");
    }else{
        System.out.println("Computer goes first.");
    }
    //System.out.println(intel);
    if(intel == 1){
        System.out.println("Computer is stupid.");
    }else{
        System.out.println("Computer is smart.");
    }
    System.out.println("");
}

//This method runs the calculations and actions behind the computer when it has its turn.
public void computer_turn(){
    Random ran = new Random();
    int taken = 0;
    //This is a case that applies no matter how smart the computer is.
    if(marbles == 1 || marbles == 2 || marbles == 3){
       taken = 1;
       System.out.println("Computer is allowed to take 1 marble.");
       System.out.println("Computer takes " + taken + " marble.");
       marbles = marbles - taken;
    }else{
        if(intel == 1){
            //lines of code for when the computer is stupid
           taken = ran.nextInt((int)(marbles/2 - 1)) + 1;
           System.out.println("Computer is allowed to take between 1 and " + (int)(marbles/2) + " marble(s).");
           System.out.println("Computer takes " + taken + " marble(s).");
           marbles = marbles - taken;
        }else{
            //This is the process the computer follows for when it is smart.
           if(marbles == 63 || marbles == 31 || marbles == 15 || marbles == 7 || marbles <= 3){
               taken = ran.nextInt((int)(marbles/2 - 1)) + 1;
           }else if(marbles > 63){
               taken = marbles - 63;
           }else if(marbles > 31){
               taken = marbles - 31;
           }else if(marbles > 15){
               taken = marbles - 15;
           }else if(marbles > 7){
               taken = marbles - 7;
           }else if(marbles > 3){
               taken = marbles - 3;
           }
           System.out.println("Computer is allowed to take between 1 and " + (int)(marbles/2) + " marble(s).");
           System.out.println("Computer takes " + taken + " marble(s).");
           marbles = marbles - taken;
        }
    }
    //additional information for the results of the turn that the user can see.
    System.out.println("");
    System.out.println("There are " + marbles + " marble(s) left.");
    System.out.println("");
}
//Method for when the human is to make a move.
public void human_turn(){
    int taken = 0;
    Scanner scan;
    scan = new Scanner(System.in);
    System.out.println("You are allowed to take between 1 and " + (int)(marbles/2) + " marble(s).");
    System.out.println("");
    System.out.println("Input how much you want to take: ");
    taken = (int)scan.nextInt();
    System.out.println("You took " + taken + " marble(s).");
    marbles = marbles - taken;
    System.out.println("");
    System.out.println("There are " + marbles + " marble(s) left.");
    System.out.println("");
}
//This method constantly calls the computer and human turns until there are no more marbles.
//This includes victory or defeat statments depending on who takes the last marble.
public void play_game(){
    //Process for when the computer goes first.
    if(turn == 0){
        while(marbles > 0){
            if(marbles <= 0){
                System.out.println("You lose, play again?");
            }else{
                computer_turn();
            }
            if(marbles <= 0){
                System.out.println("Computer loses, good job!");
            }else{
                human_turn();
            }
            if(marbles <= 0){
               System.out.println("You lose, play again?"); 
            }
            
        }
        //Process for when the human goes first
    }else{
        while(marbles > 0){
            if(marbles <= 0){
                System.out.println("Computer loses, good job!");
            }else{
                human_turn();  
            }
            if(marbles <= 0){
                System.out.println("You lose, play again?");
            }else{
                computer_turn();
            }
            if(marbles <= 0){
               System.out.println("Computer loses, good job!"); 
            }
        }
    }
}
}
