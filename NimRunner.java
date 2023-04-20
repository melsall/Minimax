import java.util.*;
import java.io;
public class NimRunner {
    // instance variables of class
    // method to run the game
    // return true if player X won, false if player Y won
    public static void main (String [] args){
        System.out.println(runGame());
    }

    public static boolean runGame(){
        boolean isXTurn = true;
        int state = Math.floor(Math.random() *(15 - 1 + 1) + 1);
        while(state >= 1){
            if (isXturn){
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
        while(chosenInt > state){
            int chosenInt = Math.floor(Math.random() *(3 - 1 + 1) + 1);
        }
        return state - chosenInt;
    }

    // figure out where Y will move
    public static int getYMove(int state){
        public static int getXMove(int state){
        while(chosenInt > state){
            int chosenInt = Math.floor(Math.random() *(3 - 1 + 1) + 1);
        }
        return state - chosenInt;
    }
    }

    public static int minimax(int state, boolean myTurn){
        // base case: state = 0
        if (state == 0){
            // if it is my turn and the state 
            if (myTurn){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            for (int i = 0; i < 3; i++){
                if (state - i >= 0){
                    int state = minimax(state - i);
                }
            }
        }
        // get possible states
        return state; 
    }
}