import java.util.Arrays;
//https://leetcode.com/problems/contains-duplicate/
public class ContainsDupli {
    public static void main(String[] args) {
        int[] arr = {34,23,12,24,44,54,63};
        boolean ans = containsDuplicate(arr);
        System.out.println(ans);
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
