package interfaces;

import cli.CommandMap;
import robot.Robot;

public interface RobotState {

  void doCommand(CommandMap commandMap, String commandKey);
}
