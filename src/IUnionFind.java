/**
 * Interface supported by different implementations of UnionFind algorithms.
 * 
 * @author Kevin Wayne
 * @author Owen Astrachan
 * @author Jeff Forbes
 * @date March 2011
 */
//adjacent open cells are in the same set 
//each time we open a grid cell, we find the number it corresponds to 
//getindex to find number associated with cell
//top cell represents anything connected to top 
//bottom cell represents anything connected to bottom 
//18 is adjacent to its neighbors (up down left right)
//union 13 and 18 bc union adjacent open sets - call connect (makes union of those two sets)
//then 18 and 17 and 18 and 23 
//system percolates if vtop is connected to vbottom meaning they are in the same set 
//make 3,3 correspond to cell number 18 (thats the disjoint set it goes with): multiply r*size + c (allows us to create a set number with grid cell)

//check up down left right, union if open
public interface IUnionFind {

	/**
	 * Instantiate N isolated components in [0,N-1]
	 */
	public void initialize(int n);

	/**
	 * Returns number of components (disjoint sets)
	 */
	public int components();

	/**
	 * Returns id of component corresponding to element x
	 */
	public int find(int x);

	/**
	 * Returns true iff p and q are in the same set, false otherwise
	 */
	public boolean connected(int p, int q);

	/**
	 * Replace sets containing p and q with their union i.e., merge sets
	 * containing p and q
	 */
	public void union(int p, int q);
	
	/**
	 * return size
	 * @return
	 */
	public int size();
}
