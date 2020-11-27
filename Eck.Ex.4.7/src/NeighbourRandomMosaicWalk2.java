/** Eck Exercise 4.7
 * This reuses code from RandomMosaicWalk2.java (Eck)
 * This program opens a window full of randomly colored squares. Random square is chosen and 
 * changed to color of neighbouring square. The program runs until the user closes the window.
 * Need to change randomMove (use code to choose neighbour)
 * Do we need currentRow/Col as global variables now?
 * Move to random square
 * Randomly pick a neighbour
 * Set the random square to the neighbour's color
 * @author joel
 */

public class NeighbourRandomMosaicWalk2 {

    final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 20;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 20; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbances in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect(false); // Joel
        fillWithRandomColors();         
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
            // Joel: added - update currentRow & currentCol to new random square
        	currentRow = (int)(Math.random()*ROWS);
        	currentColumn = (int)(Math.random()*COLUMNS);        	
//            changeToRandomColor(currentRow, currentColumn); // Joel: removed
            changeToNeighbourColor(currentRow, currentColumn); // Joel: added            
//            randomMove(); // Joel: removed
            Mosaic.delay(1);  // Remove this line to speed things up!
        }
    }  // end main

    /**
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);  
            }
        }
    }  // end fillWithRandomColors

    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {    	
        int red = (int)(256*Math.random());    // Choose random levels in range
        int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
        int blue = (int)(256*Math.random());   //     and blue color components.
        Mosaic.setColor(rowNum,colNum,red,green,blue);  
    }  // end changeToRandomColor

    /**
     * Changes one square to color of one of its 4 neighbours (at random)
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a color of one of its neighbours.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToNeighbourColor(int rowNum, int colNum) {
      	int[] ncoords = neighbourCoord(); // get neighbour row & col
    	// get neighbouring square colours
    	int red = Mosaic.getRed(ncoords[0], ncoords[1]);
    	int green = Mosaic.getGreen(ncoords[0], ncoords[1]);
    	int blue = Mosaic.getBlue(ncoords[0], ncoords[1]);
        Mosaic.setColor(rowNum,colNum,red,green,blue); // set current sqaure to neighbout colours  
    }  // end changeToRandomColor
    
    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid. 
     * @return Returns int[] array length = 2: [0] = neighbourRow, [1] = neignbourColumn;
     */
    static int[] neighbourCoord() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        int neighbourRow = currentRow; // declare int for neighbour coords
        int neighbourColumn = currentColumn; // declare int for neighbour coords
        int[] coords = {neighbourRow,neighbourColumn};
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
        case 0:  // move up 
        	neighbourRow--;
            if (neighbourRow < 0)
            	neighbourRow = ROWS - 1;
            coords[0] = neighbourRow;
            break;
        case 1:  // move right
        	neighbourColumn++;
            if (neighbourColumn >= COLUMNS)
            	neighbourColumn = 0;
            coords[1] = neighbourColumn;
            break;
        case 2:  // move down
        	neighbourRow ++;
            if (neighbourRow >= ROWS)
            	neighbourRow = 0;
            coords[0] = neighbourRow;
            break;
        case 3:  // move left  
        	neighbourColumn--;
            if (neighbourColumn < 0)
            	neighbourColumn = COLUMNS - 1;
            coords[1] = neighbourColumn;
            break;
        }
        return coords;
        
    }  // end neighbourCoord



}
