package commands;

import actions.Direction;
import actions.PlaceInput;
import actions.Position;
import grid.Grid;
import interfaces.Command;
import java.util.Scanner;
import robot.Robot;
import states.MovementState;

public class PlaceCommand implements Command {

  private final Robot robot;
  private final Grid grid;

  public PlaceCommand(Robot robot, Grid grid) {
    this.robot = robot;
    this.grid = grid;
  }

  @Override
  public boolean execute() {
    PlaceInput userInput = getUserInput();
    return place(userInput.getPosition(), userInput.getDirection());
  }

  public boolean place(Position position, Direction direction) {
    if (grid.isValidPosition(position)) {
      robot.place(position.x(), position.y(), direction.name());
      System.out.println("Placing the robot on: " + robot.getPositionAndDirection());
      robot.setState(new MovementState());
      return true;
    } else {
      System.out.println("Invalid Position, please enter valid coordinates");
      return false;
    }
  }

  //Get User input
  private PlaceInput getUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter X coordinate: ");
    int x = scanner.nextInt();
    System.out.print("Enter Y coordinate: ");
    int y = scanner.nextInt();
    Position position = new Position(x, y);

    // Get direction input
    System.out.print("Enter direction (NORTH, SOUTH, EAST, WEST): ");
    String directionString = scanner.next();
    Direction direction = Direction.valueOf(directionString.toUpperCase());

    return new PlaceInput(position, direction);
  }
}
