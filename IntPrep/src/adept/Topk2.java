package interview;

import java.lang.Integer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Topk2 {

	static void TopK_NGrams(String[] filenames, int K, int target_year) throws IOException, FileNotFoundException {
		
		TreeMap<Integer, ArrayList<String>> sortedNGrams = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder());

		// First, read in all of the data files
		for (String filename : filenames) {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream ds = new DataInputStream(fstream);
			BufferedReader in = new BufferedReader(new InputStreamReader(ds));

			String buffer;
			while ((buffer = in.readLine()) != null) {
				String[] tokens = buffer.split("\t");

				// Do something reasonable if the input file is corrupt and
				// gives bad data
				if (tokens.length < 3) {
					System.err.println("ERROR: Invalid line: " + buffer);
					continue;
				}
				// Second, build reverse sorted NGrams by frequency for a target year
				// We built this using TreeMap data structure that has number of NGram occurrences for year as Key and list of NGram strings as value
				// e.g. of data structure: "12: $22.50, $2322, 30pound, traet, tilda"
				int year = Integer.parseInt(tokens[1]); // Second column is the year
									
				if (target_year == year) {
					Integer frequency = Integer.parseInt(tokens[2]); // Third column is number of occurrences for year

					String ngram = tokens[0]; // First column is the NGram

					if (sortedNGrams.containsKey(frequency)) {
						sortedNGrams.get(frequency).add(ngram);
					} else {
						ArrayList<String> nGramsList = new ArrayList<String>();
						nGramsList.add(ngram);
						sortedNGrams.put(frequency, nGramsList);
					}
				}
			}
			fstream.close();
		}
		// Fourth, print out the top K words
		int count = 0;
		outer: 
		for (Integer frequency : sortedNGrams.keySet()) {
			for (String nGram : sortedNGrams.get(frequency)) {
				System.out.print(nGram);
				System.out.print('\t');
				System.out.print(frequency);
				System.out.println();

				count++;

				if (count >= K) {
					break outer;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException, FileNotFoundException {
		if (args.length < 3) {
			System.out.println("topk    Usage: ./topk K year file1 [file2 [file3 [...]]]");
			System.out.println("               (for some integers K and year)");
			return;
		}

		int K = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);

		String[] filenames = Arrays.copyOfRange(args, 2, args.length);

		TopK_NGrams(filenames, K, year); // calling static method
	}
}
