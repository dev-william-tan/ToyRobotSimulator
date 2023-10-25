package actions;

public enum Direction {
  NORTH(new Position(0,1)),
  EAST(new Position(1,0)),
  WEST(new Position(-1,0)),
  SOUTH(new Position(0,-1));

  private final Position associatedPosition;

  Direction(Position position){
    this.associatedPosition = position;
  }

  public Direction turnLeft() {
    return switch (this) {
      case NORTH -> WEST;
      case EAST -> NORTH;
      case WEST -> SOUTH;
      case SOUTH -> EAST;
    };
  }

  public Direction turnRight() {
    return switch (this) {
      case NORTH -> EAST;
      case EAST -> SOUTH;
      case WEST -> NORTH;
      case SOUTH -> WEST;
    };
  }

  public Position moveForward(Position position) {
    int newX = position.getX() + associatedPosition.getX();
    int newY = position.getY() + associatedPosition.getY();
    return new Position(newX, newY);
  }

}
