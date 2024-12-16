package org.lucifer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacBoardTest {

  @Test
  public void testInitialization() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        Assertions.assertEquals(XOSymbol.NOT_ASSIGNED, ticTacBoard.getSymbol(x, y));
      }
    }
  }

  @Test
  public void testMakeMoveValidMove() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    Move move = new Move(1, 2);
    ticTacBoard.makeMove(move, XOSymbol.X);
    Assertions.assertEquals(XOSymbol.X, ticTacBoard.getSymbol(1, 2));
  }

  @Test
  public void testMakeMoveInvalid() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    Move move = new Move(3, 3);
    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> ticTacBoard.makeMove(move, XOSymbol.X));
    Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
  }
}