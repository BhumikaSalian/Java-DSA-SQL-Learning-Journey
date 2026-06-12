
import java.util.HashSet;
import java.util.Set;

public class StoneJewels{
    public static int findCount(String jw, String st){
        Set<Character> jSet = new HashSet<>();
        for(char each: jw.toCharArray())
            jSet.add(each);
        int count = 0;
        for(char each: st.toCharArray()){
            if(jSet.contains(each))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String Jewels1 = "aA", Stones1 = "aAAbbbb";
        System.out.println(findCount(Jewels1, Stones1));

        String Jewels2 = "z", Stones2 = "ZZ";
        System.out.println(findCount(Jewels2, Stones2));
    }
}