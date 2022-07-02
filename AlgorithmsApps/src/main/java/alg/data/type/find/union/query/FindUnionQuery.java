package alg.data.type.find.union.query;

import java.io.IOException;
import java.util.Scanner;

/*
 * WeightedQuickUnion is the best performance (find, Union)
 * PathCopressionWeightedQuickUnion is good to mention root that we don't have any restriction prevent that to enhance find during union
 * Quick Union is good for initialization of connection but high cost for find
 * Quick Find is high performance for find of connection but high cost for initialization
 */
public class FindUnionQuery {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter Number Array size");
		
		Scanner scanner= new Scanner(System.in);
		
		int N= scanner.nextInt();
		//UF uf= new QuickFindUF(N);
		//UF uf = new QuickUnionUF(N);
		//UF uf = new WeightedQuickUnion(N);
		UF uf = new PathCompressionWeightedQU(N);
		System.out.println("Enter two nodes to connect ");
		while(scanner.hasNext()) {
			
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if(!uf.connected(p, q)) {
				uf.union(p, q);
			//	System.out.println(p + "  " + q);
			}
			uf.printIds();
			System.out.println("Enter two nodes to connect ");
		}
		scanner.close();
	}

}
