package states;

import cli.CommandProcessor;
import interfaces.RobotState;
import robot.Robot;

public class StartState implements RobotState {

  private CommandProcessor commandProcessor;

  @Override
  public void ActiveCommands(Robot robot) {
    //Place robot command only introduction


  }
}
