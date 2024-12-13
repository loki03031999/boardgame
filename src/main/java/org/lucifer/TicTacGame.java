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
    initializePlayers();
    initializeGame();

    while (!ticTacRuleEngine.isGameComplete(ticTacBoard)) {
      //who should provide the validation of input provided by the player
      //rule engine performs validations during reading input from player
      Move humanPlayerMove = readPlayerInput();
      ticTacBoard.makeMove(humanPlayerMove, humanPlayer.getSymbol());

      Move computerSuggestedMove = ticTacAIEngine.suggestMove(ticTacBoard);
      ticTacBoard.makeMove(computerSuggestedMove, compPlayer.getSymbol());

      System.out.println(ticTacBoard);
    }

    if (ticTacRuleEngine.getWinner(ticTacBoard) == humanPlayer.getSymbol()) {
      System.out.printf("Congratulation %s you won the game", humanPlayer.getName());
    }
    else {
      System.out.println("Better luck next time");
    }
  }

  private Move readPlayerInput() {
    System.out.print("Please make a move - ");

    int xPos, yPos;
    while(true) {
      xPos = scanner.nextInt();
      yPos = scanner.nextInt();

      if (ticTacRuleEngine.isValidMove(xPos, yPos, ticTacBoard)) break;
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
    return new Player("computer", symbol);
  }

  private Player createHumanPlayer() {
    System.out.print("Please enter your name - ");
    String humanPlayerName = scanner.nextLine();
    System.out.print("Print enter your symbol (Select from O or X) - ");
    
    while (true) {
      String humanPlayerSymbolString = scanner.nextLine();
      try {
        XOSymbol humanPlayerSymbol = XOSymbol.createXOSymbol(humanPlayerSymbolString);
        return new Player(humanPlayerName, humanPlayerSymbol);
      }
      catch (IllegalArgumentException illegalArgumentException) {
        System.out.println("Provided symbol is incorrect, Please enter correct symbol");
      }
    }
  }

}
