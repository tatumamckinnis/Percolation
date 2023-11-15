import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDefault{

    public PercolationBFS(int n) {
        super(n);

    }
    //when you put an element on the stack, consider this invariant: cells are adjacent and open but not full 
    //pop cell off stack, check neighbors, if neighbors are open and not full, push them onto stack
    //every cell on stack will be open and not full 
    //when pop off, may have to consider making it full like in recursive version 
@Override 
protected void search (int row, int col)
{
    if (! inBounds(row,col)) return;
		
		// full or NOT open, don't process, so when reach recursive calls, know that it will be not full and will be open
		if (isFull(row, col) || !isOpen(row, col)){
			return;
		}

        myGrid [row][col] = FULL;
         Queue<int[]> qp = new LinkedList<>();
       int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};

        qp.add(new int[]{row,col});
        while (qp.isEmpty() == false)
        {
            int[] p = qp.remove();
            for(int k=0; k < rowDelta.length; k++){
                int newRow = p[0] + rowDelta[k];
                int newCol = p[1] + colDelta[k];
                if (inBounds(newRow,newCol) && !isFull(newRow, newCol) && isOpen(newRow, newCol)){
                   myGrid[newRow][newCol] = FULL;
                    qp.add(new int[]{newRow,newCol});
                    
                }
            }
        }

}
}
