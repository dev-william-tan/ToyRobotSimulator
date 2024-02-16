package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import robot.Robot;

public class CommandTests {

  private Robot robot;
  private Grid grid;

  @BeforeEach
  public void setUp() {
    robot = new Robot();
    grid = new Grid(robot);

  }

  @Nested
  @DisplayName("Positive Test for Commands")
  class PositiveTests {

  }

}
