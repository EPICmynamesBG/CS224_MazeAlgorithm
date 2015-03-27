package cs224.mazeSolution;

import java.io.IOException;

import cs224.mazeSolution.MazeReader;
import cs224.mazeSolution.MazeSolver;

public class Driver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "OutFile.txt"; //for text file in project directory
		int[][] maze = MazeReader.readFile(filePath);
		MazeSolver.solve(maze);
	}

}
