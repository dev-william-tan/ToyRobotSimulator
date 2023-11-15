package commands;

import actions.Direction;
import actions.Position;
import interfaces.Command;
import robot.Robot;

public class PlaceCommand implements Command {

  private final Robot robot;
  private final Position position;
  private final Direction direction;

  public PlaceCommand(Robot robot, Position position, Direction direction) {
    this.robot = robot;
    this.position = position;
    this.direction = direction;
  }

  @Override
  public void execute() {
    placeRobot(position, direction);
  }

  private void placeRobot(Position position, Direction direction) {
    robot.setPosition(position);
    robot.setDirection(direction);
  }
}
