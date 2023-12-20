package cli;

import actions.Direction;
import actions.PlaceInput;
import actions.Position;
import grid.Grid;
import interfaces.Command;
import interfaces.RobotState;
import java.util.Map;
import java.util.Scanner;
import robot.Robot;
import states.StartState;

public class CommandLineInterface {

  Scanner scanner = new Scanner(System.in);
  Robot robot = new Robot();
  Grid grid = new Grid(robot);

  public void run() {
    System.out.println("Welcome to the Toy Robot Simulator!");
    System.out.println("To get started, first PLACE the robot on the grid!");
    System.out.println("To move the robot around and turning,use the commands.");

    RobotState state = robot.getState();
    while (true) {
      System.out.println("Enter a command (PLACE, MOVE, LEFT, RIGHT, REPORT, HELP, or EXIT):");
      String input = scanner.nextLine().trim().toUpperCase();

      if (input.equals("EXIT")) {
        System.out.println("Exiting the robot simulator.");
        break;
      }
      System.out.println("Current robot state: " + robot.getState().toString());

      try {
//start state - get input to place command
          state.doCommand(new CommandMap(robot, grid), input);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
