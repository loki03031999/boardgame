1. Player Should be able to play alone. Computer should play as opponent


Responsibilities by each class
- TicTacGame
   - starts the game
   - initializes the board - initialized the class instances for TicTacBoard
   - initialized the playing computer
   - takes input from player
   - runs the game till game finishes
   - outputs the result
- TicTacBoard
   - stores the state for board
   - implement the game rules check algorithm
   - make a move provided by the player
   - provides getter setter for board state, used by computer to set state
   - displays the winner once game is finished
   - displays the state current state of game
- TicTacComputer
  - makes a move
  - depends on state of computer