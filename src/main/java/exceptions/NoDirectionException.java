package exceptions;

public class NoDirectionException extends IllegalArgumentException{

  public NoDirectionException() {
    super("No direction provided");
  }
}
