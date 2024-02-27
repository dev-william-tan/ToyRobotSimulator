package actions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cli.CommandMap;
import commands.HelpCommand;
import commands.MoveCommand;
import commands.PlaceCommand;
import commands.ReportCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;
import grid.Grid;
import interfaces.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robot.Robot;

public class CommandMapTest {
  private Robot robot;
  private Grid grid;
  private CommandMap commandMap;

  @BeforeEach
  void setUp() {
    robot = new Robot();
    grid = new Grid(robot);
    commandMap = new CommandMap(robot, grid);
  }

  @Test
  void validateReturnsPlaceCommand() {
    Command placeCommand = commandMap.getCommand("PLACE");
    assertNotNull(placeCommand);
    assertTrue(placeCommand instanceof PlaceCommand);
  }

  @Test
  void validateReturnsMoveCommand() {
    Command moveCommand = commandMap.getCommand("MOVE");
    assertNotNull(moveCommand);
    assertTrue(moveCommand instanceof MoveCommand);
  }

  @Test
  void validateReturnsLeftCommand() {
    Command leftCommand = commandMap.getCommand("LEFT");
    assertNotNull(leftCommand);
    assertTrue(leftCommand instanceof TurnLeftCommand);
  }

  @Test
  void validateReturnsRightCommand() {
    Command rightCommand = commandMap.getCommand("RIGHT");
    assertNotNull(rightCommand);
    assertTrue(rightCommand instanceof TurnRightCommand);
  }

  @Test
  void validateReturnsReportCommand() {
    Command reportCommand = commandMap.getCommand("REPORT");
    assertNotNull(reportCommand);
    assertTrue(reportCommand instanceof ReportCommand);
  }

  @Test
  void validateReturnsHelpCommand() {
    Command helpCommand = commandMap.getCommand("HELP");
    assertNotNull(helpCommand);
    assertTrue(helpCommand instanceof HelpCommand);
  }

  @Test
  void invalidCommand() {
    Command errorCommand = commandMap.getCommand("OutOfRange");
    assertNull(errorCommand);
  }
 }
