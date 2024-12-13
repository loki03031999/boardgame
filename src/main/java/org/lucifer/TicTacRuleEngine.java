package org.lucifer;

public class TicTacRuleEngine {
  public boolean isGameComplete(TicTacBoard ticTacBoard) {
    //when all position filled;
    if (areAllPositionFilled(ticTacBoard)) return true;

    //check for vertical all x filled position
    return getWinner(ticTacBoard) != null;
  }

  public XOSymbol getWinner(TicTacBoard ticTacBoard) {
    XOSymbol verticalSymbol = checkVertical(ticTacBoard);
    XOSymbol horizontalSymbol = checkHorizontal(ticTacBoard);
    XOSymbol diagonalSymbol = checkDiagonal(ticTacBoard);
    if (verticalSymbol != null) return verticalSymbol;
    if (horizontalSymbol != null) return horizontalSymbol;
    return diagonalSymbol;
  }

  public boolean isValidMove(int x, int y, TicTacBoard ticTacBoard) {
    if (x < 0 || y < 0 || x > 2 || y > 2) return false;
    return (ticTacBoard.getSymbol(x, y) == XOSymbol.NOT_ASSIGNED);
  }

  private XOSymbol checkDiagonal(TicTacBoard ticTacBoard) {
    //diagonal check
    boolean areAllCellsEqual = false;
    for (int currCellCount = 1; currCellCount < 3; currCellCount++) {
      if (ticTacBoard.getSymbol(currCellCount-1, currCellCount-1) == ticTacBoard.getSymbol(currCellCount, currCellCount)) {
        areAllCellsEqual = true;
      }
      else {
        areAllCellsEqual = false;
        break;
      }
    }

    if (areAllCellsEqual && ticTacBoard.getSymbol(0, 0) != XOSymbol.NOT_ASSIGNED) return ticTacBoard.getSymbol(0, 0);

    //reverse diagonal check
    for (int currCellCount = 1; currCellCount < 3; currCellCount++) {
      if (ticTacBoard.getSymbol(3 - currCellCount, currCellCount - 1) == ticTacBoard.getSymbol(2 - currCellCount, currCellCount)) {
        areAllCellsEqual = true;
      }
      else {
        areAllCellsEqual = false;
        break;
      }
    }

    if (areAllCellsEqual && ticTacBoard.getSymbol(2, 0) != XOSymbol.NOT_ASSIGNED) return ticTacBoard.getSymbol(0, 0);
    return null;
  }

  private XOSymbol checkVertical(TicTacBoard ticTacBoard) {
    for (int x = 0; x < 3; x++) {
      boolean isCurrColSymbolEqual = true;
      for (int y = 1; y < 3; y++) {
        if (ticTacBoard.getSymbol(x, y-1) != ticTacBoard.getSymbol(x, y)) {
          isCurrColSymbolEqual = false;
          break;
        }
      }
      if (isCurrColSymbolEqual && ticTacBoard.getSymbol(x, 0) != XOSymbol.NOT_ASSIGNED) {
        return ticTacBoard.getSymbol(x, 0);
      }
    }
    return null;
  }

  /**
   * Returns symbol which is equal in a row;
   * return null is no row has all equal symbol
   *
   * @param ticTacBoard
   * @return
   */
  private XOSymbol checkHorizontal(TicTacBoard ticTacBoard) {
    for (int y = 0; y < 3; y++) {
      boolean isCurrRowSymbolEqual = true;
      for (int x = 1; x < 3; x++) {
        if (ticTacBoard.getSymbol(x-1, y) != ticTacBoard.getSymbol(x, y)) {
          isCurrRowSymbolEqual = false;
          break;
        }
      }
      if (isCurrRowSymbolEqual && ticTacBoard.getSymbol(0, y) != XOSymbol.NOT_ASSIGNED) return ticTacBoard.getSymbol(0, y);
    }

    return null;
  }

  private boolean areAllPositionFilled(TicTacBoard ticTacBoard) {
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        if (ticTacBoard.getSymbol(x, y) == XOSymbol.NOT_ASSIGNED) return false;
      }
    }
    return true;
  }
}
