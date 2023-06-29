import java.util.Arrays;
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class SmallerthanCur {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] ans = smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] table = new int[101];
        int[] res = new int[nums.length];
        for(int n : nums){
            table[n]++;
        }
        int sum = 0;
        for(int i = 0; i < 101; i++){
            sum += table[i];
            table[i] = sum;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                res[i] = 0;
            }else{
                res[i] = table[nums[i] - 1];
            }
        }
        return res;
    }
}
