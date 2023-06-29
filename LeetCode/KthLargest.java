import java.util.Arrays;
//https://leetcode.com/problems/kth-largest-element-in-an-array/

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {2432,647,43,8,2423,3256};
        int ans = findKthLargest(arr, 647);
    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int h = nums[nums.length-k];
        return h;
    }
}
