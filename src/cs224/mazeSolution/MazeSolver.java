package cs224.mazeSolution;

import java.util.ArrayList;



public class MazeSolver {
	
	public static int[][] uneditedMaze;
	
	public static void solve(int[][] maze) {
		uneditedMaze = maze;
		// TODO Auto-generated method stub
		Coor start = new Coor(1,1);
		Coor end = new Coor(39, 79);
		//Start index: maze[1][1]
		//End index: maze[39][79]
		ArrayList<Coor> visitedNodes = new ArrayList<Coor>();
		ArrayList<Coor> nodesToVisit = new ArrayList<Coor>();
		ArrayList<Coor> navigatedNodes = new ArrayList<Coor>();
		nodesToVisit.add(0, start);
		
		int currentScore = 0;
		int finalScore = currentScore; // + heuristic_cost_estimate(start, goal);
		
		while (!nodesToVisit.isEmpty()){
			
			
		}
	}
	
	
	
	
	
	
	
	private static class Coor{
		private int x;
		private int y;
		
		public Coor(int x, int y){
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
		
}
