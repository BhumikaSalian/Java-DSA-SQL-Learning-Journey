
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingMinimum{
    public static void main(String[] args){
        // using collections
        List<Integer> invoices = Arrays.asList(8,10,3,1,4,2,5);
        int mini = Collections.min(invoices);
        while(true){
            int current = mini+1;
            if(invoices.contains(current))
                mini = current;
            else{
                System.out.println("Missing minimum is "+current);
                return;
            }
        }
    }
}