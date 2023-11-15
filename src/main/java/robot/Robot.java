package robot;

import actions.Position;
import actions.Direction;
import interfaces.RobotState;
import states.StartState;

public class Robot {

  private Position position;
  private Direction direction;
  private RobotState state;

  public Robot() {
    state = new StartState();
  }

  public RobotState getState() {
    return state;
  }

  public void setState(RobotState state) {
    this.state = state;
  }

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
    return position.x() + "," + position.y() + "," + direction.name();
  }

  //Validation for robot's null*
}
