package cs224.mazeSolution;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeReader {
	
	private Maze maze = new Maze();
		
	public Maze readFile(String filePath) throws IOException{
		File file = new File(filePath);
	    Scanner scanner = new Scanner(file);
	    int y = 0;
	    try {
	        while(scanner.hasNextLine()) { 
	        	String line = scanner.nextLine();
	        	parseLine(y, line);
	        	y++;
	        }
	    } finally {
	        scanner.close();
	    }
		return maze;
	}
	
	private void parseLine(int lineNumber, String s){
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			Coordinate coordinate = new Coordinate(lineNumber, i);
			if (c == 'X'){
				Integer value = 1;
				maze.addValue(coordinate, value);
			}else{
				Integer value = 0;
				maze.addValue(coordinate, value);
			}
		}
	}
}
