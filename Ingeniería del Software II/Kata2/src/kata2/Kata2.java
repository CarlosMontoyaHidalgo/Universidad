package kata2;

import java.util.HashMap;

public class Kata2 {

    public static void main(String[] args) {
        int [] data = new int[]{3, 4, 2,1 ,4,6,7,8,6};
        
        
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        
        for (int key : data) {
            
            histogram.put(key, histogram.containsKey(key) ? histogram.get(key) + 1 : 1);
            
        }
        
        for (Integer key : histogram.keySet()) {
            System.out.println(key + "==>" + histogram.get(key));
        }
    }
}
