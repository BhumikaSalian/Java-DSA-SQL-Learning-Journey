import java.util.Arrays;

public class PrefixPostfixViaRecursion{
    public static void pre(int[] og, int[] prefix, int index){
        if(index==0){
            prefix[0] = og[0];
            return;
        }
        pre(og,prefix,index-1);
        prefix[index] = prefix[index-1] + og[index];
    }

    public static void post(int[] og, int[] postfix, int index){
        if(index==og.length-1){
            postfix[index] = og[index];
            return;
        }
        post(og,postfix,index+1);
        postfix[index] = postfix[index+1] + og[index];
    }

    public static void main(String[] args){
        int[] arr = {23,12,98,45,18,45,12,98};
        //int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int[] sumPre = new int[arr.length];
        pre(arr,sumPre,arr.length-1);
        System.out.print("Prefix Sum: ");
        System.out.println(Arrays.toString(sumPre));

        int[] sumPost = new int[arr.length];
        post(arr,sumPost,0);
        System.out.print("Postfix Sum: ");
        System.out.println(Arrays.toString(sumPost));
    }
}