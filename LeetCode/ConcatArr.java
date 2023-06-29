//https://leetcode.com/problems/concatenation-of-array/
import java.util.Arrays;

public class ConcatArr {
    public static void main(String[] args) {
        int [] arr = {2,3,4,55,1,56,76};
        int[] ans = getConcatenation(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] getConcatenation(int[] nums) {
        int naya = nums.length;
        int[] arr = new int[2*naya];
        for(int i = 0; i < naya; i++){
            arr[i] = nums[i];
            arr[i + naya] = nums[i];
        }
        return arr;

    }
}
