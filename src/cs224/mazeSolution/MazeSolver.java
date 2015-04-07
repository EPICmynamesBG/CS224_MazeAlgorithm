package cs224.mazeSolution;

import java.util.ArrayList;

public class MazeSolver {
	
	public static int[][] uneditedMaze;
	
	public static void solve(int[][] maze) {
		uneditedMaze = maze;
		Coordinate start = new Coordinate(1,1);
		Coordinate end = new Coordinate(39, 79);
		//Start index: maze[1][1]
		//End index: maze[39][79]
		ArrayList<Coordinate> visitedNodes = new ArrayList<Coordinate>();
		ArrayList<Coordinate> nodesToVisit = new ArrayList<Coordinate>();
		ArrayList<Coordinate> navigatedNodes = new ArrayList<Coordinate>();
		nodesToVisit.add(0, start);
		
		int currentScore = 0;
		int finalScore = currentScore; // + heuristic_cost_estimate(start, goal);
		
		Coordinate goal = new Coordinate(39, 79);
		
		while (!nodesToVisit.isEmpty()){
			Coordinate currentNode = nodesToVisit.get(0);
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
}
