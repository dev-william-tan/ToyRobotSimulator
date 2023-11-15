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

  private Direction left;
  private Direction right;

  static {
    NORTH.left = WEST;
    WEST.left = SOUTH;
    SOUTH.left = EAST;
    EAST.left = NORTH;
  }

  static {
    NORTH.right = EAST;
    EAST.right = SOUTH;
    SOUTH.right = WEST;
    WEST.right = NORTH;
  }

  public Direction turnLeft() {
    return left;
  }

  public Direction turnRight() {
    return right;
  }

  public Position moveForward(Position position) {
    int newX = position.x() + associatedPosition.x();
    int newY = position.y() + associatedPosition.y();
    return new Position(newX, newY);
  }

}
