package cs224.mazeSolution;

import java.util.ArrayList;

public class Coordinate {
	
	private int x, y, value, heuristicCost;
    private ArrayList<Coordinate> neighbors = new ArrayList<>();
    public Integer movementCost;
		
    Coordinate(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.heuristicCost = 0;
        this.movementCost = 0;
    }
    
    Coordinate(int x, int y, int value, int heuristicCost){
    	this.x = x;
        this.y = y;
        this.value = value;
        this.heuristicCost = heuristicCost;
        this.movementCost=0;
    }
    
	public Coordinate(int x, int y){
		this(x, y, 0, 0);
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
		System.out.println(maze.isMazeValue(this.getLeftCoordinate()) + " HELLO");
		if (maze.getMazeValue(this.getLeftCoordinate()) != 1 && maze.isMazeValue(this.getLeftCoordinate())){
			neighborNodes.add(this.getLeftCoordinate());	
		}
		if (maze.getMazeValue(this.getRightCoordinate()) != 1 && maze.isMazeValue(this.getLeftCoordinate())){
			neighborNodes.add(this.getRightCoordinate());
		}
		if (maze.getMazeValue(this.getAboveCoordinate()) != 1 && maze.isMazeValue(this.getLeftCoordinate())){
			neighborNodes.add(this.getAboveCoordinate());
		}
		if (maze.getMazeValue(this.getBelowCoordinate()) != 1 && maze.isMazeValue(this.getLeftCoordinate())){
			neighborNodes.add(this.getBelowCoordinate());
		}
		return neighborNodes;
	}
	
	public Integer getMovementCost(){
		return this.movementCost;
	}
	
	public void setMovementCost(Integer distanceCost){
		this.movementCost = distanceCost;
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
	
	public int getHeuristicCost(){
		return this.heuristicCost;
	}
	
	public int heuristicCostEstimate(Coordinate goal){
		int cost = (int) Math.sqrt(Math.pow(this.x - goal.x, 2) + Math.pow(this.y - goal.y, 2));
		setHeuristicCost(cost);
		return cost;
	}
	
    public void addNeighbor(Coordinate other) {
        if (!this.getNeighbors().contains(other)) { // avoid duplicates
            this.getNeighbors().add(other);
        }
        if (!other.getNeighbors().contains(this)) { // avoid duplicates
            other.getNeighbors().add(this);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Coordinate(%s, %s)", x, y);
    }
    
    public boolean equals(Coordinate other) {
        if (this.x == other.x && this.y == other.y){
        	return true;
        }
    	return false;
    }
    
    @Override
    public int hashCode() {
        return this.x + this.y * 256;
    }
    
	public ArrayList<Coordinate> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Coordinate> neighbors) {
		this.neighbors = neighbors;
	}
	
	
}
