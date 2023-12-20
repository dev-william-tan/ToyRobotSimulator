package commands;

import actions.Direction;
import actions.PlaceInput;
import actions.Position;
import interfaces.Command;
import java.util.Scanner;
import robot.Robot;
import states.MovementState;

public class PlaceCommand implements Command {

  private final Robot robot;

  public PlaceCommand(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void execute() {
    placeRobot();
  }

  private void placeRobot() {
    PlaceInput userInput = getUserInput();
    robot.setPosition(userInput.getPosition());
    robot.setDirection(userInput.getDirection());
    System.out.println("Placing the robot on: " + robot.getPositionAndDirection() );
    robot.setState(new MovementState());
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
