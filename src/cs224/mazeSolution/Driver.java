package cs224.mazeSolution;

import cs224.mazeSolution.MazeReader;
import cs224.mazeSolution.MazeSolver;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/Users/brandongroff/Desktop/OutFile.txt";
		String maze = MazeReader.readFile(filePath);
		MazeSolver.solve(maze);
	}

}
