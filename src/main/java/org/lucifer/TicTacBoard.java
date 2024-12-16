package org.lucifer;

public class TicTacBoard {
  public XOSymbol[][] board;

  public TicTacBoard() {
    initBoard();
  }

  private void initBoard() {
    board = new XOSymbol[3][3];
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        board[y][x] = XOSymbol.NOT_ASSIGNED;
      }
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        sb.append(board[y][x]);
        sb.append(' ');
      }
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }

  public XOSymbol getSymbol(int x, int y) {
    return board[y][x];
  }

  private void setSymbol(int x, int y, XOSymbol o) {
    board[y][x] = o;
  }

  public void makeMove(Move move, XOSymbol symbol) {
    if (move.getXPosition() > 2 || move.getYPosition() > 2) {
      throw new IllegalArgumentException("invalid move provided");
    }
    setSymbol(move.getXPosition(), move.getYPosition(), symbol);
  }

  public int countMoves() {
    int count = 0;
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        if (getSymbol(x, y) == XOSymbol.NOT_ASSIGNED) count++;
      }
    }
    return count;
  }
}
