package cs224.mazeSolution;

import cs224.mazeCreator.MazeSize;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MazeWriter {
	
	public void writeFile(Maze maze) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("SolvedMaze.txt", "UTF-8");
		Integer count = 0;
		String lineString = "";
		
		for (Coordinate coordinate : maze){
			Integer mazeValue = maze.getMazeValue(coordinate);
			
			if (mazeValue.equals(0)){
				lineString += " ";
			}else if (mazeValue.equals(1)){
				lineString += "X";
			}else if (mazeValue.equals(2)){
				lineString += "#";
			}else{
				lineString += "YO";
			}
			
			if(count.equals(MazeSize.WIDTH-1)){
				writer.println(lineString);
				count = 0;
				lineString = "";
				continue;
			}
			count++;
		}
		writer.close();
	}
}
