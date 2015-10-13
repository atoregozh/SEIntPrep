package novice;

/**
 * Created by aizhan on 10/12/15.
 */
public class HubSpot1 {

    static int findDuplicates(int[] v) {
        if(v == null || v.length < 2) {
            return 0;
        }

        int prevNum = v[0];
        int duplicates = 0;
        Integer lastDuplicate = null;
        for(int i=1; i<v.length; ++i) {
            int currentNum = v[i];
            if(currentNum == prevNum && (lastDuplicate == null || currentNum != lastDuplicate)) {
                lastDuplicate = currentNum;
                duplicates++;
            }
            prevNum = currentNum;
        }
        return duplicates;
    }

    public static void main(String [] args){
//        System.out.println(null != new Integer(2));
        System.out.println(findDuplicates(new int[] {2,2,3}));
    }

}
