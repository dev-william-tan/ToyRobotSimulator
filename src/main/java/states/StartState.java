package states;

import cli.CommandMap;
import interfaces.RobotState;

public class StartState implements RobotState {

  @Override
  public void doCommand(CommandMap commandMap, String commandKey) {
    if (commandKey.equalsIgnoreCase("PLACE")) {
      commandMap.getCommand(commandKey).execute();
    } else {
      System.out.println("Invalid command in Start state");
    }
  }
}
