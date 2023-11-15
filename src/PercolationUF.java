public class PercolationUF implements IPercolate{
private IUnionFind myFinder; 
private boolean [][] myGrid; //intially everything is false, as you open a cell, you make the grid cell true,meaning its open
private final int VTOP; 
private final int VBOTTOM;
private int myOpenCount;
public PercolationUF(IUnionFind finder, int size)
{
    finder.initialize(size *size + 2); 
    myFinder = finder;
    VTOP = size * size; 
    myOpenCount =0; 
    VBOTTOM = size * size + 1;
    myGrid = new boolean [size] [size];
}
private  boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
        if (isOpen(row, col))
        {
           return;
        }
        myGrid[row] [col] = true; 
        myOpenCount ++;
        connectWithOpenNeighbors(row, col); 
        if (row == 0) {
        myFinder.union(col, VTOP);
        }
         if (row == myGrid.length - 1) {
        myFinder.union(row * myGrid.length + col, VBOTTOM);
    }
    }

    
private void connectWithOpenNeighbors(int row, int col) {
    int[] rowDelta = {-1, 1, 0, 0};
    int[] colDelta = {0, 0, -1, 1};

    for (int k = 0; k < rowDelta.length; k++) {
        int newRow = row + rowDelta[k];
        int newCol = col + colDelta[k];

        if (inBounds(newRow, newCol) && isOpen(newRow, newCol)) {
            myFinder.union(row * myGrid.length + col, newRow * myGrid.length + newCol);
        }
    }
}

    @Override
    public boolean isOpen(int row, int col) {
       {
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}
    }

    @Override
    public boolean isFull(int row, int col) {
        	if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		int value = row *myGrid.length + col; 
        if (myFinder.connected(value, VTOP))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VTOP, VBOTTOM); 
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }
    
    
}
