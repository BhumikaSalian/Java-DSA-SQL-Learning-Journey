
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product{
    String itemName;
    int itemPrice;
    @Override
    public String toString(){
        return itemName+" = "+itemPrice+"\n";
    }
}
public class DemoLambda{
    public static void PojoLambda() {
        Product P1 = new Product();
        P1.itemName = "HP Pavillion"; P1.itemPrice = 45000;

        Product P2 = new Product();
        P2.itemName = "MacBook"; P2.itemPrice = 120000;

        Product P3 = new Product();
        P3.itemName = "Dell"; P3.itemPrice = 61000;

        List<Product> items = new ArrayList<>();
        items.add(P1); items.add(P2); items.add(P3);
        
        Collections.sort(items,(o1,o2)->o1.itemPrice-o2.itemPrice);
        System.out.println(items);
    }
    public static void main(String[] args) {
        List<Integer> alpha = new ArrayList<>();
        alpha.add(34); alpha.add(78); alpha.add(46); alpha.add(12);
        System.out.println(alpha);
        /*
        Collections.sort(alpha); -> ascending
        Without Lambda:
        Collections.sort(alpha, new Comparator<Integer>(){
            public int compare(Integer i1, Integer 12){
                return i2-i1;
            }
        });
        */
       Collections.sort(alpha,(i1,i2)->i2-i1);
       System.out.println(alpha);
       PojoLambda();
    }
}
