package org.lucifer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacRuleEngineTest {
  TicTacRuleEngine ticTacRuleEngine;

  @BeforeEach
  public void initialization() {
    ticTacRuleEngine = new TicTacRuleEngine();
  }

  @Test
  public void testIsGameCompleteIncomplete() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    Assertions.assertFalse(ticTacRuleEngine.isGameComplete(ticTacBoard));
  }

  @Test
  public void testIsGameCompleteNoWinner() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    fillBoardNoWinner(ticTacBoard);
    Assertions.assertTrue(ticTacRuleEngine.isGameComplete(ticTacBoard));
  }

  @Test
  public void testGetWinnerCompleteNoWinner() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    fillBoardNoWinner(ticTacBoard);
    Assertions.assertNull(ticTacRuleEngine.getWinner(ticTacBoard));
  }

  @Test
  public void testGetWinnerXHorizontalWinner() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    fillBoardWinner(ticTacBoard);
    Assertions.assertEquals(XOSymbol.X, ticTacRuleEngine.getWinner(ticTacBoard));
  }

  @Test
  public void testGetWinnerDiagonalWinner() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    ticTacBoard.makeMove(new Move(0, 0), XOSymbol.X);
    ticTacBoard.makeMove(new Move(1, 1), XOSymbol.X);
    ticTacBoard.makeMove(new Move(2, 2), XOSymbol.X);
    Assertions.assertEquals(XOSymbol.X, ticTacRuleEngine.getWinner(ticTacBoard));
  }

  @Test
  public void testIsValidMoveOutOfBoundMove() {
    Assertions.assertFalse(ticTacRuleEngine.isValidMove(new Move(3, 3), new TicTacBoard()));
  }

  @Test
  public void testIsValidMoveAlreadyFilled() {
    TicTacBoard ticTacBoard = new TicTacBoard();
    Move move = new Move(1, 1);
    ticTacBoard.makeMove(move, XOSymbol.X);
    Assertions.assertFalse(ticTacRuleEngine.isValidMove(move, ticTacBoard));
  }

  private void fillBoardWinner(TicTacBoard ticTacBoard) {
    boolean alternate = false;
    for (int y = 0; y < 3; y++) {
      alternate = !alternate;
      for (int x = 0; x < 3; x++) {
        ticTacBoard.makeMove(new Move(x, y), (alternate) ? XOSymbol.X : XOSymbol.O);
      }
    }
  }

  private void fillBoardNoWinner(TicTacBoard ticTacBoard) {
    boolean alternate = false;
    for (int y = 0; y < 3; y++) {
      if (y == 2) alternate = !alternate;
      for (int x = 0; x < 3; x++) {
        ticTacBoard.makeMove(new Move(x, y), (alternate) ? XOSymbol.X : XOSymbol.O);
        alternate = !alternate;
      }
    }
  }

}