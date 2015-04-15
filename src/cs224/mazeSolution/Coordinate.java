package cs224.mazeSolution;

import java.util.ArrayList;

public class Coordinate {
	
	private int x, y, value, heuristicCost;
    private ArrayList<Coordinate> neighbors = new ArrayList<>();
//    private boolean visited = false;
//    private Coordinate parent = null;
//    private boolean inPath = false;
//    private double travelled;
//    private double projectedDist;
    private boolean wall = true;
//    private boolean open = true;
    public Integer distanceCost = 0;
		
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
	
	public ArrayList<Coordinate> getNeighborNodes(Maze maze){
		ArrayList<Coordinate> neighborNodes = new ArrayList<>();
		if (maze.getMazeValue(this.getLeftCoordinate()) != 1){
			neighborNodes.add(this.getLeftCoordinate());	
		}
		if (maze.getMazeValue(this.getRightCoordinate()) != 1){
			neighborNodes.add(this.getRightCoordinate());
		}
		if (maze.getMazeValue(this.getAboveCoordinate()) != 1){
			neighborNodes.add(this.getAboveCoordinate());
		}
		if (maze.getMazeValue(this.getBelowCoordinate()) != 1){
			neighborNodes.add(this.getBelowCoordinate());
		}
		return neighborNodes;
	}
	
	public Integer getDistanceCost(){
		return this.distanceCost;
	}
	
	public void setDistanceCost(Integer distanceCost){
		this.distanceCost = distanceCost;
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
//    
//    public boolean isCoordinateBelowNeighbor() {
//        return this.getNeighbors().contains(new Coordinate(this.x, this.y + 1));
//    }
//    
//    public boolean isCoordinateRightNeighbor() {
//        return this.getNeighbors().contains(new Coordinate(this.x + 1, this.y));
//    }
    
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
    
	public int heuristicCostEstimate(Coordinate goal, Maze uneditedMaze){
		int manhattanDistanceSum = 0;
		for (Coordinate coordinate : uneditedMaze){
			Integer value = uneditedMaze.getMazeValue(coordinate);
			Integer x = coordinate.getXCoordinate();
			Integer y = coordinate.getYCoordinate();
			
			if (value != 0){
				int targetX = (value - 1) / 81;
				int targetY = (value - 1) % 41;
				int dx = x - targetX;
				int dy = y - targetY;
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
