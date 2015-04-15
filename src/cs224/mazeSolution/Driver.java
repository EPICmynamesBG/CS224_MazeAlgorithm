package cs224.mazeSolution;

import java.io.IOException;

import cs224.mazeSolution.MazeReader;
import cs224.mazeSolution.MazeSolver;

public class Driver {

	public static void main(String[] args) throws IOException {
		String filePath = "OutFile.txt";
		
		MazeReader reader = new MazeReader();
		Maze maze = reader.readFile(filePath);
		MazeSolver solver = new MazeSolver();
//		solver.solve(maze);
	}

}
