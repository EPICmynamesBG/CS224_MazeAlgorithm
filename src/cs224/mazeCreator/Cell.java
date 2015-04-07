package cs224.mazeCreator;

import java.util.ArrayList;

public class Cell {
	
	    int x, y;
	    ArrayList<Cell> neighbors = new ArrayList<>();
	    boolean visited = false;
	    Cell parent = null;
	    boolean inPath = false;
	    double travelled;
	    double projectedDist;
	    boolean wall = true;
	    boolean open = true;

	    Cell(int x, int y) {
	        this(x, y, true);
	    }
	    
	    Cell(int x, int y, boolean isWall) {
	        this.x = x;
	        this.y = y;
	        this.wall = isWall;
	    }

	    void addNeighbor(Cell other) {
	        if (!this.neighbors.contains(other)) { // avoid duplicates
	            this.neighbors.add(other);
	        }
	        if (!other.neighbors.contains(this)) { // avoid duplicates
	            other.neighbors.add(this);
	        }
	    }
	    // used in updateGrid()
	    boolean isCellBelowNeighbor() {
	        return this.neighbors.contains(new Cell(this.x, this.y + 1));
	    }
	    // used in updateGrid()
	    boolean isCellRightNeighbor() {
	        return this.neighbors.contains(new Cell(this.x + 1, this.y));
	    }
	    // useful Cell representation
	    @Override
	    public String toString() {
	        return String.format("Cell(%s, %s)", x, y);
	    }
	    // useful Cell equivalence
	    @Override
	    public boolean equals(Object other) {
	        if (!(other instanceof Cell)) return false;
	        Cell otherCell = (Cell) other;
	        return (this.x == otherCell.x && this.y == otherCell.y);
	    }
	    // should be overridden with equals
	    @Override
	    public int hashCode() {
	        // random hash code method designed to be usually unique
	        return this.x + this.y * 256;
	    }
}
