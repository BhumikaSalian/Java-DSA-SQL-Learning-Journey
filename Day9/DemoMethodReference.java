import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

public class DemoMethodReference{
    public static void PojoRefer(){
        List<Product> items = Arrays.asList(
            new Product("SSD", 5600), 
            new Product("Pendrive", 800)
        );
        System.out.println("\nPojoRefer Method:");
        items.forEach(System.out::print);
        items.sort(Comparator.comparing(Product::getItemName));
        System.out.println("\nAscending order in terms of name:");
        items.forEach(System.out::print);
    }
    public static void main(String[] args) {
        List<String> skills = Arrays.asList("Spring", "Cypress", "Django", "Jinja", "MUnit", "Active MQ");
        //System.out.println(skills);
        //skills.forEach(skills->System.out.println(skills));
        skills.sort(String::compareTo);
        System.out.println("\nSkills:");
        skills.forEach(System.out::println);
        PojoRefer();
    }
}