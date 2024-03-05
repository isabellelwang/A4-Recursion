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
  // public void initDemoMaze() { // String fileName,
  // this.height = 10;
  // this.width = 8;
  // this.mazeGrid = new MazeContents[height][width];
  // this.start = new MazeLocation(1, 1);
  // this.finish = new MazeLocation(8, 6);

  // this.mazeGrid[0][0] = MazeContents.WALL;
  // this.mazeGrid[0][1] = MazeContents.WALL;
  // this.mazeGrid[0][2] = MazeContents.WALL;
  // this.mazeGrid[0][3] = MazeContents.WALL;
  // this.mazeGrid[0][4] = MazeContents.WALL;
  // this.mazeGrid[0][5] = MazeContents.WALL;
  // this.mazeGrid[0][6] = MazeContents.WALL;
  // this.mazeGrid[0][7] = MazeContents.WALL;
  // this.mazeGrid[1][0] = MazeContents.WALL;
  // this.mazeGrid[1][1] = MazeContents.OPEN;
  // this.mazeGrid[1][2] = MazeContents.OPEN;
  // this.mazeGrid[1][3] = MazeContents.OPEN;
  // this.mazeGrid[1][4] = MazeContents.OPEN;
  // this.mazeGrid[1][5] = MazeContents.OPEN;
  // this.mazeGrid[1][6] = MazeContents.WALL;
  // this.mazeGrid[1][7] = MazeContents.WALL;
  // this.mazeGrid[2][0] = MazeContents.WALL;
  // this.mazeGrid[2][1] = MazeContents.WALL;
  // this.mazeGrid[2][2] = MazeContents.OPEN;
  // this.mazeGrid[2][3] = MazeContents.WALL;
  // this.mazeGrid[2][4] = MazeContents.WALL;
  // this.mazeGrid[2][5] = MazeContents.OPEN;
  // this.mazeGrid[2][6] = MazeContents.WALL;
  // this.mazeGrid[2][7] = MazeContents.WALL;
  // this.mazeGrid[3][0] = MazeContents.WALL;
  // this.mazeGrid[3][1] = MazeContents.OPEN;
  // this.mazeGrid[3][2] = MazeContents.WALL;
  // this.mazeGrid[3][3] = MazeContents.OPEN;
  // this.mazeGrid[3][4] = MazeContents.OPEN;
  // this.mazeGrid[3][5] = MazeContents.OPEN;
  // this.mazeGrid[3][6] = MazeContents.WALL;
  // this.mazeGrid[3][7] = MazeContents.WALL;
  // this.mazeGrid[4][0] = MazeContents.WALL;
  // this.mazeGrid[4][1] = MazeContents.OPEN;
  // this.mazeGrid[4][2] = MazeContents.OPEN;
  // this.mazeGrid[4][3] = MazeContents.OPEN;
  // this.mazeGrid[4][4] = MazeContents.WALL;
  // this.mazeGrid[4][5] = MazeContents.WALL;
  // this.mazeGrid[4][6] = MazeContents.OPEN;
  // this.mazeGrid[4][7] = MazeContents.WALL;
  // this.mazeGrid[5][0] = MazeContents.WALL;
  // this.mazeGrid[5][1] = MazeContents.OPEN;
  // this.mazeGrid[5][2] = MazeContents.WALL;
  // this.mazeGrid[5][3] = MazeContents.OPEN;
  // this.mazeGrid[5][4] = MazeContents.OPEN;
  // this.mazeGrid[5][5] = MazeContents.WALL;
  // this.mazeGrid[5][6] = MazeContents.WALL;
  // this.mazeGrid[5][7] = MazeContents.WALL;
  // this.mazeGrid[6][0] = MazeContents.WALL;
  // this.mazeGrid[6][1] = MazeContents.OPEN;
  // this.mazeGrid[6][2] = MazeContents.WALL;
  // this.mazeGrid[6][3] = MazeContents.WALL;
  // this.mazeGrid[6][4] = MazeContents.OPEN;
  // this.mazeGrid[6][5] = MazeContents.OPEN;
  // this.mazeGrid[6][6] = MazeContents.OPEN;
  // this.mazeGrid[6][7] = MazeContents.WALL;
  // this.mazeGrid[7][0] = MazeContents.WALL;
  // this.mazeGrid[7][1] = MazeContents.OPEN;
  // this.mazeGrid[7][2] = MazeContents.WALL;
  // this.mazeGrid[7][3] = MazeContents.OPEN;
  // this.mazeGrid[7][4] = MazeContents.OPEN;
  // this.mazeGrid[7][5] = MazeContents.WALL;
  // this.mazeGrid[7][6] = MazeContents.OPEN;
  // this.mazeGrid[7][7] = MazeContents.WALL;
  // this.mazeGrid[8][0] = MazeContents.WALL;
  // this.mazeGrid[8][1] = MazeContents.OPEN;
  // this.mazeGrid[8][2] = MazeContents.OPEN;
  // this.mazeGrid[8][3] = MazeContents.WALL;
  // this.mazeGrid[8][4] = MazeContents.OPEN;
  // this.mazeGrid[8][5] = MazeContents.WALL;
  // this.mazeGrid[8][6] = MazeContents.OPEN;
  // this.mazeGrid[8][7] = MazeContents.WALL;
  // this.mazeGrid[9][0] = MazeContents.WALL;
  // this.mazeGrid[9][1] = MazeContents.WALL;
  // this.mazeGrid[9][2] = MazeContents.WALL;
  // this.mazeGrid[9][3] = MazeContents.WALL;
  // this.mazeGrid[9][4] = MazeContents.WALL;
  // this.mazeGrid[9][5] = MazeContents.WALL;
  // this.mazeGrid[9][6] = MazeContents.WALL;
  // this.mazeGrid[9][7] = MazeContents.WALL;
  // }

  /**
   * Initializes a maze given a maze file
   * 
   * @param filename
   */
  public void initDemoMaze(String filename) {
    Scanner mazeFile = null;
    try {
      mazeFile = new Scanner(new File(filename));

    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }

    while (mazeFile.hasNext()) {
      this.width++;
    }
    while (mazeFile.hasNextLine()) {
      this.height++;
    }

    this.mazeGrid = new MazeContents[height][width];
    this.start = new MazeLocation(0, 0);
    this.finish = new MazeLocation(0, 0);
    int col = 0;

    while (mazeFile.hasNextLine()) {
      System.out.println("next line");
      String data = mazeFile.nextLine();
      System.out.println(data);
      for (int i = 0; i < data.length(); i++) {
        System.out.println(col + " " + i);
        if (String.valueOf(data.charAt(i)).equals("#")) {
          this.mazeGrid[col][i] = MazeContents.WALL;
        } else if (String.valueOf(data.charAt(i)).equals(".")) {
          this.mazeGrid[col][i] = MazeContents.OPEN;
        } else if (String.valueOf(data.charAt(i)).equals("S")) {
          this.start.setRow(i);
          this.start.setCol(col);
        } else if (String.valueOf(data.charAt(i)).equals("F")) {
          this.finish.setRow(i);
          this.finish.setCol(col);
        }
      }
      col++;
    }
    mazeFile.close();

    // try {
    // file = new Scanner(new File(filename));
    // } catch (FileNotFoundException e) {
    // System.err.println("Cannot locate file.");
    // System.exit(-1);
    // }

    // for(int i = 0; i < height; i++) {
    // for(int k = 0; k < width; k++) {
    // while(file.hasNext() || file.hasNextLine()) {
    // if(file.next().equals("#")) {
    // mazeGrid[i][j] = MazeContents.WALL;
    // }
    // else if(file.next())
    // }
    // }
    // }

    // while(file.hasNext() || file.hasNextLine()) {
    // if(file.hasNext()
    // }

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

  public void setVisited(int i, int j) {
    mazeGrid[i][j] = MazeContents.VISITED;
  }

  public void setPath(int i, int j) {
    mazeGrid[i][j] = MazeContents.PATH;
  }

  public void setDeadEnd(int i, int j) {
    mazeGrid[i][j] = MazeContents.DEAD_END;
  }

  public static void main(String[] args) {
    Maze maze = new Maze();

    maze.initDemoMaze("maze1");
    maze.getStart();
  }
}
