Toy Robot Simulator

Description

The application is a simulation of a toy robot moving on a square tabletop,of dimensions 5 units x 5 units.

There are no other obstructions on the table surface.

The robot is free to roam around the surface of the table, but must beprevented from falling to destruction. Any movement that would result in therobot falling from the table must be prevented, however further validmovement commands must still be allowed.Create an application that can read in commands of the following form:PLACE X,Y,FMOVELEFTRIGHTREPORT

PLACE will put the toy robot on the table in position X,Y and facing NORTH,SOUTH, EAST or WEST.

The origin (0,0) can be considered to be the SOUTH WEST most corner.

The first valid command to the robot is a PLACE command, after that, anysequence of commands may be issued, in any order, including another PLACEcommand. The application should discard all commands in the sequence untila valid PLACE command has been executed.

MOVE will move the toy robot one unit forward in the direction it iscurrently facing.

LEFT and RIGHT will rotate the robot 90 degrees in the specified directionwithout changing the position of the robot.

REPORT will announce the X,Y and F of the robot. This can be in any form,but standard output is sufficient.

A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHTand REPORT commands.

Input can be from a file, or from standard input, as the developer chooses.

Provide test data to exercise the application.Constraints



The toy robot must not fall off the table during movement. This alsoincludes the initial placement of the toy robot.

Any move that would cause the robot to fall must be ignored. 


### To add: 

1. Further SRP refactoring
2. Clean up/refactor instructions
3. Error checks, make sure robot is placed first