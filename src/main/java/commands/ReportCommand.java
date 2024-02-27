package commands;

import interfaces.Command;
import robot.Robot;

public record ReportCommand(Robot robot) implements Command {

  //add error validations
  @Override
  public boolean execute() {
    String currentPositionAndDirection = robot.getPositionAndDirection();
    System.out.println("Robot's current position and direction: " + currentPositionAndDirection);
    return true;
  }
}
