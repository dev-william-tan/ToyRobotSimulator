package commands;

import interfaces.Command;
import robot.Robot;

public record ReportCommand(Robot robot) implements Command {

  @Override
  public void execute() {
    String currentPositionAndDirection = robot.getPositionAndDirection();
    System.out.println("Robot's current position and direction: " + currentPositionAndDirection);
  }
}
