import java.util.ArrayList;
public class ShoppingCart {
    private ArrayList<String> items;
    public ShoppingCart() {
        items = new ArrayList<>();
    }
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " has been added to the shopping cart.");
    }
    public void removeItem(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + " has been removed from the shopping cart.");
        } else {
            System.out.println(item + " is not in the shopping cart.");
        }
    }
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Items in your shopping cart:");
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple");
        cart.addItem("Banana");
        cart.addItem("Laptop");
        cart.displayItems();
        cart.removeItem("Banana");
        cart.displayItems();
        cart.removeItem("Orange");
    }
}
