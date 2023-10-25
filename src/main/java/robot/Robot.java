package robot;

import actions.Position;
import actions.Direction;

public class Robot {

  private Position position;
  private Direction direction;

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

  public void currentPosition() {
    System.out.print("Robot is on coordinates: (" + position.getX() + ", " + position.getY() + ")" + "\n"
        + "facing: " + getDirection() + "\n");
  }

}
