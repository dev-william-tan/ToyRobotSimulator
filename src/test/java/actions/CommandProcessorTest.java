package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cli.CommandProcessor;
import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
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

  @Test
  public void textMove_ValidMove() {
    robot.setPosition(new Position(0,0));
    robot.setDirection(Direction.EAST);

    commandProcessor.executeMove();

    assertEquals("1,0,EAST", robot.getPositionAndDirection());
  }
}
