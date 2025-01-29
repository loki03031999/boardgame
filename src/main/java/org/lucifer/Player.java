package org.lucifer;

public class Player {
  private String name;
  private PlayerType type;
  private XOSymbol symbol;

  public Player(String name, XOSymbol symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public Player(String name, PlayerType type, XOSymbol symbol) {
    this.name = name;
    this.type = type;
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public XOSymbol getSymbol() {
    return symbol;
  }

  public void setSymbol(XOSymbol symbol) {
    this.symbol = symbol;
  }

  public PlayerType getType() {
    return type;
  }

  public void setType(PlayerType type) {
    this.type = type;
  }
}
