package actions;

import java.util.Scanner;

public class PlaceInput {

  private final Position position;
  private final Direction direction;

  public PlaceInput(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Position getPosition() {
    return position;
  }

  public Direction getDirection() {
    return direction;
  }
}
