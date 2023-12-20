package grid;

import actions.Position;

import robot.Robot;

public class Grid {

  private final Robot robot;

  public Grid(Robot robot) {
    this.robot = robot;
  }

  public boolean isValidPosition(Position position) {
    int GRID_WIDTH = 5;
    int GRID_HEIGHT = 5;
    return position.x() >= 0 && position.x() < GRID_WIDTH
        && position.y() >= 0 && position.y() < GRID_HEIGHT;
  }
}
