import java.util.Arrays;
//https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] ans = runningSum(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;

    }
}
