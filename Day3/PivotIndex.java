/*import java.util.Arrays;

public class PivotIndex{
    public static void main(String[] args){
        int[] alpha = {1,7,3,6,5,6};
        //int[] alpha = {2,1,-1};
        int presum = 0, postsum = 0, size = alpha.length;
        for(int index = 0 ; index<size ; index++){
            int[] subArray = Arrays.copyOfRange(alpha, index+1, size);
            postsum = Arrays.stream(subArray).sum();
            if(presum == postsum){
                System.out.println(index);
                break;
            }
            presum += alpha[index];
        }
    }
}*/

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] alpha = {1, 7, 3, 6, 5, 6};
        int presum = 0;
        int size = alpha.length;

        for (int index = 0; index < size; index++) {
            int[] subArray = Arrays.copyOfRange(alpha, index + 1, size);
            int postsum = Arrays.stream(subArray).sum();
            if (presum == postsum) {
                System.out.println(index);
                return;
            }
            presum += alpha[index];
        }
        System.out.println(-1);
    }
}