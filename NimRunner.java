import java.util.*;
import java.io.*;
public class NimRunner {

    public static void main (String [] args){
        System.out.println(runGame());


    }
    // function that actually runs game/ simulates real game play
    public static boolean runGame(){
        boolean isXTurn = false;
        // make state a 2D array?
        ArrayList <Integer> states = new ArrayList <> ();
        states.add(1);
        states.add(1);

        // Tracking total objects in the arrayList
        int totalObjects = 0;
        for (int r = 0; r < states.size(); r++){
            totalObjects = totalObjects + states.get(r);
            }

            // can take from one pile at a time, so iterate through each pile, see moves
        int state = 2;
        while(state >= 1){
            if (isXTurn){
                // updating state to subtract the correct number of objects
                state = getXMove(state);
                System.out.println("NEW STATE:" + state);

            }
            else {
                state = getYMove(state); 
                System.out.println("In y move, state after y moves" + state);
            }
            isXTurn = !isXTurn;
        }
        if (state == 0 && isXTurn){
            return true;
        }
        return false;
    }

    // function to return the total amount of objects in a game with multiple piles
    public static int getTotalObjects(ArrayList <Integer> states){
        for(int r = 0; r < states.size(); r++){2

        }
    }

    // figure out where X will move, I am player X 
    public static int getXMove(int state){
        return state - bestMove(state, true);
    }

    // figure out where Y will move
    public static int getYMove(int state){
        return state - bestMove(state, true);
    }

    // Minimax Function
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
            else if(!myTurn){ // if it's not your turn, you want the min of the list to be returned
                System.out.println("in minimax station");
                return Collections.min(listOfScores);
            }
        }
        return 10000; 
    }
    // helper function to see if it is the base case for minimax, returns true if it is the base case
    public static boolean isBaseCase(ArrayList <Integer> states){
        for(int i = 0; i < states; i++){
            if(states.get(i) != 0){
                return false; // if one of the piles have more than 0 objects, it is not the base case
            }
        }
        return true; // if you have iterated through the whole for loop and all of the piles have 0, it is the base case
    }
    // Best Move Function: 
    public static int bestMove(int state, boolean myTurn){
        for(int i = 1; i <= 3; i++){ // loop through all of the possible moves (taking 1, 2, or 3)
            if (state - i >= 0 && myTurn){
                if (minimax(state - i, !myTurn) == 1){ // have to make the boolean condition for minimax !myTurn rather than myTurn because once I take these pieces, it will become the other player's turn
                    return i; // if taking i pieces results in 1 being returned, immediately return it becasue that means you will automatically win
                }
            }
            // finding the best move for the other player
            else if(state - i >= 0 && !myTurn){
                if (minimax(state - i, myTurn) == 1){
                    System.out.println("when Y takes they take: " + i + "pieces");
                    return i; // if taking i pieces results in -1 being returned, immediatley return i bceasue you win
                }
            }
        }
        return 1;
    }


/*

    BEST MOVE: return the move the pieces taken)
    - check every possible move
    - for every possible move, check what it owould be 
    - callll minimax on the next state
    - return the number of pieces taken, just steal 3 or something 
    */

    // if minimax - piecesTaken > 0 , return high 
    
    // call minimax three times in your recursive step, if you hit -1, return the minimum 
    // make an array list, go through three possible state, 1 and -1 will be returned, 

    /* new minimax code 
    - have to call minimax recursively on all three states, that will give you three numbers, 
    - in order to know what time state is, you had to calll minimax recursively on the above state, have to call it 
    until you get to the base case 
    
*/ 

}