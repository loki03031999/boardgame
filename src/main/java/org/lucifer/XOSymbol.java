package org.lucifer;

public enum XOSymbol {
  X('X'), O('O'), NOT_ASSIGNED('-');
  XOSymbol(char symbol) {
    this.symbol = symbol;
  }
  private final char symbol;

  public String toString() {
    return symbol + "";
  }

  public static XOSymbol createOppositeSymbol(XOSymbol xoSymbol) {
    if (xoSymbol.equals(X)) return O;
    else if (xoSymbol.equals(O)) return X;
    throw new IllegalArgumentException("no opposite symbol for NOT_ASSIGNED symbol");
  }

  public static XOSymbol createXOSymbol(String symbol) {
    if ("X".equals(symbol)) {
      return X;
    }
    else if ("O".equals(symbol)) {
      return O;
    }
    throw new IllegalArgumentException(symbol + " - symbol provided is invalid");
  }
}
