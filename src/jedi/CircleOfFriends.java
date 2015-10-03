package jedi;

import java.io.*;
import java.util.*;


/**
 * Created by aizhan on 10/2/15.
 */
public class CircleOfFriends {


    static int friendCircles(String[] friends) {
        if(friends == null) {
            return 0;
        }
        List<Set<Integer>> circles = new ArrayList<Set<Integer>>();
        for(int i=0; i< friends.length; i++) {
            String row = friends[i];
            Set<Integer> rowSet = null;
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j) == 'Y' || row.charAt(j) == 'y') {
                    if(rowSet == null){
                        boolean foundRowSet = false;
                        for(Set set: circles ) {
                            if(set.contains(i)) {
                                rowSet = set;
                                foundRowSet = true;
                                break;
                            }
                        }
                        if(!foundRowSet){
                            rowSet = new HashSet<Integer>();
                            circles.add(rowSet);
                        }
                    }
                    rowSet.add(j);
                }
            }
        }

        Map<Integer, Integer> mapMerge = new HashMap<>();
        int i = 0;
        mergeStart:
        while(i < circles.size()){
            for(int elem: circles.get(i)) {
                if(mapMerge.containsKey(elem)) {
                    int rowNumber = mapMerge.get(elem);
                    circles.get(rowNumber).addAll(circles.get(i));
                    circles.remove(i);
                    i = 0;
                    mapMerge.clear();
                    break mergeStart;

                } else {
                    mapMerge.put(elem, i);
                }
            }
            i++;
        }
        return circles.size();
    }

    public static void main(String args[] ) {
        System.out.println(friendCircles(new String[]{"YYY","YYY","YYY"}));
        System.out.println(friendCircles(new String[]{"YYNN","YYYN","NYYN", "NNNY"}));
        System.out.println(friendCircles(new String[]{"YNNNN","NYNNN","NNYNN", "NNNYN", "NNNNY"}));
        System.out.println(friendCircles(new String[]{"YNY","NYY","YYY"}));
    }

}

