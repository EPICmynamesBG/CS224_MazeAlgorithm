package cs224.maze.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cs224.mazeSolution.Coordinate;

public class MazeTest {
	
	public MazeTest(){
		
	}
	
	@Test
	public void testStuff(){
		Coordinate coordinate = new Coordinate(1, 1);
		Integer xCoordinate = coordinate.getXCoordinate();
		Integer yCoordinate = coordinate.getYCoordinate();
		System.out.println(xCoordinate + " " + yCoordinate);
		
		ArrayList<Coordinate> neighborNodes = coordinate.getNeighborNodes();
		
		System.out.println(neighborNodes);
		Coordinate leftCoordinate = coordinate.getLeftCoordinate();
		Coordinate rightCoordinate = coordinate.getRightCoordinate();
		Coordinate aboveCoordinate = coordinate.getAboveCoordinate();
		Coordinate belowCoordinate = coordinate.getBelowCoordinate();

		coordinate.addNeighbor(leftCoordinate);
		coordinate.addNeighbor(rightCoordinate);
		coordinate.addNeighbor(aboveCoordinate);
		coordinate.addNeighbor(belowCoordinate);
		System.out.println(coordinate.getNeighbors());
		assertEquals(1, 1);
	}
}
