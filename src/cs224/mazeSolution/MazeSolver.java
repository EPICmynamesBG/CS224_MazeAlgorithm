package cs224.mazeSolution;

import java.util.ArrayList;
import cs224.mazeSolution.Coordinate;

public class MazeSolver {
	private int dimensionX, dimensionY; // dimension of maze
	private Coordinate[][] coordinates;
	private int[][] uneditedMaze;
	private ArrayList<Coordinate> visitedNodes = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> nodesToVisit = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> navigatedNodes = new ArrayList<Coordinate>();
	
	public void solve(int[][] maze) {
		uneditedMaze = maze;
		Coordinate startingPoint = new Coordinate(1,1);
		Coordinate endingPoint = new Coordinate(79,39);
	
		nodesToVisit.add(0, startingPoint);
		
		int currentScore = 0;
		
		while (!nodesToVisit.isEmpty()){
			Coordinate currentNode = nodesToVisit.get(0);
			int heuristicCost = currentNode.heuristicCostEstimate(endingPoint, uneditedMaze);
			currentNode.setHeuristicCost(heuristicCost);
			
			if (currentNode.equals(endingPoint)){
//				return reconstructPath(navigatedNodes, goal);
			}
			nodesToVisit.remove(currentNode);
			visitedNodes.add(currentNode);
			
			ArrayList<Coordinate> neighborNodes = currentNode.getNeighborNodes();
			for (Coordinate neighbor : neighborNodes){
				if (visitedNodes.contains(neighbor)){
					continue;
				}
				if (!nodesToVisit.contains(neighbor)){
					
					if(!nodesToVisit.contains(neighbor)){
						nodesToVisit.add(neighbor);
					}
				}
			}
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
