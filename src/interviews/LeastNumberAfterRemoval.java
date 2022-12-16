package interviews;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeastNumberAfterRemoval {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,2,3,1,2,1};
        int[] removal = findRemoval(arr, 3);
        System.out.println("removal is :" + Util.array2Str(removal, 0, removal.length - 1));
    }

    /**
     * find numRemoved elements to remove from array, lead to the least distinct elements remained
     * for [1,2,3,4,1,2,3,1,2,1] and 3 elements removed, method returns [3,2,6]
     * @return positions in original array
     */
    public static int[] findRemoval(int[] array, int numRemoved) {
        // Map<element -> occurrence>
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            ArrayList<Integer> positions = map.get(array[i]);
            if (positions == null) {
                map.put(array[i], new ArrayList<>(Arrays.asList(i)));
            } else {
                positions.add(i);
            }
        }
        List<ArrayList<Integer>> elemPositions = new ArrayList<>(map.values());
        elemPositions.sort((o1, o2) -> o1.size() - o2.size());
        int[] result = new int[numRemoved];
        int filledIdx = 0;
        for (ArrayList<Integer> positions : elemPositions) {
            for (Integer pos : positions) {
                result[filledIdx] = pos;
                filledIdx++;
                if (filledIdx == numRemoved) {
                    return result;
                }
            }
        }
        return result;
    }

}
