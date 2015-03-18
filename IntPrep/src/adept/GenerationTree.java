package adept;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GenerationTree {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			// System.out.println(s);

			String[] stringsWCommas = s.split(",");
			int genNum = 1;
			ArrayList<ArrayList<String>> familyTree = new ArrayList<ArrayList<String>>();

			for (String sWArrow : stringsWCommas) {
				if (sWArrow.contains("->")) {
					String[] trimmedString = sWArrow.split("->");
					if (familyTree.isEmpty()) {
						ArrayList<String> firstGen = new ArrayList<String>();
						firstGen.add(trimmedString[0]);//add parent
						familyTree.add(firstGen);
						ArrayList<String> childGen = new ArrayList<String>();
						childGen.add(trimmedString[1]);//add child
						familyTree.add(childGen);
					} else { 
						for (int i = 0; i < familyTree.size(); i++) {
							ArrayList<String> parentGen = familyTree.get(i);
							if (parentGen.contains(trimmedString[0])) {//found parent
								ArrayList<String> childGen;
								if (i == familyTree.size() - 1) {//adding new children
									childGen = new ArrayList<String>();
									familyTree.add(childGen);
								} else {
									childGen = familyTree.get(i + 1);
								}
								childGen.add(trimmedString[1]);
								break;
							}
						}
					}
				} else { //last element, number of generation to return
					genNum = Integer.parseInt(sWArrow);
				}
			}
			ArrayList<String> printGen = familyTree.get(genNum - 1);
			Collections.sort(printGen);
			for (int i = 0; i < printGen.size(); i++) {
				System.out.print(printGen.get(i));
				if (i != printGen.size() - 1) {
					System.out.print(",");
				}
			}
		}

	}
}
