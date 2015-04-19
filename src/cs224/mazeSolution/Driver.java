package cs224.mazeSolution;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import cs224.mazeSolution.MazeReader;
import cs224.mazeSolution.MazeSolver;

public class Driver {

	public static void main(String[] args) throws IOException {
		String filePath = "Maze.txt";
		
		MazeReader reader = new MazeReader();
		Maze maze = reader.readFile(filePath);
		MazeSolver solver = new MazeSolver();
		Maze solvedMaze = solver.solve(maze);

		System.out.println(solvedMaze);
		
		MazeWriter writer = new MazeWriter();
		writer.writeFile(solvedMaze);
	}
}
