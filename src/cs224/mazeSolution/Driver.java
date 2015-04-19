package cs224.mazeSolution;

import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		String filePath = "Maze.txt";
		
		MazeReader reader = new MazeReader();
		Maze maze = reader.readFile(filePath);
		MazeSolver solver = new MazeSolver();
		Maze solvedMaze = solver.solve(maze);		
		MazeWriter writer = new MazeWriter();
		writer.writeFile(solvedMaze);
	}
}
