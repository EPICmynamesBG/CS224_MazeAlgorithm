package cs224.maze.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import cs224.mazeSolution.Coordinate;
import cs224.mazeSolution.Maze;
import cs224.mazeSolution.MazeReader;

public class CoordinateTest {
	
	MazeReader reader = new MazeReader();
	
	public CoordinateTest(){
		
	}
	
	@Test
	public void testThatCoordinatesAreEqual(){
		Coordinate coordinate1 = new Coordinate(1, 1);
		Coordinate coordinate2 = new Coordinate(1, 1);
		assertTrue(coordinate1.equals(coordinate2));
	}
	
	@Test
	public void testThatCoordinateAreNotEqual(){
		Coordinate coordinate1 = new Coordinate(1, 0);
		Coordinate coordinate2 = new Coordinate(1, 1);
		assertFalse(coordinate1.equals(coordinate2));
	}
	
	@Test
	public void testThatDistanceCostIsIncremented(){
		Coordinate coordinate1 = new Coordinate(1, 1);
		coordinate1.setMovementCost(10);
		Integer expected = 10;
		Integer actual = coordinate1.getMovementCost();
		assertEquals(actual, expected);
	}
	
	@Test
	public void testThatDistanceIsFound(){
		Coordinate coordinate1 = new Coordinate(1, 1);
		Coordinate coordinate2 = new Coordinate(1, 2);
		Integer distance = coordinate1.heuristicCostEstimate(coordinate2);
		Integer expected = 1;
		assertTrue(distance.equals(expected));
	}
	
	@Test
	public void testGetNeighborNodes() throws IOException{
		Maze maze = reader.readFile("OutFile.txt");
		Coordinate coordinate1 = new Coordinate(1, 1);
		coordinate1.getNeighborNodes(maze);
		assertTrue(true);
	}
}
