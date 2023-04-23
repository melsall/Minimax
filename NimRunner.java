import java.util.*;
import java.io.*;
public class NimRunner {
    // instance variables of class
    // method to run the game
    // return true if player X won, false if player Y won
    public static void main (String [] args){
        System.out.println(bestMove(1, true));

    }

    public static boolean runGame(){
        boolean isXTurn = true;
        int state = (int) Math.floor(Math.random() *(15 - 1 + 1) + 1); // generatinga  random state
        while(state >= 1){
            if (isXTurn){
                // updating state to subtract the correct number of objects
                state = getXMove(state);

            }
            else {
                // 
                state = getYMove(state);
            }
            isXTurn = !isXTurn;
        }
        return isXTurn;
    }

    // figure out where X will move
    public static int getXMove(int state){
        int chosenInt = 0;
        while(chosenInt > state){
            chosenInt = (int) Math.floor(Math.random() *(3 - 1 + 1) + 1);
        }
        return state - chosenInt;
    }

    // figure out where Y will move
    public static int getYMove(int state){
        int chosenInt = 0;
        while(chosenInt > state){
            chosenInt = (int) Math.floor(Math.random() *(3 - 1 + 1) + 1);
        }
        return state - chosenInt;
    }

    // NEW MINIMAX FUNCTION
    public static int minimax(int state, boolean myTurn){
        //base case (state = 0)
        if (state == 0){
            if (myTurn){
                return 1; // if it is my turn and the state is 0, I won
            }
            else{
                return -1; // if it is not my turn and the state is 0, I lost
            }
        }
        else{
            ArrayList <Integer> listOfScores = new ArrayList <> ();
            listOfScores.add(minimax(state - 1, !myTurn));
            if(state - 2 >= 0){ // check to make sure subtracting 2 pieces will not result in a negative number of pieces (because that's not possible)
                listOfScores.add(minimax(state - 2, !myTurn));
            }
            if(state - 3 >= 0){ // check to make sure subtracting 3 pieces will not result in a negative number of pieces (because that's not possible)
                listOfScores.add(minimax(state - 3, !myTurn));
            }
            if(myTurn){
                return Collections.max(listOfScores); // if it is your turn, you want the max of the list to be returned
            }
            else{ // if it's not your turn, you want the min of the list to be returned
                return Collections.min(listOfScores);
            }
        }
    }
// if minimax - piecesTaken > 0 , return high 
    
    // call minimax three times in your recursive step, if you hit -1, return the minimum 
    // make an array list, go through three possible state, 1 and -1 will be returned, 

    /* new minimax code 
    - have to call minimax recursively on all three states, that will give you three numbers, 
    - in order to know what time state is, you had to calll minimax recursively on the above state, have to call it 
    until you get to the base case 
    
*/ 
    // Best Move Function: 
    public static int bestMove(int state, boolean myTurn){
        for(int i = 1; i <= 3; i++){ // loop through all of the possible moves (taking 1, 2, or 3)
            if (state - i >= 0 && myTurn){
                if (minimax(state - i, !myTurn) == 1){ // have to make the boolean condition for minimax !myTurn rather than myTurn because once I take these pieces, it will become the other player's turn
                    return i; // if taking i pieces results in 1 being returned, immediately return it becasue that means you will automatically win
                }
            }
            // finding the best move for the other player (they will want it to return -1)
            else if(state - i >= 0 && !myTurn){
                if (minimax(state - i, myTurn) == -1){
                    return i; // if taking i pieces results in -1 being returned, immediatley return i bceasue you win
                }
            }
        }
        return 0;
    }


/*

    BEST MOVE: return the move the pieces taken)
    - check every possible move
    - for every possible move, check what it owould be 
    - callll minimax on the next state
    - return the number of pieces taken, just steal 3 or something 
    */

}