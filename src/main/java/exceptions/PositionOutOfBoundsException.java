package exceptions;

public class PositionOutOfBoundsException extends IllegalArgumentException{
  public PositionOutOfBoundsException() {
    super("Starting position is out of grid bounds");
  }

}
