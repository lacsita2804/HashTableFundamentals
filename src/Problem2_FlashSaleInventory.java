import java.util.*;

public class Problem2_FlashSaleInventory {

    static HashMap<String, Integer> stock = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    static boolean purchase(String product, int userId) {
        if (stock.get(product) > 0) {
            stock.put(product, stock.get(product) - 1);
            System.out.println("Purchase success. Remaining: " + stock.get(product));
            return true;
        } else {
            waitingList.add(userId);
            System.out.println("Out of stock. Added to waiting list: " + userId);
            return false;
        }
    }

    public static void main(String[] args) {
        stock.put("IPHONE15", 2);

        purchase("IPHONE15", 101);
        purchase("IPHONE15", 102);
        purchase("IPHONE15", 103);
    }
}