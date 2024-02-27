package commands;

import grid.Grid;
import interfaces.Command;
import actions.Position;
import robot.Robot;

public class MoveCommand implements Command {
  private static final String OutOfBounds = "The robot will be out of bounds, move command overridden";
  private static final String RobotMove = "The robot has moved! New position: ";

  private final Robot robot;
  private final Grid grid;

  public MoveCommand(Robot robot, Grid grid) {
    this.robot = robot;
    this.grid = grid;
  }

  @Override
  public boolean execute() {
    Position newPosition = robot.getDirection().moveForward(robot.getPosition());

    if (grid.isValidPosition(newPosition)){
      updatePosition(newPosition);
      return true;
    } else {
      System.out.println(OutOfBounds);
      return false;
    }
  }

  private String updatePosition(Position position) {
    robot.setPosition(position);
    return RobotMove + robot.getPositionAndDirection();
  }

}
