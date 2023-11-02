package grid;

import actions.Position;

import exceptions.NoDirectionException;
import exceptions.NullCoordinatesException;
import exceptions.PositionOutOfBoundsException;
import robot.Robot;
import actions.Direction;

public class Grid {

  private final Robot robot;

  public Grid(Robot robot) {
    this.robot = robot;
  }

  public boolean isValidPosition(Position position) {
    int GRID_WIDTH = 5;
    int GRID_HEIGHT = 5;
    return position.getX() >= 0 && position.getX() < GRID_WIDTH
        && position.getY() >= 0 && position.getY() < GRID_HEIGHT;
  }

  public void placeRobot(Position position, Direction direction) {
    if (position == null) throw new NullCoordinatesException();

    if (!isValidPosition(position)) throw new PositionOutOfBoundsException();

    if (direction == null) throw new NoDirectionException();

    robot.setPosition(position);
    robot.setDirection(direction);
  }

}
