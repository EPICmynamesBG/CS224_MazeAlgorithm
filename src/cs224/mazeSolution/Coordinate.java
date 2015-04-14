package cs224.mazeSolution;

import java.util.ArrayList;

public class Coordinate {
	
	int x, y, value, heuristicCost;
    private ArrayList<Coordinate> neighbors = new ArrayList<>();
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
	
	public Integer getXCoordinate(){
		return this.x;
	}
	
	public Integer getYCoordinate(){
		return this.y;
	}
	
	public Coordinate getLeftCoordinate(){
		return new Coordinate (this.x - 1, this.y);	
	}
	
	public Coordinate getRightCoordinate(){
		return new Coordinate (this.x + 1, this.y);
	}
	
	public Coordinate getAboveCoordinate(){
		return new Coordinate (this.x, this.y - 1);	
	}
	
	public Coordinate getBelowCoordinate(){
		return new Coordinate (this.x, this.y + 1);	
	}
	
	public ArrayList<Coordinate> getNeighborNodes(){
		ArrayList<Coordinate> neighborNodes = new ArrayList<>();
		neighborNodes.add(this.getLeftCoordinate());
		neighborNodes.add(this.getRightCoordinate());
		neighborNodes.add(this.getAboveCoordinate());
		neighborNodes.add(this.getBelowCoordinate());
		return neighborNodes;
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
	
    public void addNeighbor(Coordinate other) {
        if (!this.getNeighbors().contains(other)) { // avoid duplicates
            this.getNeighbors().add(other);
        }
        if (!other.getNeighbors().contains(this)) { // avoid duplicates
            other.getNeighbors().add(this);
        }
    }
    
    public boolean isCoordinateBelowNeighbor() {
        return this.getNeighbors().contains(new Coordinate(this.x, this.y + 1));
    }
    
    public boolean isCoordinateRightNeighbor() {
        return this.getNeighbors().contains(new Coordinate(this.x + 1, this.y));
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
    
	public int heuristicCostEstimate(Coordinate goal, int[][] uneditedMaze){
		int manhattanDistanceSum = 0;
	    for (int x = 0; x < 81; x++) // x-dimension, traversing rows (i)
	        for (int y = 0; y < 41; y++) { // y-dimension, traversing cols (j)
	            int value = uneditedMaze[x][y]; 
	            if (value != 0) { // we don't compute MD for element 0
	                int targetX = (value - 1) / 81; // expected x-coordinate (row)
	                int targetY = (value - 1) % 41; // expected y-coordinate (col)
	                int dx = x - targetX; // x-distance to expected coordinate
	                int dy = y - targetY; // y-distance to expected coordinate
	                manhattanDistanceSum += Math.abs(dx) + Math.abs(dy); 
	            } 
	        }
	    int manhattanDistance = manhattanDistanceSum;
		return manhattanDistance;
	}

	public ArrayList<Coordinate> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Coordinate> neighbors) {
		this.neighbors = neighbors;
	}
}
