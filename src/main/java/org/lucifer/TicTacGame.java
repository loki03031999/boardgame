package org.lucifer;

import java.util.Scanner;

/**
 * Responsible for -
 * 1. managing game.
 * 2. starting the game.
 * 3. taking input from player
 * 4. displaying the result
 *
 */
public class TicTacGame {
  private final Scanner scanner;
  private TicTacBoard ticTacBoard;
  private TicTacRuleEngine ticTacRuleEngine;
  private TicTacAIEngine ticTacAIEngine;
  private Player humanPlayer;
  private Player compPlayer;

  public TicTacGame() {
    scanner = new Scanner(System.in);
  }

  public void start() {
    System.out.println("Welcome to XO game\n");
    initializeGame();
    initializePlayers();
    makeMoves();
    diplayWinner();
  }

  private void diplayWinner() {
    XOSymbol winnerSymbol = ticTacRuleEngine.getWinner(ticTacBoard);

    if (winnerSymbol == humanPlayer.getSymbol()) {
      System.out.printf("Congratulation %s you won the game", humanPlayer.getName());
    }
    else if (winnerSymbol == compPlayer.getSymbol()){
      System.out.println("You lost the game, Better luck next time");
    }
    else {
      System.out.println("Game Draw");
    }
  }

  private void makeMoves() {
    boolean flag = false;
    while (!ticTacRuleEngine.isGameComplete(ticTacBoard)) {
      if (flag = !flag) makeMoveHuman();
      else makeMoveComputer();
      System.out.println(ticTacBoard);
    }
  }

  private void makeMoveComputer() {
    Move computerSuggestedMove = ticTacAIEngine.suggestRandomMove(ticTacBoard, ticTacRuleEngine);
    ticTacBoard.makeMove(computerSuggestedMove, compPlayer.getSymbol());

    System.out.printf("Computer move - %s\n", computerSuggestedMove);
  }

  private void makeMoveHuman() {
    //who should provide the validation of input provided by the player
    //rule engine performs validations during reading input from player
    Move humanPlayerMove = readPlayerInput();
    ticTacBoard.makeMove(humanPlayerMove, humanPlayer.getSymbol());
    System.out.printf("your move - %s\n", humanPlayerMove);
  }

  private Move readPlayerInput() {
    System.out.print("Please make a move - ");

    int xPos, yPos;
    while(true) {
      xPos = scanner.nextInt();
      yPos = scanner.nextInt();

      if (ticTacRuleEngine.isValidMove(new Move(xPos, yPos), ticTacBoard)) break;
      else System.out.println("You have made an incorrect move, please try again");
    }
    return new Move(xPos, yPos);
  }

  private void initializeGame() {
    ticTacBoard = new TicTacBoard();
    ticTacAIEngine = new TicTacAIEngine();
    ticTacRuleEngine = new TicTacRuleEngine();
  }

  private void initializePlayers() {
    this.humanPlayer = createHumanPlayer();
    this.compPlayer = createComputerPlayer(XOSymbol.createOppositeSymbol(this.humanPlayer.getSymbol()));
    System.out.printf("Your sign is - %s, Computer's Sign is - %s\n", this.humanPlayer.getSymbol(), this.compPlayer.getSymbol());
  }
  
  private Player createComputerPlayer(XOSymbol symbol) {
    return new Player("computer",PlayerType.COMPUTER, symbol);
  }

  private Player createHumanPlayer() {
    System.out.print("Please enter your name - ");
    String humanPlayerName = scanner.nextLine();
    System.out.print("Print enter your symbol (Select from O or X) - ");
    
    while (true) {
      String humanPlayerSymbolString = scanner.nextLine();
      try {
        XOSymbol humanPlayerSymbol = XOSymbol.createXOSymbol(humanPlayerSymbolString);
        return new Player(humanPlayerName, PlayerType.HUMAN, humanPlayerSymbol);
      }
      catch (IllegalArgumentException illegalArgumentException) {
        System.out.println("Provided symbol is incorrect, Please enter correct symbol");
      }
    }
  }

}
