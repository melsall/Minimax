import java.util.*;
import java.io.*;
public class NimRunner {

    public static void main (String [] args){
        System.out.println(makeRandomStates());
        ArrayList <Integer> rands = new ArrayList <> ();
        rands.add(3);
        rands.add(5);
        rands.add(7);
        System.out.println(minimax(rands, true));
    }
    // // // function that actually runs game/ simulates real game play
    // public static boolean runGame(){
    //     boolean isXTurn = false;
    //     // make state a 2D array?
    //     ArrayList <Integer> states = new ArrayList <> ();
    //     states.add(1);
    //     states.add(1);

    //     // Tracking total objects in the arrayList
    //     int totalObjects = 0;
    //     for (int r = 0; r < states.size(); r++){
    //         totalObjects = totalObjects + states.get(r);
    //         }

    //         // can take from one pile at a time, so iterate through each pile, see moves
    //     int state = 2;
    //     while(state >= 1){
    //         if (isXTurn){
    //             // updating state to subtract the correct number of objects
    //             state = getXMove(state);
    //             System.out.println("NEW STATE:" + state);

    //         }
    //         else {
    //             state = getYMove(state); 
    //             System.out.println("In y move, state after y moves" + state);
    //         }
    //         isXTurn = !isXTurn;
    //     }
    //     if (state == 0 && isXTurn){
    //         return true;
    //     }
    //     return false;
    // }
    // function to make a board with random # of piles with random # of objects within each
    public static ArrayList <Integer> makeRandomStates(){
        ArrayList <Integer> states = new ArrayList <>();
        for(int i = 0; i < (int)(Math.random()*15) + 1; i++){
            states.add((int) (Math.random() * 15 ) + 1); // adding pile of random size
        }
        return states;
    }

    // // function to return the total amount of objects in a game with multiple piles
    // public static int getTotalObjects(ArrayList <Integer> states){
    //     for(int r = 0; r < states.size(); r++){

    //     }
    // }

    // // figure out where X will move, I am player X 
    // public static int getXMove(int state){
    //     return state - bestMove(state, true);
    // }

    // // figure out where Y will move
    // public static int getYMove(int state){
    //     return state - bestMove(state, true);
    // }

    // Minimax Function
    public static int minimax(ArrayList <Integer> states, boolean myTurn){
        //base case (there are no objects in any of the piles)
        if (isBaseCase(states)){
            if (myTurn){
                return 1; // if it is my turn and the state is 0, I won
            }
            else{
                return -1; // if it is not my turn and there are no objects, I lost
            }
        }
        else{
            // if it's not the base case, have to iterate through each pile
            for (int p = 0; p < states.size(); p++){ // iterate through each pile
                for (int c = 0; c < states.get(p); c++){ // iterate through each object in the piles
                    ArrayList <Integer> currentPiles = new ArrayList <Integer> (states); // holder to test results of different states
                    currentPiles.set(p, c); // setting the current pile to have c objects to see if it would be favorable for minimax
                    // recursive step
                    if (myTurn){
                        if (minimax(currentPiles, !myTurn) == 1){
                            return 1;  
                        }
                    }
                    else{
                        if(minimax(currentPiles, !myTurn) == -1){
                            return -1;
                        }
                    }
                }
            }
        }
        // honestly I'm confused on why this would even work
        if (myTurn){
            return -1;
        }
        return 1;
    }
    // helper function to see if it is the base case for minimax, returns true if it is the base case
    public static boolean isBaseCase(ArrayList <Integer> states){
        for(int i = 0; i < states.size(); i++){
            if(states.get(i) != 0){
                return false; // if one of the piles have more than 0 objects, it is not the base case
            }
        }
        return true; // if you have iterated through the whole for loop and all of the piles have 0, it is the base case
    }
    // // Best Move Function: 
    public static ArrayList <Integer> bestMove(ArrayList <Integer> states, boolean myTurn){
        for(int r = 0; r < states.size(); r++){ // loop through all of the possible moves
            for(int c = 1; c <= states.get(r); c++){
                ArrayList <Integer> currentPiles = new ArrayList <Integer> (states);
                currentPiles.set(r, currentPiles.get(r) - c); // editing currentpiles to see what happens when you take c pieces
                if (myTurn){
                    if (minimax(currentPiles, !myTurn) == 1){ // if you get a 1 at any point, you can just break because it's a favorable path
                        return currentPiles; // return the new state of the game
                    }
                }
                else{
                    if (minimax(currentPiles, !myTurn) == -1){
                        return currentPiles;
                    }
                }
            }
        }
        ArrayList <Integer> rat = new ArrayList <>();
        rat.add(1);
        return rat;
    }


// /*

//     BEST MOVE: return the move the pieces taken)
//     - check every possible move
//     - for every possible move, check what it owould be 
//     - callll minimax on the next state
//     - return the number of pieces taken, just steal 3 or something 
//     */

//     // if minimax - piecesTaken > 0 , return high 
    
//     // call minimax three times in your recursive step, if you hit -1, return the minimum 
//     // make an array list, go through three possible state, 1 and -1 will be returned, 

//     /* new minimax code 
//     - have to call minimax recursively on all three states, that will give you three numbers, 
//     - in order to know what time state is, you had to calll minimax recursively on the above state, have to call it 
//     until you get to the base case 
    
// */ 

}