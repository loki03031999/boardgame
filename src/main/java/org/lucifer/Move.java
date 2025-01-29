package org.lucifer;

public class Move {
  int xPosition, yPosition;
  public Move(int xPosition, int yPosition) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  public int getXPosition() {
    return xPosition;
  }

  public void setxPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  public int getYPosition() {
    return yPosition;
  }

  public void setyPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  @Override
  public String toString() {
    return "{" +
            "xPosition = " + xPosition +
            ", yPosition = " + yPosition +
            '}';
  }
}
