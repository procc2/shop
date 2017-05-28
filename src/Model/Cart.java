package Model;

import java.util.HashMap;
import java.util.Map;

import Model.Item;

public class Cart {
	private HashMap<Long, Item> cartItems;
	int count;
    public Cart() {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<Long, Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }

    // insert to cart
    public void insertToCart(Long key, Item item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItems.put(key, item);
            count++;
        } else {
            cartItems.put(key, item);
            count++;
        }
    }

    // sub to cart(xoá)
    public void subToCart(Long key, Item item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            	count--;
            if (quantity_old <= 1) {
                cartItems.remove(key);
            } else {
                item.setQuantity(quantity_old - 1);
                cartItems.put(key, item);
            }
        }
    }

    // remove to cart
    public void removeToCart(Long key) {
        boolean check = cartItems.containsKey(key);
        if (check) {
        	count-= cartItems.get(key).getQuantity();
            cartItems.remove(key);
        }
    }

    // count item
    public int countItem() {
        return count;
    }

    // sum total 
    public double totalCart() {
        double count = 0;
        // count = price * quantity
        for (Map.Entry<Long, Item> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
        }
        return count;
    }
}
