import java.io.*;
import java.util.Scanner;
class SolveMaze {

  public static boolean startMaze(Maze maze) {
    MazeLocation startLocation = maze.getStart();
    return recursiveSolver(maze, startLocation);
  }

  public static boolean recursiveSolver(Maze maze, MazeLocation currentLocation) {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
    }
    ;

    MazeContents currentContents = maze.getContents(currentLocation.getRow(), currentLocation.getCol());

    if (currentLocation.equals(maze.getFinish())) {
      maze.setPath(currentLocation.getRow(), currentLocation.getCol());
      // maze.setVisited(currentLocation.getRow(), currentLocation.getCol());
      return true;
    } else if (currentContents.equals(MazeContents.WALL) || currentContents.equals(MazeContents.VISITED)) {
      return false;
    } else {
      maze.setVisited(currentLocation.getRow(), currentLocation.getCol());
      boolean getToFinish = recursiveSolver(maze, currentLocation.neighbor(MazeDirection.NORTH))
          || recursiveSolver(maze, currentLocation.neighbor(MazeDirection.SOUTH))
          || recursiveSolver(maze, currentLocation.neighbor(MazeDirection.WEST))
          || recursiveSolver(maze, currentLocation.neighbor(MazeDirection.EAST));
     
      return getToFinish;
    }
  }

  /** Class containing a file reading demo */


  public static void main(String[] args) {
    Maze maze = new Maze();
    MazeViewer viewer = new MazeViewer(maze);
    maze.initMaze("maze1");

    if (startMaze(maze)) {
      System.out.println("Finished!");
    } else {
      System.out.println("Cannot Finish");
    }
  }
}
