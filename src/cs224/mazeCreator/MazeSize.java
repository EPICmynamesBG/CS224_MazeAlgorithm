package cs224.mazeCreator;

public final class MazeSize {
	
	//change this to change maze size
	public static final int BASE_VALUE = 25;
	
	
	/*don't change below values */
	public static final int WIDTH = BASE_VALUE*4+1;
	public static final int HEIGHT = BASE_VALUE*2+1;
	public static final int START_X = 1;
	public static final int START_Y = 1;
	public static final int END_X = WIDTH-2;
	public static final int END_Y = HEIGHT-2;
}
