import java.util.*;
public class Tests {
    public static void main(String [] args){
        System.out.println("Testing my NimRunner class.");

        // ArrayList I know that the bot should be able to win: making sure minimax algorithm actually works
        ArrayList <Integer> winnableTest = new ArrayList <> ();
        winnableTest.add(1);
        winnableTest.add(2);
        System.out.println(NimRunner.minimax(winnableTest, true) == 1); // should return true beause minimax should be able to win if this is the starting state
        
        // Testing if bestMove works correctly
        ArrayList <Integer> bestMoveTest = new ArrayList <> ();
        bestMoveTest.add(4);
        bestMoveTest.add(2);
        System.out.println(NimRunner.minimax(NimRunner.bestMove(bestMoveTest, true), false) == 1); // seeing if after bot makes a move, if the board is favorable to the bot (aka they made a best move)
        
        // testing if the bot works even if there is no move that would guarantee a win
        ArrayList <Integer> notWinnable = new ArrayList <> ();
        notWinnable.add(2);
        notWinnable.add(2);
        System.out.println(NimRunner.bestMove(notWinnable, true)); // should print out states of game board with some piece taken even though there is not toally favorable move
        
        // there is a favorable move to be made for this function, seeing if my bot recognizes that 
        ArrayList <Integer> tester2 = new ArrayList <> ();
        tester2.add(2);
        tester2.add(2);
        tester2.add(3);
        System.out.println(NimRunner.minimax(tester2, true) == 1); // if this is true, bot recognized there was a favorable move 

        // Seeing if my bot correctly makes the best move
        tester2 = new ArrayList <Integer> ();
        tester2.add(2);
        tester2.add(1);
        System.out.println(NimRunner.bestMove(tester2, true).equals(new ArrayList <> (Arrays.asList(0,1)))); // if this is true, the bot recognized to take the pile with 2 pieces was the best move
        
        // testing running the game with a person as a player
        System.out.println(NimRunner.runGame()); // if this is true the bot won
    }
}