package alg.data.type.find.union.query;

import java.io.IOException;
import java.util.Scanner;

public class FindUnionQueryComplexityWorstCase {

	public static void main(String[] args) throws IOException {
		Scanner scanner= new Scanner(System.in);
		
		int N= scanner.nextInt();
		
//		UF uf= new QuickFindUF(N);
		UF uf = new QuickUnionUF(N);
		
		while(scanner.hasNext()) {
			int p = scanner.nextInt();
			//int q = scanner.nextInt();
			long start = System.currentTimeMillis();
			for(int q = 0; q < uf.id.length; q++) {
			if(!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + "  " + q);
			}
			}
			long end = System.currentTimeMillis();
			
			System.out.println("total : " + (end - start));
			
		}
		scanner.close();
	}
}
