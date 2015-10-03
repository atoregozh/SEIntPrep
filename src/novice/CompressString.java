package novice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aizhan on 10/2/15.
 */
public class CompressString {
    static String compress(String str) {

        if(str==null || str.equals("")) {
            return str;
        }
        System.out.print("Kesiena");
        int i=0;
        StringBuilder sb = new StringBuilder();
        int spread;
        for(int j=0; j<str.length(); j++) {
            if(str.charAt(j) != str.charAt(i)) {

                sb.append(str.charAt(i));
                spread = j-i;
                if (spread > 1) {
                    sb.append(spread);
                }

                i = j;

            }

            if (j==str.length()-1) {
                sb.append(str.charAt(j));
                spread = j-i+1;
                if (spread > 1) {
                    sb.append(spread);
                }
            }

        }
        String compressedString = sb.toString();
        return compressedString;

    }

    public static void main(String args[] ) {
//        System.out.println(compress("a"));
//        System.out.println(compress(new String("")));
        System.out.println(compress(null));
    }
}

/*
static String compress(String str) {
		if(str == null || str.length() < 1){
			return str;
		}
		StringBuilder sb = new StringBuilder();
		char currentChar = '\u0000';
		char lastChar = '\u0000';
		int previousMark = -1;
		for(int i = 0; i < str.length(); i++){
			currentChar = str.charAt(i);
			if(currentChar != lastChar){
				int count = i - previousMark;
				if(count > 1){
					sb.append(count);
				}
				lastChar = currentChar;
				previousMark = i;
				sb.append(currentChar);
			}
		}
		if(previousMark < str.length() - 1){
			sb.append(str.length() - previousMark);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("aabccd"));
		System.out.println(compress(""));
		System.out.println(compress(null));
		System.out.println(compress("aaaaabcc"));
		System.out.println(compress("abbc"));
	}
 */