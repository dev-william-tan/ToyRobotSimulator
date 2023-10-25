package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import grid.Grid;
import org.junit.jupiter.api.Test;
import robot.Robot;

public class GridTest {

  private final Robot robot = new Robot();
  private final Grid grid = new Grid(robot);

  @Test
  void testPlaceRobotWith_ValidPosition() {

    Position startPosition = new Position(0,0);
    Direction startDir = Direction.NORTH;

    grid.placeRobot(startPosition, startDir);

    assertEquals(robot.getPosition(), startPosition);
    assertEquals(robot.getDirection(), startDir);
  }

  @Test
  void testPlaceRobotWith_OutOfBoundsXPosition() {

    Throwable exception = assertThrows(IllegalArgumentException.class, ()
        -> grid.placeRobot(new Position(-1, 0), Direction.NORTH));

    assertEquals("Starting position is out of grid bounds", exception.getMessage());
  }

  @Test
  void testPlaceRobotWith_OutOfBoundsYPosition() {

    Throwable exception = assertThrows(IllegalArgumentException.class, ()
        -> grid.placeRobot(new Position(0, 500), Direction.NORTH));

    assertEquals("Starting position is out of grid bounds", exception.getMessage());
  }

  @Test
  void testPlaceRobotWith_NullPosition() {

    Throwable exception = assertThrows(IllegalArgumentException.class, ()
        -> grid.placeRobot(null, Direction.NORTH));

    assertEquals("No X or Y coordinates provided", exception.getMessage());
  }

  @Test
  void testPlaceRobotWith_NullDirection() {

    Throwable exception = assertThrows(IllegalArgumentException.class, ()
        -> grid.placeRobot(new Position(0,0), null));

    assertEquals("No direction provided", exception.getMessage());
  }

}
