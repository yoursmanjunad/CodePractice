//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCust {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{3,2,1} };
        int ans = maximumWealth(arr);
        System.out.println(ans);
    }
    public static int maximumWealth(int[][] accounts) {
        int rowLength = accounts.length;
        int colLength = accounts[0].length;
        int maxWealth = 0;
        int sum;
        for(int i=0; i<rowLength ; i++){
            sum = 0;
            for(int j=0; j<colLength ; j++){
                sum += accounts[i][j];
            }
            if(sum > maxWealth){
                maxWealth = sum;
            }
        }
        return maxWealth;
    }
}
