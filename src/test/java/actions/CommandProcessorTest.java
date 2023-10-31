package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cli.CommandProcessor;
import exceptions.NullCoordinatesException;
import exceptions.PositionOutOfBoundsException;
import exceptions.RobotOutOfBoundsException;
import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import robot.Robot;

public class CommandProcessorTest {

  private CommandProcessor commandProcessor;
  private Robot robot;
  private Grid grid;

  @BeforeEach
  public void setUp() {
    robot = new Robot();
    grid = new Grid(robot);
    commandProcessor = new CommandProcessor(robot,grid);
  }

  @Nested
  @DisplayName("Positive Test for Commands")
  class PositiveTests {
    @Test
    public void testExecuteMove_ValidMove() {
      robot.setPosition(new Position(0,0));
      robot.setDirection(Direction.EAST);

      commandProcessor.executeMove();

      assertEquals("1,0,EAST", robot.getPositionAndDirection());
    }

    @Test
    public void testExecuteLeft_ValidTurn() {
      robot.setPosition(new Position(0,0));
      robot.setDirection(Direction.NORTH);

      Direction expected = Direction.WEST;
      commandProcessor.executeLeft();

      assertEquals(expected, robot.getDirection());
    }

    @Test
    public void testExecuteRight_ValidTurn() {
      robot.setPosition(new Position(0,0));
      robot.setDirection(Direction.NORTH);

      Direction expected = Direction.EAST;
      commandProcessor.executeRight();

      assertEquals(expected, robot.getDirection());
    }

    @Test
    public void testExecutePlace_ValidPlace() {
      Position startPosition = new Position(3,3);
      Direction startDirection = Direction.SOUTH;

      commandProcessor.executePlace(startPosition, startDirection);
      String expected = "3,3,SOUTH";

      assertEquals(expected, robot.getPositionAndDirection());
    }

    @Test
    public void testExecuteReport() {
      Position startPosition = new Position(0,0);
      Direction startDirection = Direction.NORTH;

      commandProcessor.executePlace(startPosition, startDirection);
      String actual = commandProcessor.executeReport();

      String expected = "Robot's current position and direction: " + robot.getPositionAndDirection();
      assertEquals(expected,  actual);
    }
  }

  @Nested
  @DisplayName("Negative Test for Commands")
  class NegativeTests {
    @Test
    public void testExecuteMove_InvalidMove() {
      robot.setPosition(new Position(0,0));
      robot.setDirection(Direction.WEST);

      assertThrows(RobotOutOfBoundsException.class, () -> commandProcessor.executeMove());
    }

    @Test
    public void testExecutePlace_InvalidStartingPlace() {
      Position startPosition = new Position(6,10);
      Direction startDirection = Direction.SOUTH;

      assertThrows(PositionOutOfBoundsException.class, () -> commandProcessor.executePlace(startPosition, startDirection));
    }

    @Test
    public void testExecutePlace_WhenNullPositionProvided_SetToDefault() {
      Direction startDirection = Direction.SOUTH;
      String expected = "0,0,SOUTH";
      commandProcessor.executePlace(null, startDirection);

      assertEquals(expected, robot.getPositionAndDirection());
    }

    @Test
    public void testExecutePlace_WhenNullDirectionProvided_SetToDefaultNorth() {
      String expected = "0,0,NORTH";
      commandProcessor.executePlace(new Position(0,0), null);

      assertEquals(expected, robot.getPositionAndDirection());
    }
  }

}
