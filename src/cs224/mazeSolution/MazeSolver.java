package cs224.mazeSolution;

import java.util.ArrayList;
import cs224.mazeSolution.Coordinate;

public class MazeSolver {
	private Maze uneditedMaze;
	private ArrayList<Coordinate> visitedNodes = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> nodesToVisit = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> navigatedNodes = new ArrayList<Coordinate>();
	private final Integer DISTANCE_COST = 10;
	
	public void solve(Maze maze) {
		uneditedMaze = maze;
		Coordinate startingPoint = new Coordinate(1,1);
		Coordinate endingPoint = new Coordinate(79,39);
	
		nodesToVisit.add(0, startingPoint);
		
		Integer currentDistanceCost = 0;
		Integer currentHeuristicCost = currentDistanceCost + startingPoint.heuristicCostEstimate(endingPoint, uneditedMaze);
		
		while (!nodesToVisit.isEmpty()){
			Coordinate currentNode = nodesToVisit.get(0);
			int heuristicCostScore = currentNode.heuristicCostEstimate(endingPoint, uneditedMaze);
			currentNode.setHeuristicCost(heuristicCostScore);
			
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
				
				Integer tentativeCurrentDistanceCost = currentDistanceCost + DISTANCE_COST;
				
				if (!nodesToVisit.contains(neighbor) || tentativeCurrentDistanceCost < neighbor.getDistanceCost()){
					navigatedNodes.add(currentNode);
					neighbor.setDistanceCost(tentativeCurrentDistanceCost);
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
