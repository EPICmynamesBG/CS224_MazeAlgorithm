package cs224.mazeSolution;

import java.util.ArrayList;

public class Coordinate {
	
	int x, y, value, heuristicCost;
    ArrayList<Coordinate> neighbors = new ArrayList<>();
    boolean visited = false;
    Coordinate parent = null;
    boolean inPath = false;
    double travelled;
    double projectedDist;
    boolean wall = true;
    boolean open = true;
		
    Coordinate(int x, int y, int value, boolean isWall) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.heuristicCost = 0;
        this.wall = isWall;
    }
    
    Coordinate(int x, int y, int value, int heuristicCost, boolean isWall){
    	this.x = x;
        this.y = y;
        this.value = value;
        this.heuristicCost = heuristicCost;
        this.wall = isWall;
    }
    
	public Coordinate(int x, int y){
		this(x, y, 0, 0, true);
	}
	
	public int[] getCoor(){
		int[] result = {this.x , this.y };
		return result;
	}
		
	public int getMazeIntAtCoor(int[][] maze){	
		return maze[this.x][this.y];
	}
		
	public String getCoorAsString(){
		return "("+this.x+", "+this.y+")";
	}
	
	public int getCoorValue(){
		return this.value;
	}
	
	public void setHeuristicCost(int value){
		this.heuristicCost = value;
	}
	
	public int getHeuristicValue(){
		return this.heuristicCost;
	}
	
    void addNeighbor(Coordinate other) {
        if (!this.neighbors.contains(other)) { // avoid duplicates
            this.neighbors.add(other);
        }
        if (!other.neighbors.contains(this)) { // avoid duplicates
            other.neighbors.add(this);
        }
    }
    
    boolean isCoordinateBelowNeighbor() {
        return this.neighbors.contains(new Coordinate(this.x, this.y + 1));
    }
    
    boolean isCoordinateRightNeighbor() {
        return this.neighbors.contains(new Coordinate(this.x + 1, this.y));
    }
    
    @Override
    public String toString() {
        return String.format("Coordinate(%s, %s)", x, y);
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Coordinate)) return false;
        Coordinate otherCoordinate = (Coordinate) other;
        return (this.x == otherCoordinate.x && this.y == otherCoordinate.y);
    }
    
    @Override
    public int hashCode() {
        return this.x + this.y * 256;
    }
}
