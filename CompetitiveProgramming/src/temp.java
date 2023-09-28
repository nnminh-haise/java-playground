import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class temp {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2};
        List<List<Integer>> subsets = findSubsets(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        Set<List<Integer>> subsetSet = new HashSet<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsetSet);
        return new ArrayList<>(subsetSet);
    }

    private static void generateSubsets(int[] nums, int start, List<Integer> currentSubset, Set<List<Integer>> subsetSet) {
        subsetSet.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates to avoid duplicate subsets
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, subsetSet);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
