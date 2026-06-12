public class MostWater {
    public static int maxWater(int[] arr){
        int left = 0, right = arr.length-1, mArea = 0, tArea;
        while(left<right){
            int wid = right - left;
            tArea = Math.min(arr[left], arr[right])*wid;
            mArea = Math.max(mArea, tArea);
            if(arr[left]<arr[right])
                left++;
            else
                right--;
        }
        return mArea;
    }
    public static void main(String[] args) {
        int[] container = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWater(container));
    }
}
