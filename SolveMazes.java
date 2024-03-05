import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SolveMazes {

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
            // if(getToFinish) {
            // maze.setVisited(currentLocation.getRow(), currentLocation.getCol());
            // }
            return getToFinish;
        }
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        MazeViewer viewer = new MazeViewer(maze);
        maze.initMaze("maze1");

        // Scanner file = null;
        // if (args.length >0) {
        // String filename = "maze1";
        // try {
        // file = new Scanner(new File(filename));
        // } catch (FileNotFoundException e) {
        // System.err.println("Cannot locate file.");
        // System.exit(-1);
        // }
        // } else {
        // file = new Scanner(System.in);
        // }

        // // reading from input
        // while (file.hasNextLine()) {
        // String line = file.nextLine();
        // System.out.println(line);
        // }
        // file.close();

        if (startMaze(maze)) {
            System.out.println("Finished!");
        } else {
            System.out.println("Cannot Finish");
        }
    }
}
