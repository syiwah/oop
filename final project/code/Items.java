//NUR ALYA SYAZWINA BINTI SAMSUL BAHRIN
//24000088

import java.util.ArrayList;
import java.util.List;

public class Items {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    private List<Item> itemList;

    public Items() {
        this.itemList = new ArrayList<>();
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public void remove(Item item) {
        itemList.remove(item);
    }

    public void printItems() {
        for (Item item : itemList) {
            System.out.println("Name: " + item.getName() +
                               ", Price: RM " + item.getSupplierPrice() +
                               ", Quantity: " + item.getQuantity() +
                               ", Supplier: " + item.getSupplierName());
        }
    }

    public Item find(String itemName) {
        return itemList.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }
}
