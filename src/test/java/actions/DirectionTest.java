package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class DirectionTest {

  @ParameterizedTest
  @EnumSource(Direction.class)
  void testMoveForwardInEveryDirection(Direction direction) {
    final Position startPosition = new Position(0,0);
    Position actual = direction.moveForward(startPosition);

    Position expectedPosition;
    switch (direction) {
      case NORTH ->
          expectedPosition = new Position(0, 1);
      case EAST ->
          expectedPosition = new Position(1, 0);
      case WEST ->
          expectedPosition = new Position(-1, 0);
      case SOUTH ->
          expectedPosition = new Position(0, -1);
      default ->
          expectedPosition = new Position(0,0);
    }
    assertEquals(expectedPosition, actual);
  }

  @ParameterizedTest
  @EnumSource(Direction.class)
  void testTurnLeftInEveryDirection(Direction direction) {
    Direction actual = direction.turnLeft();
    Direction expected = null;

    switch (direction) {
      case NORTH -> expected = Direction.WEST;
      case WEST -> expected = Direction.SOUTH;
      case SOUTH -> expected = Direction.EAST;
      case EAST -> expected = Direction.NORTH;
  }
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @EnumSource(Direction.class)
  void testTurnRightInEveryDirection(Direction direction) {
    Direction actual = direction.turnRight();
    Direction expected = null;

    switch (direction) {
      case NORTH -> expected = Direction.EAST;
      case EAST -> expected = Direction.SOUTH;
      case SOUTH -> expected = Direction.WEST;
      case WEST -> expected = Direction.NORTH;
    }
    assertEquals(expected, actual);
  }

}
