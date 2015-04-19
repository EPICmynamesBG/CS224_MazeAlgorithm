package cs224.mazeSolution;

import java.util.ArrayList;
import cs224.mazeSolution.Coordinate;

public class MazeSolver {
	private Maze uneditedMaze;
	private ArrayList<Coordinate> visitedNodes = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> nodesToVisit = new ArrayList<Coordinate>();
	private ArrayList<Coordinate> navigatedNodes = new ArrayList<Coordinate>();
	private final Integer DISTANCE_COST = 10;
	
	public Maze solve(Maze maze) {
		uneditedMaze = maze;
		Coordinate startingPoint = new Coordinate(1,1);
		Coordinate endingPoint = new Coordinate(39, 79);
	
		nodesToVisit.add(0, startingPoint);
		
		Integer currentDistanceCost = 0;
		Integer currentHeuristicCost = startingPoint.heuristicCostEstimate(endingPoint);
		startingPoint.setHeuristicCost(currentHeuristicCost);
		startingPoint.setMovementCost(0);
				
		while (!nodesToVisit.isEmpty()){			
			Coordinate minCoordinate = nodesToVisit.get(0);
			Integer min = minCoordinate.getMovementCost() + minCoordinate.getHeuristicCost();
			
			for (Coordinate coordinate : nodesToVisit){
				Integer cost = coordinate.getMovementCost() + coordinate.getHeuristicCost();
				if (cost < min){
					minCoordinate = coordinate;
					min = cost;
				}
			}
			Coordinate currentNode = minCoordinate;
			
			if (currentNode.equals(endingPoint)){
				reconstructPath(navigatedNodes, currentNode);
				nodesToVisit.clear();
			}
			nodesToVisit.remove(currentNode);
			visitedNodes.add(currentNode);
			
			ArrayList<Coordinate> neighborNodes = currentNode.getNeighborNodes(uneditedMaze);
			
			for (Coordinate neighbor : neighborNodes){
				if (visitedNodes.contains(neighbor)){
					continue;
				}
				neighbor.heuristicCostEstimate(endingPoint);
				neighbor.calculateMovementCost(currentNode);
				neighbor.setParent(currentNode);
				Integer tentativeCurrentDistanceCost = currentDistanceCost + DISTANCE_COST;
				
				if (!nodesToVisit.contains(neighbor) || tentativeCurrentDistanceCost < neighbor.getMovementCost()){
					if(!nodesToVisit.contains(neighbor)){
						nodesToVisit.add(neighbor);
					}
				}
			}
			navigatedNodes.add(currentNode);
		}
		return uneditedMaze;
	}
	
	public ArrayList<Coordinate> reconstructPath(ArrayList<Coordinate> navigatedNodes, Coordinate current){
		ArrayList <Coordinate> totalPath = new ArrayList<Coordinate>();
		totalPath.add(current);
		
		while (current.getParent() != null){
			current = current.getParent();
			totalPath.add(current);	
			uneditedMaze.addValue(current, uneditedMaze.getMazeValue(current) + 2);
		}
		return totalPath;
		}
}
