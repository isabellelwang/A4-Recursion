class SolveMaze {

  public void mazeStart(Maze maze) {
    MazeLocation currentLocation = maze.getStart(); 
    MazeContents path = maze.getContents(currentLocation.getRow(), currentLocation.getCol()); 
    MazeLocation finishedLocation = maze.getFinish(); 

    if(currentLocation.equals(finishedLocation)) {
      maze.setPath(currentLocation.getRow(), currentLocation.getCol()); 
      System.out.println("Finished");
    } else {


    }
    
    }
  }

  public boolean recursiveSolver(Maze m, MazeLocation currentLocation, MazeLocation neighbor, MazeDirection dir) {
    if(!(m.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.WALL) && m.getContents(currentLocation.getRow(), currentLocation.getCol()).equals(MazeContents.VISITED)))  {
      return true; 
    }
    else if () {

    return false
    }
  }

  public static void main(String[] args) {
    Maze maze = new Maze();
    MazeViewer viewer = new MazeViewer(maze);
    maze.initDemoMaze();

  }
}
