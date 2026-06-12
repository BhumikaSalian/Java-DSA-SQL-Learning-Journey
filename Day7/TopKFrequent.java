
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent{
    public static void findFreq(int[] nums,int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(int each:nums){
            map.put(each, map.getOrDefault(each, 0)+1);
        }
        for(Map.Entry<Integer,Integer> each : map.entrySet()){
            pq.offer(each);
            if(pq.size()>k)
                pq.poll();
        }
        int[] arr = new int[k];
        for(int index = 0 ; index<k ; index++){
            arr[index] = pq.poll().getKey();
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,1,2,1,2,3,1,3,2};
        int k1 = 2;

        int[] nums2 = {1};
        int k2 = 1;

        int[] nums3 = {1,1,1,2,2,3};

        findFreq(nums1, k1);
        findFreq(nums1, k2);
        findFreq(nums2, k2);
        findFreq(nums3, k2);
    }
}