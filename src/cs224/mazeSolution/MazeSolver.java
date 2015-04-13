package cs224.mazeSolution;

import java.util.ArrayList;
import cs224.mazeSolution.Coordinate;

public class MazeSolver {
	private int dimensionX, dimensionY; // dimension of maze
	private Coordinate[][] coordinates;
	public static int[][] uneditedMaze;
	
	public static void solve(int[][] maze) {
		uneditedMaze = maze;
		Coordinate start = new Coordinate(1,1);
		Coordinate end = new Coordinate(79,39);
		//Coor: maze[x][y]
		//Start index: maze[1][1]
		//End index: maze[79][39]
		ArrayList<Coordinate> visitedNodes = new ArrayList<Coordinate>();
		ArrayList<Coordinate> nodesToVisit = new ArrayList<Coordinate>();
		ArrayList<Coordinate> navigatedNodes = new ArrayList<Coordinate>();
		nodesToVisit.add(0, start);
		
		int currentScore = 0;
		
		Coordinate goal = new Coordinate(79,39);
		
		while (!nodesToVisit.isEmpty()){
			Coordinate currentNode = nodesToVisit.get(0);
			int heuristicCost = heuristic_cost_estimate(currentNode, goal);
			currentNode.setHeuristicCost(heuristicCost);
			
			if (currentNode.equals(goal)){
//				return reconstructPath(navigatedNodes, goal);
			}
			nodesToVisit.remove(currentNode);
			visitedNodes.add(currentNode);
			
//			for (){}
		}
	}
	
	public static ArrayList<Coordinate> reconstructPath(ArrayList<Coordinate> navigatedNodes, Coordinate current){
		ArrayList <Coordinate> totalPath = new ArrayList<Coordinate>();
		totalPath.add(current);
		while (navigatedNodes.contains(current)){
//			current = navigatedNodes.get();
			totalPath.add(current);
		}
		return totalPath;
	}
	
	private static int heuristic_cost_estimate(Coordinate current, Coordinate goal){
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
}
