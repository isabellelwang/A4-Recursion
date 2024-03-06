/* This class should implement the DisplayableMaze interface */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze implements DisplayableMaze {

  private int height; 
  private int width;
  private MazeContents[][] mazeGrid;
  private MazeLocation start;
  private MazeLocation finish;

  /**
   * The DemoMaze method will allow you to generate a simple maze
   * To test your code on as you develop it. Ultimately, you will want
   * to accept maze files as command line inputs or standard input.
   * * @author Tianah Gooden
   * * @version October 17th 2023
   */
  public void initDemoMaze() { // String fileName,
    this.height = 10;
    this.width = 8;
    this.mazeGrid = new MazeContents[height][width];
    this.start = new MazeLocation(1, 1);
    this.finish = new MazeLocation(8, 6);

    this.mazeGrid[0][0] = MazeContents.WALL;
    this.mazeGrid[0][1] = MazeContents.WALL;
    this.mazeGrid[0][2] = MazeContents.WALL;
    this.mazeGrid[0][3] = MazeContents.WALL;
    this.mazeGrid[0][4] = MazeContents.WALL;
    this.mazeGrid[0][5] = MazeContents.WALL;
    this.mazeGrid[0][6] = MazeContents.WALL;
    this.mazeGrid[0][7] = MazeContents.WALL;
    this.mazeGrid[1][0] = MazeContents.WALL;
    this.mazeGrid[1][1] = MazeContents.OPEN;
    this.mazeGrid[1][2] = MazeContents.OPEN;
    this.mazeGrid[1][3] = MazeContents.OPEN;
    this.mazeGrid[1][4] = MazeContents.OPEN;
    this.mazeGrid[1][5] = MazeContents.OPEN;
    this.mazeGrid[1][6] = MazeContents.WALL;
    this.mazeGrid[1][7] = MazeContents.WALL;
    this.mazeGrid[2][0] = MazeContents.WALL;
    this.mazeGrid[2][1] = MazeContents.WALL;
    this.mazeGrid[2][2] = MazeContents.OPEN;
    this.mazeGrid[2][3] = MazeContents.WALL;
    this.mazeGrid[2][4] = MazeContents.WALL;
    this.mazeGrid[2][5] = MazeContents.OPEN;
    this.mazeGrid[2][6] = MazeContents.WALL;
    this.mazeGrid[2][7] = MazeContents.WALL;
    this.mazeGrid[3][0] = MazeContents.WALL;
    this.mazeGrid[3][1] = MazeContents.OPEN;
    this.mazeGrid[3][2] = MazeContents.WALL;
    this.mazeGrid[3][3] = MazeContents.OPEN;
    this.mazeGrid[3][4] = MazeContents.OPEN;
    this.mazeGrid[3][5] = MazeContents.OPEN;
    this.mazeGrid[3][6] = MazeContents.WALL;
    this.mazeGrid[3][7] = MazeContents.WALL;
    this.mazeGrid[4][0] = MazeContents.WALL;
    this.mazeGrid[4][1] = MazeContents.OPEN;
    this.mazeGrid[4][2] = MazeContents.OPEN;
    this.mazeGrid[4][3] = MazeContents.OPEN;
    this.mazeGrid[4][4] = MazeContents.WALL;
    this.mazeGrid[4][5] = MazeContents.WALL;
    this.mazeGrid[4][6] = MazeContents.OPEN;
    this.mazeGrid[4][7] = MazeContents.WALL;
    this.mazeGrid[5][0] = MazeContents.WALL;
    this.mazeGrid[5][1] = MazeContents.OPEN;
    this.mazeGrid[5][2] = MazeContents.WALL;
    this.mazeGrid[5][3] = MazeContents.OPEN;
    this.mazeGrid[5][4] = MazeContents.OPEN;
    this.mazeGrid[5][5] = MazeContents.WALL;
    this.mazeGrid[5][6] = MazeContents.WALL;
    this.mazeGrid[5][7] = MazeContents.WALL;
    this.mazeGrid[6][0] = MazeContents.WALL;
    this.mazeGrid[6][1] = MazeContents.OPEN;
    this.mazeGrid[6][2] = MazeContents.WALL;
    this.mazeGrid[6][3] = MazeContents.WALL;
    this.mazeGrid[6][4] = MazeContents.OPEN;
    this.mazeGrid[6][5] = MazeContents.OPEN;
    this.mazeGrid[6][6] = MazeContents.OPEN;
    this.mazeGrid[6][7] = MazeContents.WALL;
    this.mazeGrid[7][0] = MazeContents.WALL;
    this.mazeGrid[7][1] = MazeContents.OPEN;
    this.mazeGrid[7][2] = MazeContents.WALL;
    this.mazeGrid[7][3] = MazeContents.OPEN;
    this.mazeGrid[7][4] = MazeContents.OPEN;
    this.mazeGrid[7][5] = MazeContents.WALL;
    this.mazeGrid[7][6] = MazeContents.OPEN;
    this.mazeGrid[7][7] = MazeContents.WALL;
    this.mazeGrid[8][0] = MazeContents.WALL;
    this.mazeGrid[8][1] = MazeContents.OPEN;
    this.mazeGrid[8][2] = MazeContents.OPEN;
    this.mazeGrid[8][3] = MazeContents.WALL;
    this.mazeGrid[8][4] = MazeContents.OPEN;
    this.mazeGrid[8][5] = MazeContents.WALL;
    this.mazeGrid[8][6] = MazeContents.OPEN;
    this.mazeGrid[8][7] = MazeContents.WALL;
    this.mazeGrid[9][0] = MazeContents.WALL;
    this.mazeGrid[9][1] = MazeContents.WALL;
    this.mazeGrid[9][2] = MazeContents.WALL;
    this.mazeGrid[9][3] = MazeContents.WALL;
    this.mazeGrid[9][4] = MazeContents.WALL;
    this.mazeGrid[9][5] = MazeContents.WALL;
    this.mazeGrid[9][6] = MazeContents.WALL;
    this.mazeGrid[9][7] = MazeContents.WALL;
  }

  /**
   * initializes maze in a 2D array with contents like open, wall, and visited.
   * @param fileName file of maze as input
   */
  public void initMaze(String fileName) {
    this.height = 21; // row
    this.width = 27; // column
    this.mazeGrid = new MazeContents[height][width];

    try {

      File file = new File(fileName);
      Scanner reader = new Scanner(file);

      int row = 0;

      while (reader.hasNextLine()) {
        // System.out.println("next line");

        String data = reader.nextLine();
        // System.out.println(data);

        for (int col = 0; col < data.length(); col++) {
          // System.out.println(row + " " + col);
          if (String.valueOf(data.charAt(col)).equals("#")) {
            this.mazeGrid[row][col] = MazeContents.WALL;
            // System.out.println(mazeGrid[row][col]);
          } else if (String.valueOf(data.charAt(col)).equals(".")) {
            this.mazeGrid[row][col] = MazeContents.OPEN;
            // System.out.println(mazeGrid[row][col]);
          } else if (String.valueOf(data.charAt(col)).equals("S")) {
            this.start = new MazeLocation(row, col);
            this.mazeGrid[row][col] = MazeContents.OPEN;
            // this.mazeGrid[row][col] = MazeContents.VISITED;
          } else if (String.valueOf(data.charAt(col)).equals("F")) {
            this.mazeGrid[row][col] = MazeContents.OPEN;
            this.finish = new MazeLocation(row, col);
            // this.mazeGrid[row][col] = MazeContents.PATH;
          }
        }
        row++;
        // data = reader.nextLine();
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }
  }

  /** @return height of maze grid */
  public int getHeight() {
    return this.height;
  }

  /** @return width of maze grid */
  public int getWidth() {
    return this.width;
  }

  /** @return contents of maze grid at row i, column j */
  public MazeContents getContents(int i, int j) {
    return mazeGrid[i][j];
  }

  /** @return location of maze start point */
  public MazeLocation getStart() {
    return this.start;
  }

  /** @return location of maze finish point */
  public MazeLocation getFinish() {
    return this.finish;
  }

  /**
   * Set location to visited
   * @param i int row of location
   * @param j int column of location
   */
  public void setVisited(int i, int j) {
    mazeGrid[i][j] = MazeContents.VISITED;
  }

  /**
   * Set location to path
   * @param i int row of location
   * @param j int column of location
   */
  public void setPath(int i, int j) {
    mazeGrid[i][j] = MazeContents.PATH;
  }

  /**
   * Set location to dead end
   * @param i int row of location
   * @param j int column of location
   */
  public void setDeadEnd(int i, int j) {
    mazeGrid[i][j] = MazeContents.DEAD_END;
  }

  //testing
  public static void main(String[] args) {
    Maze maze = new Maze();
    // MazeViewer viewer = new MazeViewer(maze);
    maze.initMaze("maze2");

    // System.out.println(maze.getContents(0, 0));
  }
}
