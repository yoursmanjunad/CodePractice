public class SortCol {
    //https://leetcode.com/problems/sort-colors/
    public static void main(String[] args) {
        int[] ans = {1,2,3,4,5,6};
    }
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length -1 ; i++) {
            for (int j = 0; j < nums.length -i -1; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] =temp;
                }
            }
        }
        return;
    }
}
