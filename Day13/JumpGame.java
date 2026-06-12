public class JumpGame{
    public static boolean reached(int[] nums){
        int mLen = 0, index = 0, size = nums.length;
        while(index<size){
            if(index>mLen)
                    return false;
            mLen = Math.max(mLen, index+nums[index]);
            index++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(reached(nums1));
        System.out.println(reached(nums2));
    }
}