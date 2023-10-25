package grid;

import actions.Position;

import robot.Robot;
import actions.Direction;

public class Grid {

  private final int GRID_HEIGHT = 5;
  private final int GRID_WIDTH = 5;

  private final Robot robot;

  public Grid(Robot robot) {
    this.robot = robot;
  }

  public boolean isValidPosition(Position position) {
    return position.getX() >= 0 && position.getX() < GRID_WIDTH
        && position.getY() >= 0 && position.getY() < GRID_HEIGHT;
  }

  public void placeRobot(Position position, Direction direction) {
    if (position == null) throw new IllegalArgumentException("No X or Y coordinates provided");

    if (!isValidPosition(position)) throw new IllegalArgumentException("Starting position is out of grid bounds");

    if (direction == null) throw new IllegalArgumentException("No direction provided");

    robot.setPosition(position);
    robot.setDirection(direction);
  }

}
