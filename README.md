# AI-Project-Connect4
SUMMARY: a turn based two player game playing a connect-4 like game (the scoring in this game is different). 
One of the player is an AI agent using Minimax algorithm.
RUN: GameAdmin. currently runs 9x9 board with 6 levels. 


GAME DESCRIPTION:

1. Turn base game. Player 1 (Human) is X and goes first. Player 2 "O" is AI and goes second. 

2. Each turn, players choose a row in which they would like to drop their piece. 

   The piece drops to the lowest available space (like in connect 4)

3. Scoring is done as such:

  2 points if the pieces immediatly next to you (up, down, left, right) are your pieces.

  1 point if pieces diagnal to you are your own. 
  
  (a bit hard to explain, play the game and you'll get it).
  
4. player with most points wins!


Minimax Description:

Minimax takes into account the following variables. 

1. wants to maximize its score and minimize opponent score at each turn.

2. gets points for blocking points from the opponent.

3. gets some points for having an empty space around it. 




*** NO ALPHA BETA PRUNING WAS IMPLEMENTED IN THIS GAME ****
