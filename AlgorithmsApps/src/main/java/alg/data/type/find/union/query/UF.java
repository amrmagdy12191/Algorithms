package alg.data.type.find.union.query;

public abstract class UF {
	
	public int[] id;
	
	
	public abstract boolean connected(int p, int q);
	public abstract void union(int p, int q);
	
	void printIds(){
		System.out.println("Ids Arr : ");
		for(int i:id)
			System.out.print(i+", ");
	}

}
