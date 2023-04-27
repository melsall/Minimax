# Minimax Project: Melina Salame

## **Background and Motivation**
### Motivation:
The motivation for creating this project was to learn more about implementing recursive algorithms and game theory. Also, a goal of this project was to see if I could create a bot that could win (well... mostly) at the game of Nim

### What is Nim?

Nim is a two player game involving a number of different piles of objects. The piles can have differing amounts of objects. The goal of the game is to not be the player to take the last object. You may take as many objects as you want at a time, but you may not take objects from more than one pile within a single turn. The two players alternate taking objects. The game continues until someone is forced to take the last object, and they lose. This game is zero-sum, meaning if one player wins, the other will lose and vice versa.

There is another version of Nim called SimpleNim. In SimpleNim, there is one pile of objects and each player may only take 1, 2, or 3 objects in a single turn. This game is still zero-sum, and whichever player takes the last object still loses. 

### **Usage**
This program is very easy to use. There are no command-line arguments or input files. Simply compile and run the Tests.java file. The computer will give you prompts updating you on the state of the gameboard (the various piles of objects), and you will pick which pile you would like to take from and how many pieces you would like to take. The game continues until the board is empty and you or the bot have won. 

### **Future Directions**
There are multiple ways in which my code could be improved. 

Firstly, my code could be made more efficient. Right now, my algorithm can handle up to about 5 piles of 6 pieces. Anywhere over that and it takes an unreasonably long time. 

Secondly, a good addition to my code would have been to keep the SimpleNim algorithm in. Based on a prompt and user-input, the user could choose if they wanted to play simple or regular Nim. 

Another improvement that could be made to my code would be the addition of "levels." Most games that implement similar algorithms do not just try and win every time. Take chess for instance, on chess.com you can choose if your opponent is "easy," "medium," or "hard." It would be a big improvement to my code if someone coded these different "levels" into the Nim bot. Perhaps based on some probability, the easy bot could make the correct best move the least often, and the "hard" bot could make the correct best move the most often.

If you want to contribute to my project, get my code from my github. Consider making the eidts I mentioned above or others. Make sure to cite your sources...