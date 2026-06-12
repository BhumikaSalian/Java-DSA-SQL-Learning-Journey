import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingPositive{
    public static void main(String[] args) {
        //int[] arr = {0,1,2};
        int[] arr = {1,1,7,8,};
        Set<Integer> nums = new HashSet<>();
        Arrays.stream(arr).forEach(nums::add);
        int found = IntStream.range(1, Integer.MAX_VALUE).
            filter(pos->!nums.contains(pos)).findFirst().getAsInt();
        System.out.println(found);
    }
}