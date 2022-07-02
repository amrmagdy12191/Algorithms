package alg.data.type.find.union.query;

import java.io.IOException;
import java.util.Scanner;

public class FindUnionQuery {

	public static void main(String[] args) throws IOException {
		Scanner scanner= new Scanner(System.in);
		
		int N= scanner.nextInt();
		//UF uf= new QuickFindUF(N);
		//UF uf = new QuickUnionUF(N);
		UF uf = new WeightedQuickUnion(N);
		
		while(scanner.hasNext()) {
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if(!uf.connected(p, q)) {
				uf.union(p, q);
			//	System.out.println(p + "  " + q);
			}
			uf.printIds();
		}
		scanner.close();
	}

}
