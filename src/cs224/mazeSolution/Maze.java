package cs224.mazeSolution;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Maze implements Iterable<Coordinate>{
	
	LinkedHashMap<Coordinate, Integer> maze = new LinkedHashMap<>();
	
	public void addValue(Coordinate coordinate, Integer value){
		maze.put(coordinate, value);
	}
	
	public String toString(){
		Integer count = 0;
		String mazeString = "start\n";
		
		for (Coordinate coordinate : maze.keySet()){
			System.out.println(coordinate);
		}
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
	
	public Integer getMazeValue(Coordinate coordinate){
		Integer value = maze.get(coordinate);
		return value;
	}

	public Integer getMazeSize(){
		return maze.size();
	}
	
	@Override
	public Iterator<Coordinate> iterator() {
		return maze.keySet().iterator();
	}
}
