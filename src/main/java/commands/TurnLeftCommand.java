package commands;

import interfaces.Command;
import robot.Robot;

public record TurnLeftCommand(Robot robot) implements Command {

  @Override
  public void execute() {
    robot.setDirection(robot.getDirection().turnLeft());
    System.out.println("The Robot has turned! It's now facing: " + robot.getDirection());
  }
}
