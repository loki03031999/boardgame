package org.lucifer;

import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TicTacAIEngine {

  private final RandomGenerator randomGenerator;

  public TicTacAIEngine() {
    randomGenerator = new Random();
  }

  public Move suggestMove(TicTacBoard ticTacBoard, TicTacRuleEngine ticTacRuleEngine) {
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        if (ticTacBoard.getSymbol(x, y) == XOSymbol.NOT_ASSIGNED) {
          return new Move(x, y);
        }
      }
    }
    throw new RuntimeException("Not able to suggest a move");
  }

  private Move suggestSmartMove(TicTacBoard ticTacBoard, TicTacRuleEngine ticTacRuleEngine) {
    if (ticTacBoard.countMoves() == 3) {
      return null;
    }
    else {
      return suggestRandomMove(ticTacBoard, ticTacRuleEngine);
    }
  }

  public Move suggestRandomMove(TicTacBoard ticTacBoard, TicTacRuleEngine ticTacRuleEngine) {
    Move move = null;
    try {
      Thread.sleep(Duration.ofSeconds(1));
    }
    catch (Exception e) {

    }
    while (!ticTacRuleEngine.isValidMove(move, ticTacBoard)) {
      int xPosition = randomGenerator.nextInt(0, 3);
      int yPosition = randomGenerator.nextInt(0, 3);
      move = new Move(xPosition, yPosition);
    }
    return move;
  }
}
