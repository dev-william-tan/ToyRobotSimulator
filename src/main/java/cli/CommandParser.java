package cli;

import grid.Grid;
import interfaces.Command;
import interfaces.RobotState;
import robot.Robot;

public class CommandParser {
  private RobotState currentState;

  public CommandParser(RobotState initialState ) {
    this.currentState = initialState;
  }

  public void executeCommand(Command command, Robot robot, Grid grid) {
    //currentState.doCommand(command, robot, grid);
  };

  public void setState(RobotState newState) {
    currentState = newState;
  }
}
