package commands;

import interfaces.Command;

public class HelpCommand implements Command {

  @Override
  public boolean execute() {
    String helpMessage = """
        PLACE - Choose a spot to place the robot onto the 5x5 Grid.
        MOVE - Robot moves in the direction it is currently facing.
        LEFT - Robot turns left.
        RIGHT - Robot turns right.
        REPORT - Report back the current position and direction it's facing.
        EXIT - Quits the simulation.""";

    System.out.println(helpMessage);
    return true;
  }
}
