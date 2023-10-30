package cli;

import actions.Position;
import grid.Grid;
import robot.Robot;
import actions.Direction;

public class CommandProcessor {

  private final Robot robot;
  private final Grid grid;

  public CommandProcessor(Robot robot, Grid grid) {
    this.robot = robot;
    this.grid = grid;
  }

  public void executeMove() {
    //Move it forward towards the facing direction
    Position newPosition = robot.getDirection().moveForward(robot.getPosition());
    if (!grid.isValidPosition(newPosition)) throw new IllegalArgumentException("The robot is gonna fall off the table! Overriding command");
    robot.setPosition(newPosition);
    System.out.println("The robot has moved! New position: " + robot.getPositionAndDirection());
  }

  public void executePlace(Position startPosition, Direction startDirection) {
    //If either of the position/direction is null
    //it will be defaulted to (0, 0) and North facing
    startPosition = (startPosition == null) ? new Position(0, 0) : startPosition;
    startDirection = (startDirection == null) ? Direction.NORTH : startDirection;

    grid.placeRobot(startPosition, startDirection);
    System.out.println("The robot has been placed on the grid and it's ready to move!");
  }

  public void executeLeft() {
    Direction newDirection = robot.getDirection().turnLeft();
    robot.setDirection(newDirection);
    System.out.println("The Robot has turned! It's now facing: " + newDirection);
  }

  public void executeRight() {
    Direction newDirection = robot.getDirection().turnRight();
    robot.setDirection(newDirection);
    System.out.println("The Robot has turned! It's now facing: " + newDirection);
  }

  public void executeReport() {
    String currentPositionAndDirection = robot.getPositionAndDirection();
    System.out.println("Robot's current positon and direction: " + currentPositionAndDirection);
  }
}
