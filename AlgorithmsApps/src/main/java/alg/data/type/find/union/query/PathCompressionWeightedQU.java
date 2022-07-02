package alg.data.type.find.union.query;

public class PathCompressionWeightedQU extends WeightedQuickUnion {

	public PathCompressionWeightedQU(int N) {
		super(N);
	}
	
	public int root(int i) {
		while(i != id[i]) {
			id[i] = id[id[i]]; // get grandparent id and set it to id until reach root
			i = id[i];
		}
			
		return i;
	}


}
