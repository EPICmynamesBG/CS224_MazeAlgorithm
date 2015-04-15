package cs224.mazeSolution;

import java.util.LinkedHashMap;

public class Maze{
	
	LinkedHashMap<Coordinate, Integer> maze = new LinkedHashMap<>();
	
	public void addValue(Coordinate coordinate, Integer value){
		maze.put(coordinate, value);
	}
	
	public String toString(){
		Integer count = 0;
		String mazeString = "start\n";
		
	    for (Integer key : maze.values()){
	    	if (count.equals(81)){
	    		mazeString += "\n";
	    		count = 0;
	    	}
	    	mazeString += key;
	    	count++;
	    }
	    mazeString += "\nend";
	    return mazeString;
	}
}
