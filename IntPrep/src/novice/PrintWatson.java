package interview;

import java.io.*;

public class PrintWatson {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			//System.out.println(s);
			String[] charS = s.split("\\s");
			//System.out.println(N);
			int N = Integer.parseInt(charS[0]);
			int p = Integer.parseInt(charS[1]);
			//System.out.println(p);
			int q = Integer.parseInt(charS[2]);
			//System.out.println(q);

			for (int i = 1; i <= N; i++) {
				
				if (i % q == 0 && i % p == 0) {
					System.out.print("WATSON");
				} else if (i % q == 0 && i != q && !String.valueOf(N).contains(""+ q)) {
					System.out.print("SON");
				} else if (i % p == 0 && i != p && !String.valueOf(N).contains(""+ p)) {
					System.out.print("WAT");
				} else {
					System.out.print(i);
					if(i==N) {
					    System.out.println();
					}
					else {
					    System.out.print(" ");
					 }
				}
			}
	
		}
	}
}
