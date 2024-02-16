package states;

import cli.CommandMap;
import interfaces.RobotState;

public class MovementState implements RobotState {

  @Override
  public void doCommand(CommandMap commandMap, String commandKey) {
    if (commandKey.equalsIgnoreCase("PLACE")){
      System.out.println("Place command not allowed in movement state");
    } else {
      commandMap.getCommand(commandKey).execute();
    }
  }
}
