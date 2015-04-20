package cs224.mazeSolution;

import cs224.mazeCreator.MazeSize;
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
		
	    for (Integer key : maze.values()){
	    	if (count.equals(MazeSize.WIDTH)){
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
		if (isMazeValue(coordinate)){
			Integer value = maze.get(coordinate);
			return value;
		}else{
			return 1;
		}
	}
	
	public boolean isMazeValue(Coordinate coordinate){
		return maze.containsKey(coordinate);
	}

	public Integer getMazeSize(){
		return maze.size();
	}
	
	@Override
	public Iterator<Coordinate> iterator() {
		return maze.keySet().iterator();
	}
}
