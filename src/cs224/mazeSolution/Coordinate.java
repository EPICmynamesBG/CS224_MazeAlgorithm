package cs224.mazeSolution;

public class Coordinate {
	
	private int x;
	private int y;
		
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
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
}
