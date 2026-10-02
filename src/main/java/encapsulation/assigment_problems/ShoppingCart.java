package encapsulation.assigment_problems;

import java.util.Arrays;

public class ShoppingCart {

    private final String[] itemIds;
    private final double[] prices;
    private int itemCount;

    public ShoppingCart(int capacity) {
        itemIds = new String[capacity];
        prices = new double[capacity];
        itemCount = 0;
    }

    public void addItem(String itemId, double price) {

        if (itemCount >= itemIds.length) {
            return;
        }

        if (price < 0) {
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            if (itemIds[i].equals(itemId)) {
                return;
            }
        }

        itemIds[itemCount] = itemId;
        prices[itemCount] = price;
        itemCount++;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public String[] getItems() {
        return Arrays.copyOf(itemIds, itemCount);
    }

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart(5);

        cart.addItem("I001", 100.0);
        cart.addItem("I002", 250.0);
        cart.addItem("I003", 150.0);

        // Duplicate item ID - will be rejected
        cart.addItem("I002", 500.0);

        System.out.println("Item Count: " + cart.getItemCount());
        System.out.println("Total: " + cart.getTotal());

        System.out.println("Items: "
                + Arrays.toString(cart.getItems()));
    }
}