package alg.data.type.find.union.query;

/**
 * 
 * @author amrmagdy
 * Enhance of Quick Union
 */
public class WeightedQuickUnion extends UF {
	//private int[] id;
	private int[] sizes;
	
	public WeightedQuickUnion(int N) {
		id = new int[N];
		sizes = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sizes[i] =1;
		}	
	}
	
	public int root(int i) {
		while(i != id[i])
			i = id[i];
		return i;
	}

	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		System.out.println("Roots of ("+p+","+q+") is ("+i+","+j+")");
		if(i==j) return;
		
		if(sizes[i]<sizes[j]){
			id[i] = j;
			sizes[j] = sizes[j] + sizes[i];
		}else {
			id[j] = i;
			sizes[i] = sizes[i] + sizes[j];
		}
		
		System.out.println("id[" +root(p)+"]: " + id[i] +"   id[" +root(q)+"]: " +  id[j]);
	}
	
	void printIds(){
		System.out.print("Ids Arr : ");
		for(int i:id)
			System.out.print(i+", ");
		
		System.out.println();
		System.out.print("sizes Arr : ");
		for(int j:sizes)
			System.out.print(j+", ");
	}
	
	

}
