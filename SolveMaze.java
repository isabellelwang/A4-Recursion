import java.io.*;
import java.util.Scanner;

class SolveMaze {

  /**
   * Starts maze and calls on recursive method
   * 
   * @param maze Maze to be solved
   * @return boolean true or false whether maze is finished
   */
  public static boolean startMaze(Maze maze) {
    MazeLocation startLocation = maze.getStart();
    return recursiveSolver(maze, startLocation);
  }

  /**
   * Recursively searches squares to the finish line
   * 
   * @param maze            maze to find finish line
   * @param currentLocation current location the robot is at
   * @return boolean whether robot reaches finish
   */
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

      if (!getToFinish) {
        maze.setDeadEnd(currentLocation.getRow(), currentLocation.getCol());
      }

      return getToFinish;
    }
  }

  /** Class containing a file reading demo */

  public static void main(String[] args) {
    Maze maze = new Maze();

    // Scanner
    Scanner in = new Scanner(System.in);
    System.out.println("Please type: maze1 or maze2");
    String mazeInput = in.nextLine();

    //continues to ask for input if input is not maze1 or maze2
    while (!(mazeInput.equals("maze1") || mazeInput.equals("maze2"))) {
      System.out.print("Invalid Input. Press enter to continue");
      in.nextLine();
      System.out.println("Please type: maze1 or maze2");
      mazeInput = in.nextLine();
    }

    MazeViewer viewer = new MazeViewer(maze);
    maze.initMaze(mazeInput);

    // command line prompt
    if (args.length == 0) {
      maze.initMaze("maze1");
    } else {
      for (String s : args) {
        maze.initMaze(s);
      }
    }

    // Starts the maze
    if (startMaze(maze)) {
      System.out.println("Finished!");
    } else {
      System.out.println("Cannot Finish");
    }
  }
}
