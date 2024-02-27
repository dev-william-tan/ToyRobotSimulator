package commands;

import interfaces.Command;
import robot.Robot;

public record TurnLeftCommand(Robot robot) implements Command {

  //add error validations
  @Override
  public boolean execute() {
    robot.setDirection(robot.getDirection().turnLeft());
    System.out.println("The Robot has turned! It's now facing: " + robot.getDirection());

    return true;
  }
}
