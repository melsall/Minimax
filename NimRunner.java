import java.util.*;
import java.io.*;
public class NimRunner {

    public static void main (String [] args){
        System.out.println(makeRandomStates());
        ArrayList <Integer> rands = new ArrayList <> ();
        rands.add(1);
        rands.add(2);
        rands = bestMove(rands, true);
        System.out.println(rands);
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

    // figure out where X will move, computer is player X so should be ideal move
        // returns the new state of the board after this move is made
    public static ArrayList <Integer> getXMove(ArrayList <Integer> states){
        return bestMove(states, true); // just return whatever the best move would be for the function
    }

    // figure out where Y will move
    public static ArrayList <Integer> getYMove(ArrayList <Integer> states){
        boolean isValidMove = false;
        int yMove = 0;// declaring out here so it can be used throughout the function
        while(!isValidMove){
            Scanner sc = new Scanner(System.in);
            System.out.println("Which pile do you want to take from?");
            int pileTakenFrom = sc.nextInt();
            if(states.size() >= pileTakenFrom && pileTakenFrom >= 1){ // if it is a valid pile, ask how many objects they want to take and proceed with board
                System.out.println("Great. How many objects do you want to take?"); // figure out how many objects they want to take
                int objectsTaken = sc.nextInt();
                if (objectsTaken <= states.get(pileTakenFrom - 1) && objectsTaken >= 0){ // see if the pile even has that many objects
                    int originalAmountOfObjects = states.get(pileTakenFrom - 1);
                    int newAmountOfObjects = originalAmountOfObjects - objectsTaken;
                    states.set(pileTakenFrom - 1, newAmountOfObjects); // set the state of the board to account for the move
                    return states; // return new state of the board
                }
            }
            System.out.println("That was not a valid move, please try again."); // if either the pile number or the amount of objects they tried to take was invalid, this will be printed and the loop repeats
        }
        return states; // this will never be reached, just so the function doesn't malfunction
    }

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
            return -1; // 
        }
        else{
            return 1; // 
        }
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
    
    // Best Move Function: 
    // returns new state of the piles after utilizing the best move function
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
        // if you get to this point, there essentially is no "best move" because you can't win, make whatever move is possible and continue
        for(int i = 0; i < states.size(); i ++){
            if(states.get(i) != 0){ // if there are pieces in this pile, access the pile
                int piecesToTake = (int) (Math.random() * states.get(i)) + 1; // randomly choose an amount of pieces to take
                int originalNumPieces = states.get(i);
                states.set(i, (originalNumPieces - piecesToTake));
            }
        }
        return states; // return the updates ArrayList of states
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