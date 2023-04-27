import java.util.*;
public class Tests {
    public static void main(String [] args){
        System.out.println("Testing my NimRunner class.");

        // ArrayList I know that the bot should be able to win: making sure minimax algorithm actually works
        ArrayList <Integer> winnableTest = new ArrayList <> ();
        winnableTest.add(1);
        winnableTest.add(2);
        winnableTest.add(3);
        System.out.println(NimRunner.minimax(winnableTest, true) == 1); // should return true beause minimax should be able to win if this is the starting stae
        //System.out.println(NimRunner.minimax(0, true));
    }
}