package cli;

import commands.HelpCommand;
import actions.Position;
import commands.MoveCommand;
import commands.PlaceCommand;
import commands.ReportCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;
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
    MoveCommand moveCommand = new MoveCommand(robot, grid);
    moveCommand.execute();
  }

  public void executePlace(Position startPosition, Direction startDirection) {
    //If either of the position/direction is null
    //it will be defaulted to (0, 0) and North facing
    startPosition = (startPosition == null) ? new Position(0, 0) : startPosition;
    startDirection = (startDirection == null) ? Direction.NORTH : startDirection;
    PlaceCommand placeCommand = new PlaceCommand(robot, startPosition, startDirection);
    placeCommand.execute();
    System.out.println("The robot has been placed on the grid and it's ready to move!");
  }

  public void executeLeft() {
    TurnLeftCommand leftCommand = new TurnLeftCommand(robot);
    leftCommand.execute();
  }

  public void executeRight() {
    TurnRightCommand rightCommand = new TurnRightCommand(robot);
    rightCommand.execute();
  }

  public void executeReport() {
    ReportCommand reportCommand = new ReportCommand(robot);
    reportCommand.execute();
 }

  public void executeHelp() {
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.execute();
  }
}
