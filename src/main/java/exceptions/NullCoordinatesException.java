package exceptions;

public class NullCoordinatesException extends IllegalArgumentException{
  public NullCoordinatesException() {
    super("No X or Y coordinates provided");
  }

}
