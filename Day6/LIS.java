import java.util.Arrays;

public class LIS{
    public static int findLength(int[] arr){
        int size = arr.length, mLength = 1;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for(int index=1 ; index<size ; index++){
            for(int comp = 0; comp<index ; comp++){
                if(arr[index]>arr[comp]){
                    dp[index] = Math.max(dp[index], dp[comp]+1);
                }
                mLength = Math.max(mLength, dp[index]);
            }
        }
        return mLength;
    }
    public static void main(String[] args) {
        int[] inp1 = {0,1,0,3,2,3};
        int[] inp2 = {10,9,2,5,3,7,101,18};
        int[] inp3 = {7,7,7,7,7,7};

        System.out.println(findLength(inp1));
        System.err.println(findLength(inp2));
        System.err.println(findLength(inp3));
    }
}