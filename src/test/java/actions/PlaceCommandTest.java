package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cli.CommandMap;
import commands.PlaceCommand;
import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robot.Robot;

public class PlaceCommandTest {

  private Robot robot;
  private Grid grid;

  @BeforeEach
  public void setUp() {
    robot = new Robot();
    grid = new Grid(robot);
  }

  @Test
  void testValidPlacePosition() {
    PlaceCommand placeCommand = new PlaceCommand(robot, grid);

    Position validPosition = new Position(1, 2);
    Direction validDirection = Direction.NORTH;
    boolean result = placeCommand.place(validPosition, validDirection);

    assertTrue(result);
    assertEquals("1,2,NORTH", robot.getPositionAndDirection());
  }

  @Test
  void testInvalidPlacePosition() {
    PlaceCommand placeCommand = new PlaceCommand(robot, grid);

    Position invalidPosition = new Position(6, 2);
    Direction invalidDirection = Direction.NORTH;
    boolean result = placeCommand.place(invalidPosition, invalidDirection);

    assertFalse(result);
    assertNull(robot.getPosition());
  }

}
