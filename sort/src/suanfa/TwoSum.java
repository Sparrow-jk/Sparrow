package suanfa;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(8);


        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 5};
        int target = 16;

        int[] result = twoSum(nums, target);

        for (int i : result) {
            System.out.println(i);
        }

    }
}
