package jedi;

/**
 * Created by aizhan on 10/1/15.
 */
public class CitiesFromCapital {

    public int[] solution(int[] network) {

        int[] distsFromCapital = new int[network.length - 1];
        for(int i=0; i< network.length; ++i) {
            int temp = calcDistFromCapital(i, network, 0);
            int distFromCapital = temp - 1;
            if (distFromCapital >=0) {
                ++distsFromCapital[distFromCapital];
            }
        }

        return distsFromCapital;
    }

    private int calcDistFromCapital(int index, int[] network, int curDist) {
       if(network[index] == index ) {
           return curDist;
       }
        return calcDistFromCapital(network[index], network, ++curDist);
    }

    public static void main(String[] args) {
        int[] data = {9,1,4,9,0,4,8,9,0,1};
        CitiesFromCapital c = new CitiesFromCapital();
        int[] solution = c.solution(data);
        System.out.println(solution.toString());
    }
}
