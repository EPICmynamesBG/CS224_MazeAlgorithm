package cs224.mazeSolution;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeReader {
	
	static int[][] maze = new int[41][81]; 
	
	public static int[][] readFile(String filePath) throws IOException{
		File file = new File(filePath);
	    Scanner scanner = new Scanner(file);
	    int y=0;
	    try {
	        while(scanner.hasNextLine()) { 
	        	String line = scanner.nextLine();
	        	parseLine(y, line);
	            y+=1;
	        }
	    } finally {
	        scanner.close();
	    }
	    //Uncomment to view maze in console
	    System.out.println("start");
	    for(int i = 0; i < 41; i++){
	    	for(int j = 0; j < 81; j++){
	    		System.out.print(maze[i][j]);
	    	}
	    	System.out.println();
	    }
	    System.out.println("end");
	   
		return maze;
	}
	
	private static void parseLine(int lineNumber, String s){
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c =='X'){
				maze[lineNumber][i] = 1;
			}else{
				maze[lineNumber][i] = 0;
			}
		}
	}
	
}
