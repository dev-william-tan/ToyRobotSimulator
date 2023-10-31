package exceptions;

public class RobotOutOfBoundsException extends RuntimeException{
  public RobotOutOfBoundsException() {
    super("The robot is gonna fall off the table! Overriding command");
  }
}
