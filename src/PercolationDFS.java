import java.util.Stack;

public class PercolationDFS extends PercolationDefault{

    public PercolationDFS(int n) {
        super(n);
        
    }
    @Override 
    protected void search (int row, int col)
{if (! inBounds(row,col)) return;
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
// full or NOT open, don't process, so when reach calls, know that it will be not full and will be open
		if (isFull(row, col) || !isOpen(row, col)){
			return;
		}
    myGrid[row][col] = FULL;  // mark grid
        Stack<int[]> stack = new Stack<>();
       
        stack.push(new int[]{row,col});
        while (!stack.isEmpty()){
            int[] coords = stack.pop();
            for(int k=0; k < rowDelta.length; k++){
                 row = coords[0] + rowDelta[k];
                col = coords[1] + colDelta[k];
                if (inBounds(row,col) && !isFull(row, col) && isOpen(row, col))
                {
                    myGrid[row][col] = FULL;
                    stack.push(new int[]{row,col});
                    
                }
            }
        }
    }

}
