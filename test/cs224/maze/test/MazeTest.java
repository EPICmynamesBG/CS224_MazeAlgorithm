package cs224.maze.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs224.mazeSolution.Coordinate;
import cs224.mazeSolution.Maze;

public class MazeTest {
	
	public MazeTest(){
		
	}
	
	public Maze makeMaze(){
		Maze maze = new Maze();
		for (int i = 0; i <= 10; i++){
			for (int k = 0; k <= 10; k++){
				Coordinate coordinate = new Coordinate (i, k);
				Integer value;
				if (k % 2 != 0){
					value = 0;
				}else{
					value = 1;
				}
				maze.addValue(coordinate, value);
			}
		}
		return maze;
	}
	
	@Test
	public void testThatValueIsFoundForCoordinate(){
		Maze maze = makeMaze();
		Coordinate coordinate = new Coordinate(1, 1);
		Integer actual = maze.getMazeValue(coordinate);
		Integer expected = 0;
		assertEquals(expected, actual);
	}
}
