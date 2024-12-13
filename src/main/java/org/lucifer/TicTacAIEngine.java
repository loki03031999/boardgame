package org.lucifer;

public class TicTacAIEngine {

  public Move suggestMove(TicTacBoard ticTacBoard) {
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        if (ticTacBoard.getSymbol(x, y) == XOSymbol.NOT_ASSIGNED) {
          return new Move(x, y);
        }
      }
    }
    throw new RuntimeException("Not able to suggest a move");
  }
}
