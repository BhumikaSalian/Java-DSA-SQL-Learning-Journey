import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product{
    String itemName;
    int itemPrice;
    @Override
    public String toString(){
        return itemName+" = "+itemPrice+"\n";
    }
    public Product(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
public class DemoStreamPojo{
    public static void streamPojo(){
        List<Product> items = Arrays.asList(
            new Product("SSD",5600),
            new Product("Pendrive",800),
            new Product("Safari Trolley",4500)
        );
        List<String> names = items.stream().map(Product::getItemName).collect(Collectors.toList());
        System.out.println(names);
    }
    public static void main(String[] args) {
        streamPojo();
    }
}