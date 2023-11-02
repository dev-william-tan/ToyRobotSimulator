package robot;

import actions.Position;
import actions.Direction;

public class Robot {

  private Position position;
  private Direction direction;

  public Robot() {}

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public Position getPosition(){
    return position;
  }

  public String getPositionAndDirection() {
    return position.getX() + "," + position.getY() + "," + direction.name();
  }

}
