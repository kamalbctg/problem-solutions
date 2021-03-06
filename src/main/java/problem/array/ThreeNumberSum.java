package problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. The function should find all triplets in
 * the array that sum up to the target sum and return a two-dimensional array of
 * all these triplets. The numbers in each triplet should be ordered in ascending
 * order, and the triplets themselves should be ordered in ascending order with
 * respect to the numbers they hold.If no three numbers sum up to the target sum,
 * the function should return an empty array.
 * </p>
 * Sample-1:
 * Input: array = [12, 3, 1, 2, -6, 5, -8, 6], sum = 0
 * output: = [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 */
public class ThreeNumberSum {

    //  Complexity  Time: O(n^3) & Space: O(n)
    public static List<Integer[]> bruteForce(int[] array, int sum) {
        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int tmp = array[i] + array[j] + array[k];
                    if (tmp == sum) {
                        triplets.add(new Integer[]{array[i], array[j], array[k]});
                    }
                }
            }
        }
        return triplets;
    }

    //  Complexity  Time: O(n^2) & Space: O(n)
    public static List<Integer[]> twoPointerSlidingWindow(int[] array, int sum) {
        List<Integer[]> triplets = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i;
            int right = array.length - 1;

            while (left < right) {
                int tmpSum = array[i] + array[left] + array[right];

                if (tmpSum == sum) {
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                } else if(tmpSum < sum){
                    left++;
                } else if (tmpSum > sum){
                    right--;
                }
            }
        }
        return triplets;
    }
}
