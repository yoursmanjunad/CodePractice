//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {44,2,6,2,7,8,21};
        System.out.println(search(arr,7));
    }
    public static int search(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        int mid = (start + end)/2;

        if (target < nums[mid]) {
            for (int i = 0; i <=mid - 1; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else if (target >nums[mid]) {
            for (int i = mid + 1; i <= nums.length - 1; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        else{
            if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}
