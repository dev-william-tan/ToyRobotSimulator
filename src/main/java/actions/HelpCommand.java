package actions;

public class HelpCommand {

  public String help() {
      return "PLACE - Choose a spot to place the robot onto the 5x5 Grid." + "\n"
          + "MOVE - Robot moves in the direction it is currently facing." + "\n"
          + "LEFT - Robot turns left." + "\n"
          + "RIGHT - Robot turns right." + "\n"
          + "REPORT - Report back the current position and direction it's facing." + "\n"
          + "EXIT - Quits the simulation.";
  }
}
