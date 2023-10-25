package cli;

import actions.Direction;
import actions.Position;
import grid.Grid;
import java.util.Scanner;
import robot.Robot;

public class CommandLineInterface {

  Scanner scanner = new Scanner(System.in);
  Robot robot = new Robot();
  Grid grid = new Grid(robot);
  CommandProcessor command = new CommandProcessor(robot, grid);

  public void run() {
    System.out.println("Welcome to the Toy Robot Simulator!");
    System.out.println("To get started, first PLACE the robot on the grid!");
    System.out.println("To move the robot around and turning,use the commands.");

    while (true) {
      System.out.println("Enter a command (PLACE, MOVE, LEFT, RIGHT, REPORT, or EXIT):");
      String input = scanner.nextLine().trim().toUpperCase();

      if (input.equals("EXIT")) {
        System.out.println("Exiting the robot simulator.");
        break;
      }

      try {
        switch (input) {
          case "PLACE" -> {
            Position startPosition = getInputPosition(scanner);
            Direction startDirection = getInputDirection(scanner);
            command.executePlace(startPosition, startDirection);
          }
          case "MOVE" -> command.executeMove();
          case "LEFT" -> command.executeLeft();
          case "RIGHT" -> command.executeRight();
          case "REPORT" -> command.executeReport();
          default -> System.out.println("Invalid command. Please try again.");
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private Position getInputPosition(Scanner scanner) {
    System.out.print("Enter X coordinate: ");
    int x = scanner.nextInt();
    System.out.print("Enter Y coordinate: ");
    int y = scanner.nextInt();
    return new Position(x,y);
  }

  private Direction getInputDirection(Scanner scanner) {
    System.out.print("Enter direction (NORTH, EAST, SOUTH, WEST): ");
    scanner.nextLine();
    String directionStr = scanner.nextLine().trim().toUpperCase();
    return Direction.valueOf(directionStr);
  }
}
